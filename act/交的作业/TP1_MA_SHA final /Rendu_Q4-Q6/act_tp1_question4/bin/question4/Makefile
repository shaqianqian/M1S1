Point.class: Point.java
	javac Point.java
Question4.class:Point.class Question4.java
javac Question4.java

%.class: %.java
	javac $^

$PHONY: clean execute

execute:Question4.class
	java Question4

clean:
	rm -rf *~ *.class *.svg
