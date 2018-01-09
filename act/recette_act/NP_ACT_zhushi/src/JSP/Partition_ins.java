package JSP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Partition_ins {
	int num;
	List<Integer> chiffres = new ArrayList<Integer>();

	public Partition_ins(int num, List<Integer> chiffres) {//partition 的构造方法，包含操作的数字的总量和一个list的数字
		super();
		this.num = num;
		this.chiffres = chiffres;

	}

	public static JSP_ins resoudre_jsp(Sum_ins s) {//证实sum确实是jsp的一种特殊情况
		Partition_ins p = resoudre_partition(s);
		JSP_ins jsp = resoudre_jsp(p);
		return jsp;

	}

	public static JSP_ins resoudre_jsp(Partition_ins p) {
		//证明partition确实是jsp的一种特殊情况，即当jsp中机器数为2，d为0时，它是一个partition问题
		List<tache> chiffres = new ArrayList<tache>();
		for (int s : p.chiffres) {
			chiffres.add(new tache(0, s, 0));
		}
		int num_machine = 2;
		int delay_max = 0;
		JSP_ins jsp_new = new JSP_ins(num_machine, p.num, chiffres, delay_max);
		return jsp_new;

	}

	public static Partition_ins resoudre_partition(Sum_ins s) {

		Partition_ins partition_new = new Partition_ins(s.num_chiffre, s.chiffres);
		return partition_new;

	}

	public static void verifier_resoudre_jsp(JSP_ins jsp) {

		int[] array = new int[jsp.num_taches];
		int total = 0;
		for (int i = 0; i < jsp.num_taches; i++) {

			array[i] = jsp.tahches.get(i).duree;
			total = total + array[i];
			System.out.println(array[i]);
		}
		String[] possbilites = new String[] { "0", "1" };
		List<String> total_possibilites = Partition.total_possibilite(5, possbilites);
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

	}

	public static void verifier_resoudre_partition(Partition_ins p) {
		int[] array = new int[p.num];
		int total = 0;
		for (int i = 0; i < p.num - 1; i++) {
			array[i] = p.chiffres.get(i);

			System.out.println(array[i]);
		}

		int sum = p.chiffres.get(p.num - 1);
		System.out.println(sum);
		String[] possbilites = new String[] { "0", "1" };
		List<String> total_possibilites = Partition.total_possibilite(p.num - 1, possbilites);
		List<String> res = new ArrayList<String>();
		List<String> solutions = new ArrayList<String>();
		for (String s : total_possibilites) {
			char charArray[] = new char[s.length()];
			List<Integer> ajoute = new ArrayList<Integer>();
			String g = "";
			for (int i = 0; i < s.length(); i++) {
				charArray[i] = s.charAt(i);

				if (charArray[i] == '0') {
					ajoute.add(array[i]);
				}
			}
			Collections.sort(ajoute);
			Collections.reverse(ajoute);

			for (Integer i : ajoute) {
				g = g + i + "+";

			}

			if (Sum(ajoute) == sum) {
				String solution = g.substring(0, g.length() - 1) + "=" + sum;
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
			// List<String> solutions_moti = new ArrayList<String>();

			HashSet h = new HashSet(solutions);
			solutions.clear();
			solutions.addAll(h);
			for (String s : solutions) {
				System.out.println(s);
			}
		}

	}

	public static void verifier_resoudre_partition(JSP_ins jsp) {
		int[] array = new int[jsp.num_taches];
		int total = 0;
		for (int i = 0; i < jsp.num_taches - 1; i++) {
			array[i] = jsp.tahches.get(i).duree;

			System.out.println(array[i]);
		}

		int sum = jsp.tahches.get(jsp.num_taches - 1).duree;
		System.out.println(sum);
		String[] possbilites = new String[] { "0", "1" };
		List<String> total_possibilites = Partition.total_possibilite(jsp.num_taches - 1, possbilites);
		List<String> res = new ArrayList<String>();
		List<String> solutions = new ArrayList<String>();
		for (String s : total_possibilites) {
			char charArray[] = new char[s.length()];
			List<Integer> ajoute = new ArrayList<Integer>();
			String g = "";
			for (int i = 0; i < s.length(); i++) {
				charArray[i] = s.charAt(i);

				if (charArray[i] == '0') {
					ajoute.add(array[i]);
				}
			}
			Collections.sort(ajoute);
			Collections.reverse(ajoute);

			for (Integer i : ajoute) {
				g = g + i + "+";

			}

			if (Sum(ajoute) == sum) {
				String solution = g.substring(0, g.length() - 1) + "=" + sum;
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
			// List<String> solutions_moti = new ArrayList<String>();

			HashSet h = new HashSet(solutions);
			solutions.clear();
			solutions.addAll(h);
			for (String s : solutions) {
				System.out.println(s);
			}
		}

	}

	public static void main(String[] args) {

		List<Integer> chiffres = new ArrayList<Integer>();
		chiffres.add(12);
		chiffres.add(7);
		chiffres.add(4);
		chiffres.add(4);
		chiffres.add(5);
		Partition_ins p = new Partition_ins(chiffres.size(), chiffres);
		JSP_ins jsp = resoudre_jsp(p);
		System.out.println("Resoudre parision en jsp");
		verifier_resoudre_jsp(jsp);

		chiffres.clear();
		chiffres.add(11);
		chiffres.add(17);
		chiffres.add(19);
		chiffres.add(7);
		chiffres.add(8);
		p = new Partition_ins(chiffres.size(), chiffres);
		jsp = resoudre_jsp(p);
		System.out.println("Resoudre parition en jsp");
		verifier_resoudre_jsp(jsp);

		chiffres.clear();
		chiffres.add(2);
		chiffres.add(12);
		chiffres.add(8);
		chiffres.add(4);
		chiffres.add(6);
		chiffres.add(10);
		chiffres.add(4);
		chiffres.add(36);
		Sum_ins s = new Sum_ins(36, chiffres.size(), chiffres);
		p = resoudre_partition(s);
		System.out.println("test1:Resoudre sum en parition");
		verifier_resoudre_partition(p);
		System.out.println("test2:Resoudre sum en jsp");
		jsp = resoudre_jsp(s);
		verifier_resoudre_partition(jsp);

		chiffres.clear();
		chiffres.add(8);
		chiffres.add(12);
		chiffres.add(10);
		chiffres.add(12);
		chiffres.add(10);
		chiffres.add(9);
		chiffres.add(7);
		chiffres.add(54);
		System.out.println("test1:Resoudre sum en parition");
		s = new Sum_ins(54, chiffres.size(), chiffres);
		p = resoudre_partition(s);
		verifier_resoudre_partition(p);
		System.out.println("test2:Resoudre sum en jsp");
		jsp = resoudre_jsp(s);
		verifier_resoudre_partition(jsp);

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

}
