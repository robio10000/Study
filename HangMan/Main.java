package main;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	private static String[] words = { "hello", "Vermögenszuordnungszuständigkeitsübertragungsverordnung", "PC",
			"Marlboro", "moinsen", "hai" };		//I will read it from txt
	private static String word = words[(int) (Math.random() * words.length)];
	private static String stars = new String(new char[word.length()]).replace("\0", "*");
	private static int fails = 0;

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);

		while (fails < 7 && stars.contains("*")) { // Checks if you don't have too many fails and if you don't have a
													// star anymore
			System.out.println("Word: " + stars);
			System.out.println("Gimme a char!: ");
			String inp = sc.next();
			check(inp);
		}
		sc.close();

	}

	private static void check(String c) {
		String newStar = "";
		for (int i = 0; i < word.length(); i++) {
			if (word.charAt(i) == c.charAt(0)) {//checks if the input is equals 
				newStar += c.charAt(0);
			} else if (stars.charAt(i) != '*') {
				newStar += word.charAt(i);
			} else {
				newStar += "*";
			}
		}

		if (stars.equalsIgnoreCase(newStar)) {
			fails++;
			imgOut();
		} else {
			stars = newStar;
		}
		if (stars.equalsIgnoreCase(word)) {
			System.out.println("Nice! You win! The word was " + word);
		}

	}

	private static void imgOut() {
		if (fails == 1) {
			System.out.println("Wrong char, try again");
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println();
			System.out.println("___|___");
			System.out.println();
		}
		if (fails == 2) {
			System.out.println("Wrong char, try again");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (fails == 3) {
			System.out.println("Wrong char, try again");
			System.out.println("   ____________");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   | ");
			System.out.println("___|___");
		}
		if (fails == 4) {
			System.out.println("Wrong char, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /_ _\\");
			System.out.println("   |        | °.° |");
			System.out.println("   |         \\_-_/");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (fails == 5) {
			System.out.println("Wrong char, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /_ _\\");
			System.out.println("   |        | °.° |");
			System.out.println("   |         \\_-_/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |");
			System.out.println("___|___");
		}
		if (fails == 6) {
			System.out.println("Wrong char, try again");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /_ _\\");
			System.out.println("   |        | °.° |");
			System.out.println("   |         \\_-_/");
			System.out.println("   |           |");
			System.out.println("   |           |");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
		}
		if (fails == 7) {
			System.out.println("GAME OVER!");
			System.out.println("   ____________");
			System.out.println("   |          _|_");
			System.out.println("   |         /_ _\\");
			System.out.println("   |        | °.° |");
			System.out.println("   |         \\_-_/");
			System.out.println("   |          _|_");
			System.out.println("   |         / | \\");
			System.out.println("   |          / \\ ");
			System.out.println("___|___      /   \\");
			System.out.println("Sorry you have too many fails! The word was " + word);
		}

	}

}
