#!/bin/sh

cd ..
export CLASSPATH=../v6.1.1/antlr-4.5-complete.jar:.:$CLASSPATH
cd v6.1.1
#java HV6 ../HoMade/fibohard.fsh
java HV6 ../HoMade/fibo_dyn.fsh
cd ..
djtgcfg -d Nexys3 prog -i 0 -f Nexys3v6.bit
#cat HoMade/fibohard.hmd > /dev/ttyUSB0
cat HoMade/fibo_dyn.hmd > /dev/ttyUSB0
