package JSP;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	@SuppressWarnings("resource")
	private static int choixProbleme() {
		System.out.println("\nVeuillez choisir un probleme parmis les suivants (indiquer numero) :");
		System.out.println("1. Job_shop");
		System.out.println("2. Partition");
		System.out.print("Numero du probleme : ");
		Scanner scan = new Scanner(System.in);
		int tmp = scan.nextInt();

		if (tmp < 1 || tmp > 2) {
			System.err.println("Numero de probleme invalide");
			return 0;
		}

		return tmp;
	}

	private static int choixMod() {
		System.out.println("\nVeuillez choisir un probleme parmis les suivants (indiquer numero) :");
		System.out.println("1. ver");
		System.out.println("2. non_determine");
		System.out.println("3. exhaust");
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
				parision.pari_exhaust();
				break;
			case 2:
				parision.pari_non_determine() ;
				break;

			case 1:

				parision.pari_ver();
				break;
			}

			break;

		}

	}

}