// rdm software

slave 
start

master
:starter
	$1f
	btn
;
:print
	7seg
	$1f
	btn
;
:first
//r(0) xor r(2)
	dup
	2
	->
	xor2
	>0 
;
:second
//(r(0)xor r(2)) xor r(3)
	dup
	3
	->
	0>
	xor2
	>0 
;
:third
//((r(0)xor r(2)) xor r(3)) xor r(4)
	dup
	4
	->
	0>
	xor2
	>0
;
:rdm
//concat it with r(31 downto 1)
	dup
	first
	second
	third
	0>
	31
	<-
	swap
	1
	->
	or
;

:main
	starter
	ticraz
	$80000000
	dup
	50 0
	do
	 	rdm
	loop
	rdm
	tic
	print
	print
;

start	
	main
endprogram
