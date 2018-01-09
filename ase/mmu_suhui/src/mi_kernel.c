#include <stdlib.h>
#include <stdio.h>
#include <assert.h>
#include "hardware.h"
#include "mi_syscall.h"
#include "mi_hardware.h"
#include "hw_config.h"

static int current_process = 0;

static void switch_to_process0(void) {
    current_process = 0;
    _out(MMU_CMD, MMU_RESET);
}

static void switch_to_process1(void) {
    current_process = 1;
    _out(MMU_CMD, MMU_RESET);
}

static int ppage_of_vaddr(int process, unsigned vaddr) {
	unsigned vpage;

	if(vaddr < (unsigned int)virtual_memory || vaddr >= (unsigned int)virtual_memory + N/2 * PAGE_SIZE)
		return -1;
	
	vpage = vaddr >> 12;

	return vpage + 1 + N/2 * process;
}

static void mmuhandler() {
	struct tlb_entry_s tlbent;
	unsigned ppage;
	unsigned vaddr = _in(MMU_FAULT_ADDR);
	ppage = ppage_of_vaddr(current_process, vaddr);
	assert(ppage != -1);
	tlbent.ppage = ppage;
	tlbent.vpage = vaddr >> 12;
	tlbent.exec = 1;
	tlbent.read = 1;
	tlbent.write = 1;
	tlbent.used = 1;
	assert(sizeof(int) == sizeof(struct tlb_entry_s));
	_out(TLB_ADD_ENTRY, *((int*)(&tlbent)));
}

int main(int argc, char **argv) {
    configHardware();

	IRQVECTOR[MMU_IRQ] = mmuhandler;
	IRQVECTOR[SYSCALL_SWITCH_0] = switch_to_process0;
    IRQVECTOR[SYSCALL_SWITCH_1] = switch_to_process1;
    _mask(0x1001); // Passer en mode utilisateur

	init();
	
	return 0;
}
