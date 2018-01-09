//
:IP fibohard $AC03
;
slave
start
master
vc fibo_dynamic
//
: fibosoft
	1
	1
	switch
	3
	-
	for
		dup
		-rot
		add
	next	
;

: main
begin 
	$1f
	btn  	
	%11111
	btnpush
	dup
	%00001 
	=
	if
		pop
		%00000001
		led
		fibo_dynamic:=fibosoft
	else
		%00100
		=		
		if
			%00000010
			led
			switch
			fibo_dynamic:=fibohard
		endif
	endif
	fibo_dynamic
	7seg 
	$1f 
	btn
again
;
start
main
endprogram
