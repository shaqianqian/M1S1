package JSP;

public class tache {
 @SuppressWarnings("unchecked")
  int debut;
  int duree;
  int num_machine;



public tache(int debut, int duree, int num_machine) {

	this.debut = debut;
	this.duree = duree;
	this.num_machine = num_machine;
}



public int getDebut() {
	return debut;
}



public void setDebut(int debut) {
	this.debut = debut;
}



public int getDuree() {
	return duree;
}



public void setDuree(int duree) {
	this.duree = duree;
}



public int getNum_machine() {
	return num_machine;
}



public void setNum_machine(int num_machine) {
	this.num_machine = num_machine;
}



public String toString() {
	return "debut:"+debut+" duree:"+duree+" num_machine:"+num_machine;
}
}
