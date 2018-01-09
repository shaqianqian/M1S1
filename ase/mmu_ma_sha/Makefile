###------------------------------
### Main targets 
###------------------------------------------------------------
BINARIES= mi mmu_manager oracle
OBJECTS	= $(addsuffix .o,\
	  mi swap mmu_manager user_process matrix oracle)

all: $(BINARIES) $(OBJECTS)
###------------------------------
### Main rules 
###---------------------tp9---------------------------------------
# Objects

mi.o: mi.c
	gcc -c mi.c -m32 -g -pthread
# Binaries

mi: mi.o
	gcc -o mi mi.o -m32 -g lib/libhardware.a -m32 -g -pthread
###----------------------------------------------------------------
##-----------------------------------------------------------------------
###---------------------tp10--------------------------------------
swap.o: swap.c
	gcc -c swap.c -m32 -g -pthread
matrix.o: matrix.c
	gcc -c matrix.c -m32 -g -pthread
oracle.o: oracle.c
	gcc -c oracle.c -m32 -g -pthread
mmu_manager.o: mmu_manager.c
	gcc -c mmu_manager.c -m32 -g -pthread
user_process.o: user_process.c
	gcc -c user_process.c -m32 -g -pthread
###---------------------------------------------------------------
mmu_manager: mmu_manager.o user_process.o matrix.o swap.o 
	gcc -o mmu_manager mmu_manager.o user_process.o matrix.o swap.o -m32 -g lib/libhardware.a -m32 -g -pthread

oracle: oracle.o matrix.o
	gcc -o oracle oracle.o matrix.o -m32 -g lib/libhardware.a -m32 -g -pthread

###------------------------------
### Misc.
###------------------------------------------------------------
.PHONY: clean realclean depend
clean:
	$(RM) *.o $(BINARIES) *.bin
realclean: clean 
depend : 
	$(CC) $(CFLAGS) -MM $(INCDIR) *.c 

