all:test

init:
	echo "123456" | sudo -S chmod 666 /dev/ttyUSB0
	chmod +x question3.sh
test:
	./question3.sh
clean:
	rm -rf *.hmd *.isim *.vhd
