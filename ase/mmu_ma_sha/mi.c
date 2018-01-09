#include <stdlib.h>
#include <stdio.h>
#include <string.h>
#include <assert.h>
#include "hardware.h"
#include "mi.h"

static int current_process = 0;

void empty_it() {
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
	IRQVECTOR[MMU_IRQ] = mmuhandler;
}
static int ppage_of_vpage(int process, unsigned vpage) {
	if(vpage > (unsigned int)virtual_memory && vpage < (unsigned int)virtual_memory + N/2 * PAGE_SIZE){
		vpage = vpage >> 12&0xfff;
		return vpage + 1 + N/2 * process;
	}
	else{
		return -1;
	}
}
static void mmuhandler() {
	union tlb_entry_u tlbe;
	unsigned ppage;
	unsigned vaddr = _in(MMU_FAULT_ADDR);
	ppage = ppage_of_vpage(current_process, vaddr);
	tlbe.tlb_s.ppage = ppage;
	tlbe.tlb_s.vpage = vaddr >> 12;
	tlbe.tlb_s.exec = 1;
	tlbe.tlb_s.read = 1;
	tlbe.tlb_s.write = 1;
	tlbe.tlb_s.used = 1;
	_out(TLB_ADD_ENTRY,tlbe.i);
}
static int 
sum(void *ptr) 
{
    int i;
    int sum = 0;
    
    for(i = 0; i < PAGE_SIZE * N/2 ; i++)
        sum += ((char*)ptr)[i];
    return sum;
}

static void 
switch_to_process0(void) 
{
    current_process = 0;
    _out(MMU_CMD, MMU_RESET);
}

static void
switch_to_process1(void) 
{
    current_process = 1;
    _out(MMU_CMD, MMU_RESET);
}

int main(int argc, char **argv) {
    void *ptr;
    int res;
    initialize();
    IRQVECTOR[16] = switch_to_process0;
    IRQVECTOR[17] = switch_to_process1;
    _mask(0x1001);

    ptr = virtual_memory;

    _int(16);
    memset(ptr, 1, PAGE_SIZE * N/2);
    _int(17);
    memset(ptr, 3, PAGE_SIZE * N/2);

    _int(16);
    res = sum(ptr);
    printf("Resultat du processus 0 : %d\n",res);
    _int(17);
    res = sum(ptr);
    printf("Resultat processus 1 : %d\n",res);
}
