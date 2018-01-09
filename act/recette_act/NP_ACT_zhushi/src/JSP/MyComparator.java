package JSP;

import java.util.Comparator;

public class MyComparator implements Comparator<tache> {
  //帮助任务按照结束时间排序，从小到大

	@Override
	public int compare(tache o1, tache o2) {
		return (o1.getDebut()+o1.getDuree())-(o2.getDebut()+o2.getDuree());
	}

}
