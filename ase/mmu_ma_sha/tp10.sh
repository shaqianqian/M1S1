make
echo "--------------------------------------------------------"
./mmu_manager|./oracle
echo "--------------------------------------------------------"
./mmu_manager | tee /dev/stderr | ./oracle
