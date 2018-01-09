#!/bin/sh

cd ..
export CLASSPATH=../v6.1.1/antlr-4.5-complete.jar:.:$CLASSPATH
cd v6.1.1
#java HV6 ../HoMade/fibo_1.fsh
#java HV6 ../HoMade/fibo_2.fsh
java HV6 ../HoMade/fibo_3.fsh
cd ..
djtgcfg -d Nexys3 prog -i 0 -f Nexys3v6.bit

#cat HoMade/fibo_1.hmd > /dev/ttyUSB0
#cat HoMade/fibo_2.hmd > /dev/ttyUSB0
cat HoMade/fibo_3.hmd > /dev/ttyUSB0
