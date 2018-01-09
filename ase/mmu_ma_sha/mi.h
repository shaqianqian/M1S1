#define SYSCALL_SWITCH_0 16
#define SYSCALL_SWITCH_1 17
#define N 100

#define HARDWARE_INI	"hardware.ini"

#define MMU_IRQ		13
#define MMU_CMD		0x66
#define MMU_FAULT_ADDR 	0xCD
#define TLB_ADD_ENTRY	0xCE
#define TLB_DEL_ENTRY	0xDE
#define TLB_SIZE	32
#define TLB_ENTRIES	0x800

#define PM_PAGES (1 << 8)
#define VM_PAGES (1 << 12)
#define PAGE_SIZE 4096
#define PM_SIZE (4096 * PM_PAGES)
#define VM_SIZE (4096 * VM_PAGES)
union tlb_entry_u{
	struct tlb_entry_s {
		unsigned rfu:8;
		unsigned vpage:12;
		unsigned ppage:8;
		unsigned exec:1;
		unsigned write:1;
		unsigned read:1;
		unsigned used:1;
	}tlb_s;
	int i;
};
static void mmuhandler();
