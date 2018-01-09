// change to tp8, rdm here ahs already changed
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

:print
	$1F
	btn	
	7segdup
	$1f
	btn
	$10
	->
	7seg
;

: main
	0
	dup
	begin
		swap
		tirage
		swap
		inc
		dup
	$10000
	=
 	until
	pop
	print
;
start	
	main
endprogram
