//
slave 
start

master

: fibo
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
	switch
	dup
	2
	=
	if
		drop
		1
		0
		swap
		7seg
		$1f
		btn
	else
		dup
		2
		>
		if
			drop
			1
			1
			ticraz
			fibo
			tic
			swap
			7seg
			$1f
			btn
		else
			0
			swap
			7seg
			$1f
			btn
		endif
	endif
	7seg
again
;

start	
	main
endprogram
