// test add16, c*est pas correcte


slave
start

master
: main
0
begin
rdm
        $1F
	btn
	switch
        8 
	<-
        $1F
        btn
	switch
        +
        7segdup
	swap
	inc
	dup
2
=
 until
 drop
 +
 7seg
 $1F
	btn
;
start
	main
endprogram
