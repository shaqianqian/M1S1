#include <string.h>
#include <stdio.h>
#include "hardware.h"
#include "mi_syscall.h"
#include "hw_config.h"

int sum(void *ptr) {
    int i;
    int sum = 0;
    
    for(i = 0; i < PAGE_SIZE * N/2 ; i++)
        sum += ((char*)ptr)[i];
    return sum;
}

void init() {
    void *ptr;
    int res;

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
    printf("Resultat du processus 1 : %d\n",res);
}
