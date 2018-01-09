//
slave 
start

master

:IP rdm $9010
;
:IP square2 $C814
;
: tirage
	rdm
	square2
	$ffe001
	<=
	if
		inc
	else
	endif
;

:print
	$1f
	btn
	7segdup
	$1f
	btn
	$10
	->
	7seg
;

: main
	$0
	$10000
	for
		tirage
	next
	print
;
start	
	main
endprogram
