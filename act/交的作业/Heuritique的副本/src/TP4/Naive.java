package TP4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Naive {
	static List<Tache> taches = new ArrayList<Tache>();
	static int[] table = new int[100000000];
	static List<Tache> copy_taches = new ArrayList<Tache>();
	static long delay = 0;

	public static void main(String[] args) throws IOException {

		// int num_machine=100;
		// taches.add(new Tache(0, 50, 1200));
		// taches.add(new Tache(0, 20, 3600));
		// taches.add(new Tache(0, 20, 3600));
		// taches.add(new Tache(0, 20, 3600));
		// taches.add(new Tache(2400, 75, 120));
		// taches.add(new Tache(3000, 15, 7200));
		// taches.add(new Tache(3400, 42, 1337));
		FileReader reader = new FileReader("./donneesTest/Lyon");
		BufferedReader br = new BufferedReader(reader);
		int num_machine = Integer.parseInt(br.readLine());
		// System.out.println(num_machine);
		int num_taches = Integer.parseInt(br.readLine());
		// System.out.println(num_taches);
		for (int t = 0; t < num_taches; t++) {
			String s = br.readLine();
			String[] divise = s.split(" ");
			int temp_arrive = Integer.parseInt(String.valueOf(divise[0]));
			int size = Integer.parseInt(String.valueOf(divise[1]));
			int duree = Integer.parseInt(String.valueOf(divise[2]));
			// System.out.println(temp_arrive + " " +size+" "+ duree);
			taches.add(new Tache(temp_arrive, size, duree, t));
			copy_taches.add(new Tache(temp_arrive, size, duree, t));
		}
		Collections.sort(taches);
		Collections.reverse(taches);
		// for (int t = 0; t < num_taches; t++) {
		// System.out.println(taches.get(t));
		//
		// }
		br.close();
		reader.close();

		for (int i = 0; i < num_taches; i++) {
			if (table[taches.get(i).debut] + taches.get(i).size <= num_machine) {
				int k = taches.get(i).debut;
				while (true) {

					boolean flag = true;
					int m = 0;
					for (m = k; m < k + taches.get(i).duree; m++) {
						if (table[m] + taches.get(i).size > num_machine) {
							flag = false;

						}
						if (!flag) {
							break;
						}
					}
					if (!flag)
						k = m + 1;
					else
						break;
				}
				for (int t = k; t < k + taches.get(i).duree; t++) {
					table[t] += taches.get(i).size;
					taches.get(i).setDebut(k);

				}
				// System.out.println("index" + i);

				// System.out.println(k);
				// System.out.println(k + " " + taches.get(i).size + " " + taches.get(i).duree);

				delay = delay + taches.get(i).debut - copy_taches.get(i).debut;

			} else {

				int k = taches.get(i).debut;
				while (table[k] + taches.get(i).size > num_machine) {

					k++;
				}

				while (true) {

					boolean flag = true;
					int m = 0;
					for (m = k; m < k + taches.get(i).duree; m++) {
						if (table[m] + taches.get(i).size > num_machine) {
							flag = false;

						}
						if (!flag) {
							break;
						}
					}
					if (!flag)
						k = m + 1;

					else
						break;
				}

				for (int g = k; g < k + taches.get(i).duree; g++) {
					table[g] += taches.get(i).size;
					taches.get(i).setDebut(k);
				}

				// System.out.println("index" + i);
				// System.out.println(k + move + " " + taches.get(i).size + " " +
				// taches.get(i).duree);
				// System.out.println(k);

				delay = delay + taches.get(i).debut - copy_taches.get(i).debut;

			}

		}

		System.out.println("delay_total=" + delay);
		Object[] arr_tache = new Object[num_taches];
		for (int t = 0; t < num_taches; t++) {
			arr_tache[t] = taches.get(t);

		}
		Arrays.sort(arr_tache, new compare_taches());
		for (int t = 0; t < num_taches; t++) {
			System.out.println(((Tache) arr_tache[t]).debut);

		}

	}
}
