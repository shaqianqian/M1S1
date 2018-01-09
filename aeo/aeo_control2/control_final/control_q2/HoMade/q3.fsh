//

:IP RGB2hexa $E81C
;
:IP hexa2RGB $B818
;

slave
start

master

:main
$9
inc
7segdup
$1f
btn
$9
inc
inc
7segdup
$1f
btn
$9
inc
inc
inc
7segdup
$1f
btn
RGB2hexa
$808080
or
$1f 
btn
hexa2RGB
7seg
$1f 
btn
7seg
$1f 
btn
7seg
$1f btn
;
start
	main
endprogram;

