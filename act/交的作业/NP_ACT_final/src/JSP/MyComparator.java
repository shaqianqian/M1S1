package JSP;

import java.util.Comparator;

public class MyComparator implements Comparator<tache> {


	@Override
	public int compare(tache o1, tache o2) {
		return (o1.getDebut()+o1.getDuree())-(o2.getDebut()+o2.getDuree());
	}

}
