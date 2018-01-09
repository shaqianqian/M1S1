#define SYSCALL_SWITCH_0 16
#define SYSCALL_SWITCH_1 17
#define N 254

struct tlb_entry_s {
	unsigned rfu:8;
	unsigned vpage:12;
	unsigned ppage:8;
	unsigned exec:1;
	unsigned write:1;
	unsigned read:1;
	unsigned used:1;
};

void init();
