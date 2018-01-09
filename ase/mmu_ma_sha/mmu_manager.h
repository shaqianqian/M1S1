
extern void user_process();

struct vm_mapping_s {
  unsigned int ppage : 8;
  unsigned int loaded : 1;
};

struct pm_mapping_s {
  unsigned int vpage : 12;
  unsigned int loaded : 1;
};

/* Page virtuelle vers page physique */
static struct vm_mapping_s vm_mapping[VM_PAGES];
/* Page physique vers page virtuelle */
static struct pm_mapping_s pm_mapping[PM_PAGES];

static int current_page = 1;

void mmu_handler();

