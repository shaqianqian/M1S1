package JSP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {//为了显示好看，没有什么功能

	@SuppressWarnings("resource")
	private static int choixProbleme() {
		System.out.println("\nVeuillez choisir un probleme parmis les suivants (indiquer le numero) :");
		System.out.println("1. Job_shop");
		System.out.println("2. Partition");
		System.out.println("3. Sum");
		System.out.print("Numero du probleme : ");
		Scanner scan = new Scanner(System.in);
		int tmp = scan.nextInt();

		if (tmp < 1 || tmp > 3) {
			System.err.println("Numero de probleme invalide");
			return 0;
		}

		return tmp;
	}

	private static int choixMod() {
		System.out.println("\nVeuillez choisir un probleme parmis les suivants (indiquer le numero) :");
		System.out.println("1. Verification");
		System.out.println("2. Non_deterministe");
		System.out.println("3. Exhaust");
		System.out.print("Numero du mode : ");
		Scanner scan = new Scanner(System.in);
		int tmp = scan.nextInt();

		if (tmp < 1 || tmp > 3) {
			System.err.println("Numero de mode invalide");
			return 0;
		}

		return tmp;
	}

	public static void main(String[] args)
			throws NumberFormatException, IOException, NoSuchMethodException, SecurityException {

		/* Choix du probl�me */
		int pb = 0;
		while (pb == 0)
			pb = choixProbleme();

		switch (pb) {

		/////////////
		/* jsp */
		/////////////
		case 1:
			int cm = choixMod();
			switch (cm) {
			case 3:
				Job_shop.jobshop_exhaust();
				break;
			case 2:
				Job_shop.jobshop_non_determine();
				break;

			case 1:

				Job_shop.jobshop_ver();
				break;
			}

			break;

		///////////////
		/* Partition */
		///////////////
		case 2:
			cm = choixMod();
			switch (cm) {
			case 3:
				Partition.pari_exhaust();
				break;
			case 2:
				Partition.pari_non_determine();
				break;

			case 1:

				Partition.pari_ver();
				break;
			}

			break;
		///////////////
		/* Sum */
		///////////////
		case 3:
			cm = choixMod();
			switch (cm) {
			case 3:
				Sum.sum_exhaust();
				break;
			case 2:
				Sum.sum_non_determine();
				break;

			case 1:

				 Sum.sum_ver();
				break;
			}

			break;
		}

	}

}