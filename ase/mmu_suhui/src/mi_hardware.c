#include <stdlib.h>
#include <stdio.h>
#include "hardware.h"
#include "mi_hardware.h"

void empty_it() {
    return;
}

void configHardware() {

	int i;

	char *envHWConfig = getenv("HW_CONFIG");
	if(envHWConfig == NULL)
		envHWConfig = "../hardware.ini";

	/* init hardware */
    if (init_hardware(envHWConfig) == 0) {
        fprintf(stderr, "Error in hardware initialization\n");
        exit(EXIT_FAILURE);
    }

    /* Interrupt handlers */
    for (i = 0; i < 16; i++)
        IRQVECTOR[i] = empty_it;

}
