//
slave 
start

master

:IP rdm $9010
;

: tirage
	rdm
	dup
	mul16
	swap
	dup
	mul16
	add
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
	dup
	add
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
