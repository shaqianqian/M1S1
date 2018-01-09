//
slave 
start

master
//10101
:IP rdm $9010
;
//11001
:IP square2 $C814
;
//10101
:IP comparateur $A800
;
//10101
IP finloop $A802
;
//10101
IP addself $A803
;
: main
	0
	0
	begin
		swap
		rdm
		square2
		comparateur
		if
			addself
		else
		endif
		swap
		addself
		dup
		finloop
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
