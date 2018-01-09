package JSP;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Partition {
    @SuppressWarnings("unchecked")
	public static void pari_exhaust() throws NumberFormatException, IOException {

		System.out.println("Entrez le numero de ficher_text");
		System.out.println("1.exPart1");
		System.out.println("2.exPart2");
		System.out.println("3.exPart3");
		System.out.println("4.exPart4");
		Scanner sc = new Scanner(System.in);
		int index_fichers = sc.nextInt();
		if (index_fichers < 1 || index_fichers > 4) {
			System.out.println("Numero de probleme invalide");
			pari_exhaust();

		}
		String nom_fiche = "";
		switch (index_fichers) {
		case 1:
			nom_fiche = "exPart1";
			break;
		case 2:
			nom_fiche = "exPart2";
			break;
		case 3:
			nom_fiche = "exPart3";
			break;
		case 4:
			nom_fiche = "exPart4";
			break;
		}

		FileReader reader = new FileReader("./donneesTest/" + nom_fiche);
		// int num = sc.nextInt();
		BufferedReader br = new BufferedReader(reader);
		int num = Integer.parseInt(br.readLine());
		System.out.println(num);
		int[] array = new int[num];
		int total = 0;
		for (int i = 0; i < num; i++) {
			array[i] = Integer.parseInt(br.readLine());
			total = total + array[i];
			System.out.println(array[i]);
		}
		String[] possbilites = new String[] { "0", "1" };
		List<String> total_possibilites = total_possibilite(num, possbilites);
		List<String> res = new ArrayList<String>();
		List<String> solutions = new ArrayList<String>();
		for (String s : total_possibilites) {
			char charArray[] = new char[s.length()];
			List<Integer> gauche = new ArrayList<Integer>();
			List<Integer> droite = new ArrayList<Integer>();

			String g = "";
			String d = "";
			for (int i = 0; i < s.length(); i++) {
				charArray[i] = s.charAt(i);

				if (charArray[i] == '0') {
					gauche.add(array[i]);
				} else {
					droite.add(array[i]);
				}
			}
			Collections.sort(gauche);
			Collections.reverse(gauche);
			Collections.sort(droite);
			Collections.reverse(droite);
			for (Integer i : gauche) {
				g = g + i + "+";

			}

			for (Integer i : droite) {
				d = d + i + "+";

			}

			if (Sum(gauche) == total / 2) {
				String solution = g.substring(0, g.length() - 1) + "=" + d.substring(0, d.length() - 1);
				// System.out.print(solution);
				// System.out.println("true");

				solutions.add(solution);
				res.add("true");
			} else {
				res.add("false");
			}

		}
		if (!res.contains("true")) {
			System.out.println("false");
		} else {
			System.out.println("true");
			List<String> solutions_moti = new ArrayList<String>();
			if (solutions.size() / 2 == 1) {
				System.out.println(solutions.get(0));
			} else {
				solutions_moti = solutions.subList(0, solutions.size() / 2);
				HashSet h = new HashSet(solutions_moti);
				solutions_moti.clear();
				solutions_moti.addAll(h);
				for (String s : solutions_moti) {
					System.out.println(s);
				}
			}
		}
		System.out.println("Vous voulez continuer de tester?");
		System.out.println("1. oui");
		System.out.println("2. non");
		System.out.print("Numero de choix : ");

		String choix = sc.next();
		if (choix.equals("1")) {
			pari_exhaust();
		} else if (choix.equals("2")) {
			System.out.println("merci");
		}
	}

	public static void pari_non_determine() throws NumberFormatException, IOException {
		System.out.println("Entrez le numero de ficher_text");
		System.out.println("1.exPart1");
		System.out.println("2.exPart2");
		System.out.println("3.exPart3");
		System.out.println("4.exPart4");
		Scanner sc = new Scanner(System.in);
		int index_fichers = sc.nextInt();
		if (index_fichers < 1 || index_fichers > 4) {
			System.out.println("Numero de probleme invalide");
			pari_non_determine();

		}
		String nom_fiche = "";
		switch (index_fichers) {
		case 1:
			nom_fiche = "exPart1";
			break;
		case 2:
			nom_fiche = "exPart2";
			break;
		case 3:
			nom_fiche = "exPart3";
			break;
		case 4:
			nom_fiche = "exPart4";
			break;
		}

		FileReader reader = new FileReader("./donneesTest/" + nom_fiche);
		// int num = sc.nextInt();
		BufferedReader br = new BufferedReader(reader);
		int num = Integer.parseInt(br.readLine());
		System.out.println(num);
		int[] array = new int[num];
		int total = 0;
		for (int i = 0; i < num; i++) {
			array[i] = Integer.parseInt(br.readLine());
			System.out.println(array[i]);
			total = array[i];
		}
		String solution = "";
		for (int i = 0; i < num; i++) {
			solution = solution + ((int) (Math.random() * 2) + "");

		}
		System.out.println("La solution aleatoire est " + solution);
		char charArray[] = new char[solution.length()];

		List<Integer> gauche = new ArrayList<Integer>();
		List<Integer> droite = new ArrayList<Integer>();

		String g = "";
		String d = "";
		for (int i = 0; i < solution.length(); i++) {
			charArray[i] = solution.charAt(i);

			if (charArray[i] == '0') {
				gauche.add(array[i]);
			} else {
				droite.add(array[i]);
			}
		}

		for (Integer i : gauche) {
			g = g + i + "+";

		}

		for (Integer i : droite) {
			d = d + i + "+";

		}

		if (Sum(gauche) == total / 2) {
			String res = g.substring(0, g.length() - 1) + "=" + d.substring(0, d.length() - 1);
			System.out.println(res);
			System.out.println("true");

		} else {
			String res = g.substring(0, g.length() - 1) + "=" + d.substring(0, d.length() - 1);
			System.out.println(res);
			System.out.println("false");
		}

		System.out.println("Voulez vous continuer de tester?");
		System.out.println("1. oui");
		System.out.println("2. non");
		System.out.print("Numero de choix : ");

		String choix = sc.next();
		if (choix.equals("1")) {
			pari_non_determine();
		} else if (choix.equals("2")) {
			System.out.println("erci,fin du test");
		}
	}

	public static void pari_ver() throws NumberFormatException, IOException {
		System.out.println("Entrer le numero de ficher_text");
		System.out.println("1.exPart1");
		System.out.println("2.exPart2");
		System.out.println("3.exPart3");
		System.out.println("4.exPart4");
		Scanner sc = new Scanner(System.in);
		int index_fichers = sc.nextInt();
		if (index_fichers < 1 || index_fichers > 4) {
			System.out.println("Numero de probleme invalide");
			pari_ver();

		}
		String nom_fiche = "";
		switch (index_fichers) {
		case 1:
			nom_fiche = "exPart1";
			break;
		case 2:
			nom_fiche = "exPart2";
			break;
		case 3:
			nom_fiche = "exPart3";
			break;
		case 4:
			nom_fiche = "exPart4";
			break;
		}

		FileReader reader = new FileReader("./donneesTest/" + nom_fiche);
		// int num = sc.nextInt();
		BufferedReader br = new BufferedReader(reader);
		int num = Integer.parseInt(br.readLine());
		System.out.println(num);
		int[] array = new int[num];
		int total = 0;
		for (int i = 0; i < num; i++) {
			array[i] = Integer.parseInt(br.readLine());
			System.out.println(array[i]);
			total = total + array[i];
		}
		System.out.println(
				"Entrez votre solution, par exemple 1010101, 1 signifie que ce chiffre est a gauche, 0 est a droite");
		String solution = "";
		solution = sc.next();
		if (solution.length() > num) {
			System.out.println("Vous n'avez pas assez de chiffres");
			pari_ver();
		}
		char charArray[] = new char[solution.length()];

		List<Integer> gauche = new ArrayList<Integer>();
		List<Integer> droite = new ArrayList<Integer>();

		String g = "";
		String d = "";
		for (int i = 0; i < solution.length(); i++) {
			charArray[i] = solution.charAt(i);

			if (charArray[i] == '0') {
				gauche.add(array[i]);
			} else {
				droite.add(array[i]);
			}
		}

		for (Integer i : gauche) {
			g = g + i + "+";

		}

		for (Integer i : droite) {
			d = d + i + "+";

		}

		if (Sum(gauche) == total / 2) {
			String res = g.substring(0, g.length() - 1) + "=" + d.substring(0, d.length() - 1);
			System.out.println(res);
			System.out.println("true");

		} else {
			String res = g.substring(0, g.length() - 1) + "=" + d.substring(0, d.length() - 1);
			System.out.println(res);
			System.out.println("false");
		}

		System.out.println("Voulez-vous continuer de tester?");
		System.out.println("1. oui");
		System.out.println("2. non");
		System.out.print("Numero de choix : ");

		String choix = sc.next();
		if (choix.equals("1")) {
			pari_ver();
		} else if (choix.equals("2")) {
			System.out.println("Merci,fin du test");
		}
	}

	public static int Sum(List<Integer> l) {
		int sum = 0;
		if (l.size() == 0)
			return 0;
		else
			for (Integer i : l) {
				sum = sum + i;
			}
		return sum;
	}

	public static ArrayList<String> ajouter_possibilite(ArrayList<String> ancien_possibites, String[] index_machines) {
		ArrayList<String> possibiltes = new ArrayList<String>();
		for (String s : ancien_possibites) {
			for (int i = 0; i < index_machines.length; i++) {
				possibiltes.add(s + index_machines[i]);
			}
		}

		return possibiltes;

	}

	public static ArrayList<String> total_possibilite(int num_taches, String[] index_machines) {
		ArrayList<String> res = new ArrayList<String>();
		for (int m = 0; m < index_machines.length; m++) {
			res.add(index_machines[m]);
		}
		for (int si = 0; si < num_taches - 1; si++) {
			res = ajouter_possibilite(res, index_machines);
		}

		return res;
	}

}

