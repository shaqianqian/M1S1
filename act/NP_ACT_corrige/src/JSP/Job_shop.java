package JSP;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Job_shop {
	@SuppressWarnings("unchecked")
	public static void jobshop_exhaust() throws IOException {
		System.out.println("Entrez le numero de ficher_text");
		System.out.println("1.donnee1");
		System.out.println("2.donnee2");
		System.out.println("3.donnee3");
		System.out.println("4.donnee4");
		Scanner sc = new Scanner(System.in);
		int index_fichers = sc.nextInt();
		if (index_fichers < 1 || index_fichers > 4) {
			System.out.println("Numero de probleme invalide");
			jobshop_exhaust();

		}
		String nom_fiche = "";
		switch (index_fichers) {
		case 1:
			nom_fiche = "donnee1";
			break;
		case 2:
			nom_fiche = "donnee2";
			break;
		case 3:
			nom_fiche = "donnee3";
			break;
		case 4:
			nom_fiche = "donnee4";
			break;
		}

		FileReader reader = new FileReader("./donneesTest/" + nom_fiche);
		BufferedReader br = new BufferedReader(reader);
		ArrayList<tache> taches = new ArrayList<tache>();

		// int num_machine = sc.nextInt();
		// int num_taches = sc.nextInt();
		int num_machine = Integer.parseInt(br.readLine());
		System.out.println(num_machine);
		int num_taches = Integer.parseInt(br.readLine());
		System.out.println(num_taches);
		String[] index_machines = change2Index(num_machine);
		for (int t = 0; t < num_taches; t++) {
			String s = br.readLine();
			int temp_arrive = Integer.parseInt(String.valueOf(s.charAt(0)));
			int duree = Integer.parseInt(String.valueOf(s.charAt(2)));
			System.out.println(temp_arrive + " " + duree);
			taches.add(new tache(temp_arrive, duree, 0));

		}
		br.close();
		reader.close();
		Comparator<tache> ascComparator = new MyComparator();
		Collections.sort(taches, ascComparator);
		ArrayList<String> total_possibilites = Partition.total_possibilite(taches.size(), index_machines);

		ArrayList<String> resultats = new ArrayList<String>();
		int d = 0;
		while (d >= 0) {
			for (String s : total_possibilites) {
				resultats.add(verifier(d, s, num_machine, taches));
			} // res tous les possibilites"00000""00001""00002".....
			if (resultats.contains("oui")) {
				System.out.println("Une solution pour attente=" + d);
				break;
			} else {
				System.out.println("Pas de solution pour attente=" + d);
				d++;
			}
		}

		System.out.println("Voulez vous continuer de tester?");
		System.out.println("1. oui");
		System.out.println("2. non");
		System.out.print("Numero de choix : ");

		String choix = sc.next();
		if (choix.equals("1")) {
			jobshop_exhaust();
		} else if (choix.equals("2")) {
			System.out.println("merci");
		}

	}

	public static void jobshop_ver() throws NumberFormatException, IOException {
		System.out.println("Entrez le numero de ficher_text");
		System.out.println("1.donnee1");
		System.out.println("2.donnee2");
		System.out.println("3.donnee3");
		System.out.println("4.donnee4");
		Scanner sc = new Scanner(System.in);
		int index_fichers = sc.nextInt();
		if (index_fichers < 1 || index_fichers > 4) {
			System.out.println("Numero de probleme invalide");
			jobshop_ver();

		}
		String nom_fiche = "";
		switch (index_fichers) {
		case 1:
			nom_fiche = "donnee1";
			break;
		case 2:
			nom_fiche = "donnee2";
			break;
		case 3:
			nom_fiche = "donnee3";
			break;
		case 4:
			nom_fiche = "donnee4";
			break;
		}

		FileReader reader = new FileReader("./donneesTest/" + nom_fiche);
		BufferedReader br = new BufferedReader(reader);
		ArrayList<tache> taches = new ArrayList<tache>();
		int num_machine = Integer.parseInt(br.readLine());
		System.out.println(num_machine);
		int num_taches = Integer.parseInt(br.readLine());
		System.out.println(num_taches);
		for (int t = 0; t < num_taches; t++) {
			String s = br.readLine();
			int temp_arrive = Integer.parseInt(String.valueOf(s.charAt(0)));
			int duree = Integer.parseInt(String.valueOf(s.charAt(2)));
			System.out.println(temp_arrive + " " + duree);
			taches.add(new tache(temp_arrive, duree, 0));

		}
		br.close();
		reader.close();
		// int num_machine = sc.nextInt();
		// int num_taches = sc.nextInt();

		// for(int t=0;t<num_taches;t++)
		// {
		// taches.add(new tache(sc.nextInt(),sc.nextInt(),0));
		//
		//
		// }
		String certificat = "";
		if (num_machine > 1) {
			System.out.println("Entrez votre solution, par exemple 01010101");
			certificat = sc.next();
		} else {
			for (int t = 0; t < num_taches; t++) {
				certificat = certificat + "0";
			}
		}
		if (certificat.length() != taches.size()) {
			System.out.println("Vous n'avez pas autant de taches ");
			jobshop_ver();
		}
		char charArray[] = new char[certificat.length()];
		int[] index_machines = new int[certificat.length()];
		for (int i = 0; i < certificat.length(); i++) {
			charArray[i] = certificat.charAt(i);

			index_machines[i] = Integer.parseInt(String.valueOf(charArray[i]));
			if (index_machines[i] > num_machine - 1) {
				System.out.println("Vous n'avez pas autant de machines ");
				jobshop_ver();
				break;
			}
		}
		System.out.println("Entrez le D que vous voulez tester");
		int d = sc.nextInt();

		Comparator<tache> ascComparator = new MyComparator();
		Collections.sort(taches, ascComparator);

		String resultat = verifier(d, certificat, num_machine, taches);
		System.out.println("Le resultat de verification est " + resultat);

		System.out.println("Voulez vous continuer de tester?");
		System.out.println("1. oui");
		System.out.println("2. non");
		System.out.print("Numero de choix : ");

		String choix = sc.next();
		if (choix.equals("1")) {
			jobshop_ver();
		} else if (choix.equals("2")) {
			System.out.println("Merci,le fin du test");
		}
	}

	public static void jobshop_non_determine() throws NumberFormatException, IOException {
		System.out.println("Entrez le numero de ficher_text");
		System.out.println("1.donnee1");
		System.out.println("2.donnee2");
		System.out.println("3.donnee3");
		System.out.println("4.donnee4");
		Scanner sc = new Scanner(System.in);
		int index_fichers = sc.nextInt();
		if (index_fichers < 1 || index_fichers > 4) {
			System.out.println("Numero de probleme invalide");
			jobshop_non_determine();

		}
		String nom_fiche = "";
		switch (index_fichers) {
		case 1:
			nom_fiche = "donnee1";
			break;
		case 2:
			nom_fiche = "donnee2";
			break;
		case 3:
			nom_fiche = "donnee3";
			break;
		case 4:
			nom_fiche = "donnee4";
			break;
		}
		FileReader reader = new FileReader("./donneesTest/" + nom_fiche);
		BufferedReader br = new BufferedReader(reader);
		ArrayList<tache> taches = new ArrayList<tache>();
		int num_machine = Integer.parseInt(br.readLine());
		System.out.println(num_machine);
		int num_taches = Integer.parseInt(br.readLine());
		System.out.println(num_taches);
		for (int t = 0; t < num_taches; t++) {
			String s = br.readLine();
			int temp_arrive = Integer.parseInt(String.valueOf(s.charAt(0)));
			int duree = Integer.parseInt(String.valueOf(s.charAt(2)));
			System.out.println(temp_arrive + " " + duree);
			taches.add(new tache(temp_arrive, duree, 0));

		}
		br.close();
		reader.close();
		String certificat = "";
		for (int t = 0; t < num_taches; t++) {
			certificat = certificat + ((int) (Math.random() * num_machine) + "");
		}

		System.out.println("Entrez le D que vous voulez tester");
		int d = sc.nextInt();

		Comparator<tache> ascComparator = new MyComparator();
		Collections.sort(taches, ascComparator);

		String resultat = verifier(d, certificat, num_machine, taches);
		System.out.println("............................................");
		System.out.println("Le certificat aleatoire est ");
		for (tache t : taches) {
			System.out.println(t);
		}
		System.out.println("............................................");
		System.out.println("Le resultat de la verification est " + resultat);

		System.out.println("Voulez vous continuer de tester?");
		System.out.println("1. oui");
		System.out.println("2. non");
		System.out.print("Numero de choix : ");

		String choix = sc.next();
		if (choix.equals("1")) {
			jobshop_non_determine();
		} else if (choix.equals("2")) {
			System.out.println("Merci,fin du test");
		}
	}

	public static String[] change2Index(int num_machine) {

		String[] index = new String[num_machine];
		for (int i = 0; i < num_machine; i++) {
			index[i] = "" + i;
		}
		return index;// change num_machine a index(String)

	}

	public static int[] divise(String str) {
		char charArray[] = new char[str.length()];
		int[] index_machines = new int[str.length()];
		for (int i = 0; i < str.length(); i++) {
			charArray[i] = str.charAt(i);

			index_machines[i] = Integer.parseInt(String.valueOf(charArray[i]));
		}
		return index_machines;

	}

	public static String verifier(int d, String s, int num_machine, ArrayList<tache> taches) { // s est une solution de res
																							// ,par exemple "00000"ou
																							// "11010"
		Object[] taches_en_machines = new Object[num_machine];

		int[] index_machines = divise(s);
		String resultat = "";
		for (int i = 0; i < taches.size(); i++) {
			taches.get(i).setNum_machine(index_machines[i]);
		} // 把每种情况的机器进行赋值

		for (int k = 0; k < num_machine; k++) {
			taches_en_machines[k] = new ArrayList<tache>();
		}
		for (tache t : taches) {
			for (int k = 0; k < num_machine; k++) {
				if (t.num_machine == k)
					((ArrayList<tache>) taches_en_machines[k]).add(t);
			}

		}
		for (int k = 0; k < num_machine; k++) {
			if (compare((ArrayList<tache>) taches_en_machines[k], d) == "non") {
				resultat = "non";
				return resultat;
			}

		}

		resultat = "oui";
		System.out.println("Les certificats corrects sont ");
		for (tache t : taches) {
			System.out.println(t);
		}
		System.out.println("----------------------------");

		return resultat;
	}

	public static String compare(ArrayList<tache> taches, int d) {
		String analyse = "oui";
		if (taches.size() > 0) {
			int y = taches.get(0).debut + taches.get(0).duree;

			for (int i = 1; i < taches.size(); i++) {
				if (y <= taches.get(i).debut) {
					y = taches.get(i).debut + taches.get(i).duree;
				} else if ((y > taches.get(i).debut) && ((y - taches.get(i).debut)) <= d) {// taches.get(i+1).setDebut(taches.get(i).debut+taches.get(i).duree);
					y = y + taches.get(i).duree;
				} else {
					analyse = "non";
				}
			}
		}

		return analyse;

	}

	// public static ArrayList<String> ajouter_possibilite(ArrayList<String>
	// ancien_possibites, String[] index_machines) {
	// ArrayList<String> possibiltes = new ArrayList<String>();
	// for (String s : ancien_possibites) {
	// for (int i = 0; i < index_machines.length; i++) {
	// possibiltes.add(s + index_machines[i]);
	// }
	// }
	//
	// return possibiltes;
	//
	// }
	//
	// public static ArrayList<String> total_possibilite(int num_taches, String[]
	// index_machines) {
	// ArrayList<String> res = new ArrayList<String>();
	// for (int m = 0; m < index_machines.length; m++) {
	// res.add(index_machines[m]);
	// }
	// for (int si = 0; si < num_taches - 1; si++) {
	// res = ajouter_possibilite(res, index_machines);
	// }
	//
	// return res;
	// }
	// public static void main(String[] args) {
	// ArrayList<tache> taches = new ArrayList<tache>();
	// Scanner sc = new Scanner(System.in);
	// int num_machine = sc.nextInt();
	// int num_taches = sc.nextInt();
	// // int num_machine=3;
	// // int d=2;
	//
	// String[] index_machines = change2Index(num_machine);
	// for (int t = 0; t < num_taches; t++) {
	// taches.add(new tache(sc.nextInt(), sc.nextInt(), 0));
	//
	// }
	// // taches.add(new tache(2,4,0));
	// // taches.add(new tache(0,2,0));
	// // taches.add(new tache(7,2,0));
	// // taches.add(new tache(3,1,0));
	// // taches.add(new tache(1,2,0));
	// // taches.add(new tache(2,6,0));
	// // taches.add(new tache(2,5,0));
	// // taches.add(new tache(1,3,0));
	// // taches.add(new tache(5,3,0));
	// Comparator<tache> ascComparator = new MyComparator();
	// Collections.sort(taches, ascComparator);
	// ArrayList<String> total_possibilites = total_possibilite(taches.size(),
	// index_machines);
	// // System.out.println("num_solutions"+total_possibilites.size());//可能性的总数
	// // for(tache t:taches) {System.out.println(t);}
	// ArrayList<String> resultats = new ArrayList<String>();
	// int d = 0;
	// while (d >= 0) {
	// for (String s : total_possibilites) {
	// resultats.add(test(d, s, num_machine, taches));
	// } // res tous les possibilites"00000""00001""00002".....
	// if (resultats.contains("oui")) {
	// System.out.println("une solution pour attente=" + d);
	// break;
	// } else {
	// System.out.println("pas solution pour attente=" + d);
	// d++;
	// }
	// }
	// // test(1, res.get(9));
	// // int[] index_machin=divise("00101");
	// // for (int i = 0; i < index_machin.length; i++)
	// // {System.out.println(index_machin[i]);}
	// }

}
