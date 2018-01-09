//
slave 
start

master

: main
	0
	dup
	begin
		swap
		2
		+
		swap
		inc
		dup
		
	3
	=
	until
	7seg
	$1f
	btn
	7seg
	$1f
	btn
;
start	
	main
endprogram
