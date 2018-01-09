// test add16

slave
start

master

:IP rdm $8810;

: main
	
	$1f
	btn
	ticraz
        50 0
	do 
              rdm
	      pop
        loop 
	rdm
       	tic
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
