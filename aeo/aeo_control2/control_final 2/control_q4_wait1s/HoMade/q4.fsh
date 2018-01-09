//1000 0100 1e
//:IP fliter $AC1E
//;

:IP wait1s $841E
;
slave
start

master
:main

$1f
btn
$1234
7segdup
wait1s
$4321
7segdup
wait1s
$5678
7segdup
wait1s
$8765
7segdup
wait1s
$1F btn
;
start
	main
endprogram;

