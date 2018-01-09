#!/bin/sh

cd ..
export CLASSPATH=../v6.1.1/antlr-4.5-complete.jar:.:$CLASSPATH
cd v6.1.1
#java HV6 ../HoMade/test_led.fsh
#java HV6 ../HoMade/add16.fsh
#java HV6 ../HoMade/random.fsh
java HV6 ../HoMade/pi.fsh
cd ..
djtgcfg -d Nexys3 prog -i 0 -f Nexys3v6.bit
#cat HoMade/test_led.hmd > /dev/ttyUSB0
#cat HoMade/add16.hmd > /dev/ttyUSB0
#cat HoMade/random.hmd > /dev/ttyUSB0
cat HoMade/pi.hmd > /dev/ttyUSB0
