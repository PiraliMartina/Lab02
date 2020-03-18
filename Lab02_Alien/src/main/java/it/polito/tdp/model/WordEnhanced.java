package it.polito.tdp.model;

import java.util.LinkedList;
import java.util.List;

public class WordEnhanced {

	private String alienWord;
	private List<String> translations;
	
	public WordEnhanced(String alienWord) {
		this.alienWord = alienWord;
		this.translations = new LinkedList<String>();
	}

	public String getAlienWord() {
		return alienWord;
	}

	public List<String> getTranslations() {
		return translations;
	}
	
	public void addTraslation(String w) {
		translations.add(w);
	}
	
	@Override
	public boolean equals (Object obj) {
		String s = (String) obj;
		if(this.alienWord.compareTo(s)==0)
			return true;
		return false;
	}
	

}
