package main;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Distonary dictonary = new Distonary();
		FileWork fileWork = new FileWork("dictionary.txt");
		Scanner scanner = new Scanner(System.in);

		fileWork.loadDictionaryFromFile(dictonary);

		while (true) {
			System.out.println("\nChoose an action:");
			System.out.println("1. Add a new word");
			System.out.println("2. View the translation of the word(En->Ua)");
			System.out.println("3. View the translation of the word (Ua->En)");
			System.out.println("4. Show all word");
			System.out.println("5. Save the dictionary to a file");
			System.out.println("6. Download dictionary from file");
			System.out.println("7. Exit");

			int choice = scanner.nextInt();
			scanner.nextLine();

			switch (choice) {
			case 1:
				System.out.print("Input english word: ");
				String wordEn = scanner.nextLine();
				System.out.print("Input ukranian translate: ");
				String transUa = scanner.nextLine();
				dictonary.addWord(wordEn, transUa);
				break;
			case 2:
				System.out.print("Input english word for translate ");
				String wordToTranslate = scanner.nextLine();
				System.out.println("Translate " + dictonary.getTranslation(wordToTranslate));
				break;
			case 3:
				System.out.print("Input ukranian word for translate ");
				String wordToTranslateUa = scanner.nextLine();
				System.out.println("Translate: " + dictonary.getTranslationUaToEn(wordToTranslateUa));
				break;
			case 4:
				dictonary.displayAllWords();
				break;
			case 5:
				fileWork.saveDictionaryToFile(dictonary);
				break;
			case 6:
				fileWork.loadDictionaryFromFile(dictonary);
				break;
			case 7:
				System.out.println("Exit the program.");
				return;
			default:
				System.out.println("Wrong choice. Try again.");
			}
		}
	}
}
