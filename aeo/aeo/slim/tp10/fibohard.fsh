//
slave 
start

master
//10101100 03
:IP fibo $AC03
;
: main
begin

		$1F
		btn
		switch
		dup
		2
		>
		if
			$1F
			btn
			fibo
		else
			$1f
			btn
			dup
			2
			=
			if
				drop
				1
			endif
		endif
		7seg
		$1F
		btn
again
;

start 

main

endprogram
