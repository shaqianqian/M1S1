#include <assert.h>
#include <string.h>
#include <stdlib.h>
#include "swap.h"
#include "mi_hardware.h"
#include "mi_syscall.h"
#include "hardware.h"
#include "hw_config.h"

extern void user_process();

unsigned int ppage_to_swap = 1;
/* ppage_to_swap correspond à la prochaine page physique à sacrifier pour mettre une nouvelle page virtuelle */

unsigned int vm_mapping[VM_PAGES], pm_mapping[PM_PAGES];

void init_mapping(unsigned int *vm_mapping, unsigned int *pm_mapping) {
	int i;
	struct tlb_entry_s tlbent;

	for(i = 1; i < PM_PAGES; i++) {
		pm_mapping[i] = VM_PAGES;
	}

	for(i = 0; i < VM_PAGES; i++) {
		vm_mapping[i] = PM_PAGES;
	}

	for(i = 0; i < TLB_ENTRIES; i++) {
		*((int*)(&tlbent)) = _in(TLB_ENTRIES * i);
		if(tlbent.ppage != 0) {
			/* Débogage
			fprintf(stderr, "Entree n°%d dans la TLB :\n", i);
			fprintf(stderr, "tlbent.vpage = %d\n", tlbent.vpage);
			fprintf(stderr, "tlbent.ppage = %d\n", tlbent.ppage); */
			pm_mapping[tlbent.ppage] = tlbent.vpage;
			vm_mapping[tlbent.vpage] = tlbent.ppage;
		}
	}

}

/* Fonction permettant d'ajouter une nouvelle entrée TLB */
void addTLB(unsigned int vpage, unsigned int ppage) {
	struct tlb_entry_s tlbent;
	tlbent.ppage = ppage;
	tlbent.vpage = vpage;
	tlbent.exec = 1;
	tlbent.read = 1;
	tlbent.write = 1;
	tlbent.used = 1;
	tlbent.rfu = 0;
	assert(sizeof(int) == sizeof(struct tlb_entry_s));
	_out(TLB_ADD_ENTRY, *((int*)(&tlbent)));
}

/* Fonction permettant d'oublier l'ancienne entrée TLB */
void delTLB(unsigned int vpage, unsigned int ppage) {
	struct tlb_entry_s tlbent;
	tlbent.vpage = vpage;
	tlbent.ppage = ppage;
	_out(TLB_DEL_ENTRY, *((int*)&tlbent));
}

void swap(unsigned int vpage) {
	/* Récuperer la page virtuelle correspondant à la page physique que l'on veut sacrifier */
	unsigned int vpage_to_swap = pm_mapping[ppage_to_swap];

	/* Sauver la page en swap */
	store_to_swap(vpage_to_swap, ppage_to_swap);

	/* Oublier l'ancienne entrée TLB */
	delTLB(vpage_to_swap, ppage_to_swap);

	/* Charger la page du swap */
	fetch_from_swap(vpage, ppage_to_swap);

	/* Ajouter la nouvelle entrée TLB */
	addTLB(vpage, ppage_to_swap);
}

/* Fonction permettant de calculer la page virtuelle à laquelle on essaie d'accéder */
int calcVPage() {
	unsigned int vaddr;
	
	vaddr = _in(MMU_FAULT_ADDR);
	if((unsigned int)virtual_memory <= (unsigned int)vaddr && (unsigned int)vaddr < (unsigned int)virtual_memory + VM_SIZE)
		return (vaddr - (unsigned int)virtual_memory) >> 12;

	return VM_PAGES;
}

/* Fonction qui retourne la prochaine page physique à sacrifier (algorithme de Round Robin) */
void nextPPage() {
	if(ppage_to_swap + 1 != PM_PAGES)
		ppage_to_swap = ppage_to_swap + 1;
	else
		ppage_to_swap = 1;
}

/* NE PLUS UTILISER
static void mmuhandler1() {
	unsigned int vpage;

	if((vpage = calcVPage()) != VM_PAGES)
		swap(vpage);
}*/

static void mmuhandler2() {
	unsigned int ppage, vpage;

	if((vpage = calcVPage()) != VM_PAGES) {

		/* Si une page physique correspond à cette page virtuelle */
		if((ppage = vm_mapping[vpage]) != PM_PAGES) {
			addTLB(vpage, ppage);
		} else {
			/* Sinon, sacrifier une page physique pour cette page virtuelle */
			swap(vpage);

			/* Mettre à jour les tables de correspondance page virtuelle-page physique et page physique-page virtuelle */
			vm_mapping[pm_mapping[ppage_to_swap]] = PM_PAGES;
			pm_mapping[ppage_to_swap] = vpage;
			vm_mapping[vpage] = ppage_to_swap;

			nextPPage(); // Obtenir la prochaine page physique à sacrifier
		}

	}

}

int main(int argc, char **argv) {
	configHardware();
	IRQVECTOR[MMU_IRQ] = mmuhandler2;

	init_swap(SWAP_FILE);

	init_mapping(vm_mapping, pm_mapping);

	_mask(0x1001); // Passer en mode utilisateur

	user_process();

	return 0;
}

