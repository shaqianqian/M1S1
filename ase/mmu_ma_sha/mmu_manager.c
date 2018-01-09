#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include "mi.h"
#include "hardware.h"
#include "swap.h"
#include "mmu_manager.h"

static void empty_it() {
  return;
}
void initialize() {

	int i;
	/* init hardware */
	if (init_hardware("hardware.ini") == 0) {
	        fprintf(stderr, "Error in hardware initialization\n");
	        exit(EXIT_FAILURE);
	}
    	/* Interrupt handlers */
    	for (i = 0; i < 16; i++)
        	IRQVECTOR[i] = empty_it;
	IRQVECTOR[MMU_IRQ] = mmu_handler;
}

void mmu_handler() {
  union tlb_entry_u tlbe;
  unsigned int vpage;
  unsigned int ppage;
  vpage = _in(MMU_FAULT_ADDR);
  assert(vpage >=(unsigned int) virtual_memory && vpage < (unsigned int) virtual_memory + VM_SIZE);
  vpage = vpage>>12&0xfff;
 
  if(vm_mapping[vpage].loaded){
    ppage = vm_mapping[vpage].ppage;
  } else { /* si la page n'est pas chargée */

    /* Round robin */
    ppage = (current_page++);

    if(current_page >= PM_PAGES){
      ppage = 1;
    }

    /* Il y avait une pagé chargé à cette emplacement, faut la save*/
    if(pm_mapping[ppage].loaded){
      store_to_swap(pm_mapping[ppage].vpage, ppage);
      vm_mapping[pm_mapping[ppage].vpage].loaded = 0;
    }
    tlbe.tlb_s.ppage = ppage;
    _out(TLB_DEL_ENTRY, tlbe.i);

    /* On peut maintenant aller récuperer la page */
    fetch_from_swap(vpage, ppage);

    /* et actualiser les tables de mapping */
    vm_mapping[vpage].ppage = ppage;
    vm_mapping[vpage].loaded = 1;
    pm_mapping[ppage].vpage = vpage;
    pm_mapping[ppage].loaded = 1;
  }

 
  tlbe.tlb_s.ppage = ppage;
  tlbe.tlb_s.vpage = vpage;
  tlbe.tlb_s.exec = 1 ;
  tlbe.tlb_s.read = 1;
  tlbe.tlb_s.write = 1;
  tlbe.tlb_s.used=1;

  _out(TLB_ADD_ENTRY, tlbe.i);
}


int main(int argc, char **argv) {
  initialize();

  init_swap(); 

  _mask(0x1001);

  user_process();

  return 0;
}
