// additionneur 16 bits

slave 
start

master
: read8bits
	$1f
	btn
	switch
	leddup
;
: concat16
	$8
	<-
	add
;
: main
begin
	3
	for
		read8bits	
	next
	ticraz
	concat16
	-rot
	concat16
	$1f
	btn
	add
	tic
	7seg
	$1f
	btn	
	7seg
again
;
start	
	main
endprogram
