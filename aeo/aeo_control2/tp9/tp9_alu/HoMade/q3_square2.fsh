//
slave 
start

master

:IP rdm $9010
;
:IP square2 $C814
;

: main
	0
	0
	begin
		swap
		rdm
		square2
		$ffe001
		<=
		if
			inc
		else
		endif
		swap
		inc
		dup
		$10000
		=
 	until
	pop
	$1f
	btn
	7seg
	$1f
	btn
	
;
start	
	main
endprogram
