//
slave 
start

master

:IP rdm $9010
;
:IP square2 $C814
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
	print
;
start	
	main
endprogram
