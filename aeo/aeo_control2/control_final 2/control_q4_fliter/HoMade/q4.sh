#!/bin/sh
echo "----------------Type make test for start------------------"
cd ..
export CLASSPATH=../v6.1.1/antlr-4.5-complete.jar:.:$CLASSPATH
cd v6.1.1
java HV6 ../HoMade/q4.fsh

cd ..
djtgcfg -d Nexys3 prog -i 0 -f Nexys3v6.bit
cat HoMade/q4.hmd > /dev/ttyUSB0
