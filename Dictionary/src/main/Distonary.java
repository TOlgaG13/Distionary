package main;

import java.util.HashMap;
import java.util.Map;

public class Distonary {
	private Map<String, String> dictionary = new HashMap<>();
	private Map<String, String> dictionaryUaToEn = new HashMap<>();

	public void addWord(String wordEn, String transUa) {
		dictionary.put(wordEn.trim(), transUa.trim());
	    dictionaryUaToEn.put(transUa.trim(), wordEn.trim());
		System.out.println("The word has been added to the dictionary: " + wordEn + " - " + transUa);
		System.out.println("UaWord->En" + transUa + " - " + wordEn);
	}

	public String getTranslation(String wordEn) {
		return dictionary.getOrDefault(wordEn, "No translation found");
	}

	public String getTranslationUaToEn(String wordUa) {
	    wordUa = wordUa.trim();
	    String translation = dictionaryUaToEn.get(wordUa);
	    if (translation == null) {
	        System.out.println("Translate for " + wordUa + " dont found!");
	    }
	    return translation != null ? translation : "Translate dont found";
	}

	public void displayAllWords() {
		if (dictionary.isEmpty() && dictionaryUaToEn.isEmpty()) {
			System.out.println("The dictionary is empty.");
		} else {
			System.out.println("All words in the dictionary:");
			dictionary.forEach((english, ukrainian) -> System.out.println(english + " - " + ukrainian));
			dictionaryUaToEn.forEach((ukrainian, english) -> System.out.println(ukrainian + " - " + english));
		}
	}

	public Map<String, String> getDictionary() {
		return dictionary;
	}

	public void setDictionary(Map<String, String> dictionary) {
		this.dictionary = dictionary;
	}
}
