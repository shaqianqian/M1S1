package question6_7;

import java.util.Comparator;

public class immComparator implements Comparator<imm_point> {

	@Override
	public int compare(imm_point o1, imm_point o2) {
		return o1.getX1()-o2.getX1() ;
	}

}
