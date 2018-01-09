package TP4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public class min_delay {
	static List<String> possibites = new ArrayList<String>();

	public static List<String> recursionArrange(char[] arrayA, int start, int end) {

		String s = "";
		if (end <= 1)
			return possibites;
		if (start == end) {

			for (int i = 0; i < arrayA.length; i++) {
				s = s.concat(arrayA[i] + "");
				// System.out.print(arrayA[i]);

			}
			possibites.add(s);
			// System.out.println(s);
		} else {
			for (int i = start; i <= end; i++) {
				swap(arrayA, i, start);
				recursionArrange(arrayA, start + 1, end);
				swap(arrayA, i, start);
			}
		}
		return possibites;

	}

	// 交换数组m位置和n位置上的值
	public static void swap(char[] arrayA, int m, int n) {
		char temp = arrayA[m];
		arrayA[m] = arrayA[n];
		arrayA[n] = temp;
	}

	public static Object[] Ajoute_situation() {
		String A = "0123456";
		Map<Integer, Tache> maps = new HashMap<Integer, Tache>();
		char[] arrayA = A.toCharArray();
		Object[] test = new Object[5040];
		List<String> possibilites = recursionArrange(arrayA, 0, arrayA.length - 1);
		for (int s = 0; s < possibilites.size(); s++) {
			List<Tache> taches = new ArrayList<Tache>();
			maps.put(Integer.parseInt(String.valueOf(possibilites.get(s).charAt(0))), new Tache(0, 50, 1200));
			maps.put(Integer.parseInt(String.valueOf(possibilites.get(s).charAt(1))), new Tache(0, 20, 3600));
			maps.put(Integer.parseInt(String.valueOf(possibilites.get(s).charAt(2))), new Tache(0, 20, 3600));
			maps.put(Integer.parseInt(String.valueOf(possibilites.get(s).charAt(3))), new Tache(0, 20, 3600));
			maps.put(Integer.parseInt(String.valueOf(possibilites.get(s).charAt(4))), new Tache(2400, 75, 120));
			maps.put(Integer.parseInt(String.valueOf(possibilites.get(s).charAt(5))), new Tache(3000, 15, 7200));
			maps.put(Integer.parseInt(String.valueOf(possibilites.get(s).charAt(6))), new Tache(3400, 42, 1337));
			for (int i = 0; i < possibilites.get(s).length(); i++) {
				taches.add(maps.get(i));

			}
			test[s] = taches;

		}
		return test;

	}

	public static int naive(List<Tache> taches) {
		int[] table = new int[100000];
		int delay = 0;
	

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
				//System.out.println("index" + i);
				//System.out.println(k + " " + taches.get(i).size + " " + taches.get(i).duree);
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

				//System.out.println("index" + i);
				//System.out.println(k + move + " " + taches.get(i).size + " " + taches.get(i).duree);
				delay = delay + k - taches.get(i).debut;
			}

		}
	
		return delay;
	}

	public static void main(String[] args) {

		// Map<Integer, Tache> maps = new HashMap<Integer, Tache>();
		//
		// maps.put(0, new Tache(0, 50, 1200));
		// maps.put(1, new Tache(0, 20, 3600));
		// maps.put(2, new Tache(0, 20, 3600));
		// maps.put(3, new Tache(0, 20, 3600));
		// maps.put(4, new Tache(2400, 75, 120));
		// maps.put(5, new Tache(3000, 15, 7200));
		// maps.put(6, new Tache(3400, 42, 1337));
	
		Object[] test = new Object[5040];
		test = Ajoute_situation();
		int min=10000;
		List<Tache> t_min = null;
		for(int k=0;k<test.length;k++) {
			int delay=naive((List<Tache>) test[k]);
			System.out.println("delay_total=" + delay);
		    if(delay<min) {min=delay;
		    t_min=(List<Tache>) test[k];
		    }
		    
			
		}
		System.out.println("min_delay=" + min);
		for(Tache t:t_min) {System.out.println(t);}
       

	}
}
