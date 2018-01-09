package JSP;

import java.util.ArrayList;
import java.util.List;

public class Sum_ins {

	int sum;
	int num_chiffre;

	public Sum_ins(int sum, int num_chiffre, List<Integer> chiffres) {
		super();
		this.sum = sum;
		this.num_chiffre = num_chiffre;
		this.chiffres = chiffres;
	}

	List<Integer> chiffres = new ArrayList<Integer>();

}
