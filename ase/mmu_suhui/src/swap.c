#include <string.h>
#include "swap.h"
#include "hw_config.h"
#include "hardware.h"

char init_swap(const char *path) {
	swap_file = fopen(path, "w+");
	if(swap_file == NULL)
		return -1;
	else
		return 0;
}

char store_to_swap(int vpage, int ppage) {

	if(0 == fseek(swap_file, vpage * PAGE_SIZE, SEEK_SET)) {

		if(0 == fwrite((void*)((unsigned int)physical_memory + ppage * PAGE_SIZE), PAGE_SIZE, 1, swap_file))
			return -1;

		return 0;
	}

	return -1;
}

char fetch_from_swap(int vpage, int ppage) {

	if(NULL == memset((void*)((unsigned int)physical_memory + ppage * PAGE_SIZE), 0, PAGE_SIZE))
		return -1;

	if(0 == fseek(swap_file, vpage * PAGE_SIZE, SEEK_SET)) {

		if(0 == fread((void*)((unsigned int)physical_memory + ppage * PAGE_SIZE), PAGE_SIZE, 1, swap_file))
			return -1;

		return 0;

	}

	return -1;
}
