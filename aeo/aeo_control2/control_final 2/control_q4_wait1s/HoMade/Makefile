all:test

init:
	echo "wanml123" | sudo -S chmod 666 /dev/ttyUSB0
	chmod +x q4.sh
test:
	./q4.sh
clean:
	rm -rf *.hmd *.isim *.vhd
