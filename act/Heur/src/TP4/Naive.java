package TP4;

import java.util.ArrayList;
import java.util.List;
import org.omg.Messaging.SyncScopeHelper;

public class Naive {
	static List<Tache> taches = new ArrayList<Tache>();
	static int[] table = new int[100000];

	public static void main(String[] args) {
		int delay = 0;
		taches.add(new Tache(0, 50, 1200));
		taches.add(new Tache(0, 20, 3600));
		taches.add(new Tache(0, 20, 3600));
		taches.add(new Tache(0, 20, 3600));
		taches.add(new Tache(2400, 75, 120));
		taches.add(new Tache(3000, 15, 7200));

		taches.add(new Tache(3400, 42, 1337));

		for (int i = 0; i < taches.size(); i++) {
			int move = 0;
			if (table[taches.get(i).debut] + taches.get(i).size <= 100) {
				int k = taches.get(i).debut;
				while (true) {

					boolean flag = true;

					for (int m = k; m < k + taches.get(i).duree; m++) {
						if (table[m] + taches.get(i).size > 100)
							flag = false;
					}
					if (!flag)
						k++;
					else
						break;
				}
				for (int t = k; t < k + taches.get(i).duree; t++) {
					table[t] += taches.get(i).size;

				}
				System.out.println("index" + i);
				System.out.println(k + " " + taches.get(i).size + " " + taches.get(i).duree);
				delay = delay + k - taches.get(i).debut;
			} else {

				int k = taches.get(i).debut;
				while (table[k] + taches.get(i).size > 100) {

					k++;
				}

				while (true) {

					boolean flag = true;
					for (int m = k; m < k + taches.get(i).duree; m++) {
						if (table[m] + taches.get(i).size > 100)
							flag = false;
					}
					if (!flag)
						k++;
					else
						break;
				}

				for (int g = k; g < k + taches.get(i).duree; g++) {
					table[g] += taches.get(i).size;

				}

				System.out.println("index" + i);
				System.out.println(k + move + " " + taches.get(i).size + " " + taches.get(i).duree);
				delay = delay + k - taches.get(i).debut;
			}

		}
		System.out.println("delay_total=" + delay);
	}

}
