package it.polito.tdp.model;

import java.util.Map;
import java.util.TreeMap;

public class AlienDictionary {

	private Map<String, WordEnhanced> dictionary;

	public AlienDictionary() {
		this.dictionary = new TreeMap<String, WordEnhanced>();
	}

	public void addWord(String alienWord, String translation) {
		if (dictionary.containsKey(alienWord)) {
			dictionary.get(alienWord).addTraslation(translation);
		} else {
			WordEnhanced we = new WordEnhanced(alienWord);
			we.addTraslation(translation);
			dictionary.put(alienWord, we);
		}
	}

	public String translateWord(String alienWord) {
		if (!dictionary.containsKey(alienWord))
			return null;
		String s = "Traduzioni della parola " + alienWord + ": \n";
		for (String t : dictionary.get(alienWord).getTranslations()) {
			s += t + "\n";
		}
		return s;
	}
}
