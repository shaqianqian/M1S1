package JSP;

import java.util.ArrayList;
import java.util.List;

public class JSP_ins {
	//jsp对象的组成（机器数，任务数，还有一个任务的list，和最大延长时间的最小值）
	public JSP_ins(int num_machine, int num_taches, List<tache> tahches, int delay_min) {
		super();
		this.num_machine = num_machine;
		this.num_taches = num_taches;
		this.tahches = tahches;
		this.delay_min = delay_min;

	}

	int num_machine;
	int num_taches;
	List<tache> tahches = new ArrayList<tache>();
	int delay_min;
	
	

}
