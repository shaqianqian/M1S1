#!/bin/sh

cd ..
export CLASSPATH=../v6.1.1/antlr-4.5-complete.jar:.:$CLASSPATH
cd v6.1.1
#java HV6 ../HoMade/hexa2RGB.fsh
java HV6 ../HoMade/RGB2hexa.fsh
cd ..
djtgcfg -d Nexys3 prog -i 0 -f Nexys3v6.bit
#cat HoMade/hexa2RGB.hmd > /dev/ttyUSB0
cat HoMade/RGB2hexa.hmd > /dev/ttyUSB0
