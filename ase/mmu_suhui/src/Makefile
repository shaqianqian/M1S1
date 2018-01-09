ROOTDIR=..

CC	=  gcc
CFLAGS	= -Wall -Werror -ansi -pedantic -m32
CFLAGS  += -std=iso9899:1999
CFLAGS  += -g
LIBDIR  =  $(ROOTDIR)/lib
INCDIR  =  -I$(ROOTDIR)/include
CFLAGS  += -I$(INCDIR)
LIBS    = -L$(LIBDIR) -lhardware

###------------------------------
### Main targets 
###------------------------------------------------------------
BINARIES= mi_kernel mmu_manager oracle
OBJECTS	= $(addsuffix .o,\
	  mi_kernel mi_user swap mi_hardware mmu_manager user_process matrix oracle)

all: $(BINARIES) $(OBJECTS)


###------------------------------
### Main rules 
###------------------------------------------------------------

# Objects

mi_kernel.o: mi_kernel.c
	$(CC) $(CFLAGS) -c mi_kernel.c $(INCDIR)

mi_user.o: mi_user.c
	$(CC) $(CFLAGS) -c mi_user.c $(INCDIR)

swap.o: swap.c
	$(CC) $(CFLAGS) -c swap.c $(INCDIR)

mi_hardware.o: mi_hardware.c
	$(CC) $(CFLAGS) -c mi_hardware.c $(INCDIR)

mmu_manager.o: mmu_manager.c
	$(CC) $(CFLAGS) -c mmu_manager.c $(INCDIR)

user_process.o: user_process.c
	$(CC) $(CFLAGS) -c user_process.c $(INCDIR)

matrix.o: matrix.c
	$(CC) $(CFLAGS) -c matrix.c $(INCDIR)

oracle.o: oracle.c
	$(CC) $(CFLAGS) -c oracle.c $(INCDIR)

# Binaries

mi_kernel: mi_kernel.o mi_user.o mi_hardware.o
	$(CC) $(CFLAGS) -o mi_kernel mi_kernel.o mi_user.o mi_hardware.o $(LIBS)

mmu_manager: mmu_manager.o user_process.o matrix.o swap.o mi_hardware.o
	$(CC) $(CFLAGS) -o mmu_manager mmu_manager.o user_process.o matrix.o swap.o mi_hardware.o $(LIBS)

oracle: oracle.o matrix.o
	$(CC) $(CFLAGS) -o oracle oracle.o matrix.o $(LIBS)

###------------------------------
### Misc.
###------------------------------------------------------------
.PHONY: clean realclean depend
clean:
	$(RM) *.o $(BINARIES)
realclean: clean 
depend : 
	$(CC) $(CFLAGS) -MM $(INCDIR) *.c 

