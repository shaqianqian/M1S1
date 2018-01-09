#!/bin/sh

cd ..
export CLASSPATH=../v6.1.1/antlr-4.5-complete.jar:.:$CLASSPATH
cd v6.1.1
java HV6 ../HoMade/q1_spmd.fsh
#java HV6 ../HoMade/registre_slave.fsh

cd ..
djtgcfg -d Nexys3 prog -i 0 -f Nexys3v6.bit
cat HoMade/q1_spmd.hmd > /dev/ttyUSB0
#cat HoMade/registre_slave.hmd > /dev/ttyUSB0
#cat HoMade/TP11_PROF.hmd > /dev/ttyUSB0
