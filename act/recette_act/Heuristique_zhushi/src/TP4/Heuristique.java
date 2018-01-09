package TP4;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Heuristique {
    
	public static void main(String[] args) throws IOException {
		choix_fiche();

	}

	public static void recommence() throws IOException {
		//为了运行好看，没有用
		System.out.println("vous voulez recommencer?");
		System.out.println("1. oui");
		System.out.println("2. non");
		System.out.print("Numero du choix: ");
		Scanner scan = new Scanner(System.in);
		int tmp = scan.nextInt();
		if (tmp == 1) {
			choix_fiche();
		} else {
			System.out.println("Fini,merci");
		}
	}

	public static void choix_fiche() throws IOException {
  //选择要测试的文件
		{
			System.out.println("\nVeuillez choisir une fichier (indiquer le numero) :");
			System.out.println("1. Test");
			System.out.println("2. Lille");
			System.out.println("3. Grenoble");
			System.out.println("4. Lyon");
			System.out.println("5. Nancy");
			System.out.print("Numero du probleme : ");
			Scanner scan = new Scanner(System.in);
			int tmp = scan.nextInt();
			String name_fiche = "";
			if (tmp < 1 || tmp > 6) {
				System.err.println("Numero de probleme invalide");

			} else {
				switch (tmp) {
 
				/////////////
				/* jsp */
				/////////////
				case 1:
					Naive_test.naive_test();
					
					break;
				case 2:
					
					name_fiche = "Lille";
				
					heuritique(name_fiche);
					
				
					break;

				case 3:

					name_fiche = "Grenoble";
					Tache.k=1;
					heuritique(name_fiche);
					Tache.k=0;
					
					break;
				case 4:

					name_fiche = "Lyon";
					heuritique(name_fiche);
					
					break;
				case 5:

					name_fiche = "Nancy";
					heuritique(name_fiche);
					
					break;
				}

			}
			recommence();

		}

	}

	public static void heuritique(String name_fiche) throws IOException {
		List<Tache> taches = new ArrayList<Tache>();
		int[] table = new int[100000000]; //把时间切成100000000份
		List<Tache> copy_taches = new ArrayList<Tache>();
		long delay = 0;
		FileReader reader = new FileReader("./donneesTest/" + name_fiche);
		//从选择的文件中读取数据，这次是机器数，任务数，和每个任务的进入时间、所需要的机器数和执行时间
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
		//把所有的任务按照结束时间排序，结束时间越晚越早放进去（防止被delay得太厉害），所需要的机器越多越晚放进去
		br.close();
		reader.close();

		for (int i = 0; i < num_taches; i++) {
			if (table[taches.get(i).debut] + taches.get(i).size <= num_machine) { 
				//取一个任务，测试它开始的时间那个点是不是有足够的机器，如果有进行接下来的测试
				int k = taches.get(i).debut;
				while (true) {

					boolean flag = true;
					int m = 0;
					for (m = k; m < k + taches.get(i).duree; m++) {
						//测试在这个任务运行的这一段时间里，是不是都有足够的机器给他，如果没有就delay，直到delay到一个时间点，能保证接下来的时间都有足够的机器给这个任务
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
        //找到这个时间点了，把机器加塞进去，现在这短时间内都有一定数量的机器被这个任务占据
				}

				delay = delay + taches.get(i).debut - copy_taches.get(i).debut;

			} else {
                //如果这个机器的起始时间的那个时间点并没有足够的机器，就delay，直到找到一个时间点有足够的机器给这个任务加塞
				int k = taches.get(i).debut;
				while (table[k] + taches.get(i).size > num_machine) {

					k++;
				}
          //一样不只是开始时间点要有足够的机器，接下来任务运转的时间都要有足够的机器
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

		Object[] arr_tache = new Object[num_taches];
		for (int t = 0; t < num_taches; t++) {
			arr_tache[t] = taches.get(t);

		}
		Arrays.sort(arr_tache, new compare_taches());
		for (int t = 0; t < num_taches; t++) {
			System.out.println(((Tache) arr_tache[t]).debut);

		}
		System.out.println("delay_total=" + delay);

	}
}
