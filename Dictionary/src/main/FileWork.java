package main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

public class FileWork {
	private final String fileName;

	public FileWork(String fileName) {
		this.fileName = fileName;
		initFileWithWords();
	}

	private void initFileWithWords() {
		File file = new File(fileName);
		if (!file.exists()) {
			try (PrintWriter writer = new PrintWriter(new FileWriter(file))) {

				writer.println("hello=привіт");
				writer.println("book=книга");
				writer.println("apple=яблуко");
				writer.println("computer=комп'ютер");
				writer.println("city=місто");
				System.out.println("The file was created with cob words.");
			} catch (IOException e) {
				System.out.println("Error creating file " + e.getMessage());
			}
		}
	}

	public void saveDictionaryToFile(Distonary dictonary) {
		try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
			for (Map.Entry<String, String> entry : dictonary.getDictionary().entrySet()) {
				writer.println(entry.getKey() + "=" + entry.getValue());
			}
			System.out.println("Dictionary successfully saved to file.");
		} catch (IOException e) {
			System.out.println("Error saving to file: " + e.getMessage());
		}
	}

	public void loadDictionaryFromFile(Distonary dictonary) {
		   Map<String, String> loadedDictionary = new HashMap<>();
		    try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
		        String line;
		        while ((line = reader.readLine()) != null) {
		            String[] parts = line.split("=");
		            if (parts.length == 2) {
		                loadedDictionary.put(parts[0].trim(), parts[1].trim()); 
		                
		                dictonary.addWord(parts[0].trim(), parts[1].trim());
		            }
		        }
		        dictonary.setDictionary(loadedDictionary);
		        System.out.println("Dictionary successfully loaded from file.");
		        
		        dictonary.displayAllWords();
		    } catch (IOException e) {
		        System.out.println("Error reading from file: " + e.getMessage());
		    }
		}
}