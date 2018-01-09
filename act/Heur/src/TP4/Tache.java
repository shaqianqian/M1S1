package TP4;

public class Tache {

int debut;
int size;
int duree;
public Tache(int debut, int size, int duree) {
	super();
	this.debut = debut;
	this.size = size;
	this.duree = duree;
}
public String toString() {
	return "debut:"+debut+" size:"+size+" duree:"+duree;
}
}
