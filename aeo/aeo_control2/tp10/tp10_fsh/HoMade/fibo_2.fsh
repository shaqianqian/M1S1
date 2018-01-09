//
slave 
start

master

: main
begin
	$1f
	btn
	switch
	dup
	2
	=
	if
		drop
		1
	else
		dup
		2
		>
		if
			drop
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
		endif
	endif
	7seg
again
;

start	
	main
endprogram