//
// public static void pari_exhaust() {
// Scanner sc = new Scanner(System.in);
// int num = sc.nextInt();
// int[] array = new int[num];
// int sum = 0;
// for (int i = 0; i < num; i++) {
// array[i] = sc.nextInt();
// sum += array[i];
// }
// int capacite = sum / 2; // 设置背包容量为12
// int[] x = new int[num];
// Sac(num, array, x, capacite);
//
// }

// public static void Sac(int num, int value[], int x[], int C) {
// int V[][] = new int[num][C + 1];
// for (int i = 1; i < num; i++) {
// for (int j = 0; j <= C - value[0]; j++) {
// if (j < value[i])
// V[i][j] = V[i - 1][j];// 想要向包中添加第i个物品，若物品体积大于当前体积，是无论如何都加不进去的
// else {
// V[i][j] = Math.max(V[i - 1][j], V[i - 1][j - value[i]] + value[i]);
// }
// }
//
// }
// x[0] = 1;
// int j = C - value[0];
// for (int i = num - 1; i >= 1; i--) {
// if (V[i][j] > V[i - 1][j]) {
// x[i] = 1;
// j = j - value[i];
// } else
// x[i] = 0;
// }
//
// int sum0 = 0;
// int sum1 = 0;
// String s0 = "";
// String s1 = "";
// for (int i = 0; i < num; i++) {
//
// // System.out.print(x[i]+" ");
// if (x[i] == 0) {
// sum0 = sum0 + value[i];
// s0 = s0 + ("+" + value[i]);
// }
// if (x[i] == 1) {
// sum1 = sum1 + value[i];
// s1 = s1 + ("+" + value[i]);
// }
// }
// if (sum1 != sum0) {
// System.out.println("false");
// } else {
//
// System.out.println(s1.substring(1) + "=" + s0.substring(1));
// System.out.println("true");
// }
// }

// public static void main(String[] args) {
// Scanner sc = new Scanner(System.in);
// int num = sc.nextInt();
// int[] array = new int[num];
// int sum = 0;
// for (int i = 0; i <num; i++) {
// array[i] = sc.nextInt();
// sum += array[i];
// }
// int[] value = array;
// num = value.length; //计算物品数量
// int CAP = sum/2; //设置背包容量为12
// int[] x = new int[num];
// Sac(num,value,x,CAP);
// }
