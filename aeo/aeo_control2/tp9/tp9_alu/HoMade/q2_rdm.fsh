//
slave 
start

master

:IP rdm $9010
;

: main
	0
	0
	begin
		swap
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
		swap
		inc
		dup
		$10000
		=
 	until
	pop
	$1f
	btn
	dup
	add
	7seg
	$1f
	btn
	
;
start	
	main
endprogram

