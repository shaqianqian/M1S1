//present fibo(i) by switch(i)
//i=0,1,2,3,3,4,5

slave 
start

master

: main
begin
	$0
	$1
	$1f
	btn
	switch
	dec
	for
		dup
		-rot
		add
	next
	7seg
again
;

start	
	main
endprogram
