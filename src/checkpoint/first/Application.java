package checkpoint.first;

import java.util.Scanner;

public class Application {
	public static void main(String[] args) {
		String[] automakers = {"GM", "Hyundai", "Volkswagen", "Audi", "Mercedes", "Peugeot"};
		String[][] cars = {
			{"Suburban", "Malibu", "Silverado"},
			{"Azera", "Sonata", "Veloster"},
			{"Golf", "Jetta", "Polo"},
			{"A4", "Q7", "R8"},
			{"C 180", "C 200", "GLA 200"},
			{"206", "208", "2008"}
		};

		while (true) {

			int index = 1;
			for (int i = 0; i < automakers.length; i++) {
				System.out.printf("%d - %s\n", index, automakers[i]);
				index++;
			}
			System.out.println("0 - Exit");

			Scanner in = new Scanner(System.in);
			int selectedNumber = in.nextInt();
			if (selectedNumber < 0 || selectedNumber > 6) {
				System.out.println("Input not allowed!");
				continue;
			}

			if (selectedNumber == 0)
				break;

			System.out.println("Available vehicles:");
			System.out.println(automakers[selectedNumber-1]);
			for (int j = 0; j < cars[selectedNumber-1].length; j++) {
				System.out.println(cars[selectedNumber-1][j]);
			}

			System.out.println("Do you wish to continue?");
			System.out.println("0 - No");
			System.out.println("1 - Yes");

			int selectedNumber2 = in.nextInt();
			if (selectedNumber2 < 0 || selectedNumber2 > 1) {
				System.out.println("Input not allowed!");
				return;
			}

			if (selectedNumber2 == 0)
				break;
		}
	}
}
