slave 
start

master

:IP rdm $8810
;

: tirage
	rdm
	dup
	$00000fff
	and
	swap
	$00fff000
	and
	$c
	->
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

: print
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

	ticraz
	$0
	999999
	for
		tirage
	next
	tic
	swap
	print
	print
;
start	
	main
endprogram
