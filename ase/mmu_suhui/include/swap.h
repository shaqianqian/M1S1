#include <stdio.h>

#define SWAP_FILE "swap"

FILE *swap_file;
char init_swap(const char *path);
char store_to_swap(int vpage, int ppage);
char fetch_from_swap(int vpage, int ppage);
