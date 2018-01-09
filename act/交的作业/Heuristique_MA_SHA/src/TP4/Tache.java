package TP4;

public class Tache implements Comparable {
	public static int k;
	int debut;
	int size;
	int duree;
	int index;

	public Tache(int debut, int size, int duree, int index) {
		super();
		this.debut = debut;
		this.size = size;
		this.duree = duree;
		this.index = index;
	}

	public String toString() {
		return "debut:" + debut + " size:" + size + " duree:" + duree;
	}

	@Override
	public int compareTo(Object o) {
		// return (size)-(((Tache)o)).size;
		// return (duree+debut)-(((Tache)o).duree+((Tache)o).debut);
		// return (debut)/size-(((Tache)o)).debut/size;

		if (k==1) {
			if ((size) - (((Tache) o)).size != 0) {
				return (((Tache) o)).size - size;
			} else {
				return ((((Tache) o)).debut - debut);
			}
			
		} else {
			return  (duree + debut) / size-(((Tache) o).duree + ((Tache) o).debut) / ((Tache) o).size;
		}
	}

	public int getDebut() {
		return debut;
	}

	public void setDebut(int debut) {
		this.debut = debut;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}
}
