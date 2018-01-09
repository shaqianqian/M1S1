package TP4;

import java.util.Comparator;

public class compare_taches implements Comparator {
	public int compare(Object o1, Object o2) {
		return ((Tache) o1).index - ((Tache) o2).index;

	}

}
