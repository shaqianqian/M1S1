#!/bin/sh

cd ..
export CLASSPATH=../v6.1.1/antlr-4.5-complete.jar:.:$CLASSPATH
cd v6.1.1
#java HV6 ../HoMade/q1_begin.fsh
#java HV6 ../HoMade/q2_rdm.fsh
java HV6 ../HoMade/q3_square2.fsh
#java HV6 ../HoMade/q4_alu.fsh

cd ..
djtgcfg -d Nexys3 prog -i 0 -f Nexys3v6.bit
#cat HoMade/q1_begin.hmd > /dev/ttyUSB0
#cat HoMade/q2_rdm.hmd > /dev/ttyUSB0
cat HoMade/q3_square2.hmd > /dev/ttyUSB0
#cat HoMade/q4_alu.hmd > /dev/ttyUSB0
