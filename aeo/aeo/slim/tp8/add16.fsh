// test add16


slave
start

master
: main
begin
    2 0
    do
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
    loop
    +
    7seg
again
;
start
	main
endprogram
