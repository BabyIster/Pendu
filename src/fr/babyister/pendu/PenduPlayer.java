package fr.babyister.pendu;

import java.util.ArrayList;
import java.util.Random;

import org.bukkit.entity.Player;

public class PenduPlayer {
	
	Player player;
	
	String word;
	String wordsGame = "";
	
	public ArrayList<String> letter = new ArrayList<>();
	public int life = 5;
	
	public PenduPlayer(Player player) {
		this.player = player;
		
		word = Pendu.words.get(getRandomWords());
		GenerateWordsGame();
	}
	
	public void setWord(String newWord) {
		this.word = newWord;
	}
	
	public String getWord() {
		return word;
	}
	
	public String getWordGame() {
		return wordsGame;
	}
	
	public int getRandomWords() {
		Random r = new Random();
		int valeur = r.nextInt(Pendu.words.size());
		
		return valeur;		
	}
	
	public void GenerateWordsGame() {
		
		wordsGame = " ";
		
		for (int i = 0; i < word.length(); i ++) {
			if(letter.contains("" + word.charAt(i))) {
				wordsGame = wordsGame + " " + "" + word.charAt(i) + " ";
			} else {
			wordsGame = wordsGame + " * ";
			}
		}
		
		player.sendMessage("§aVotre mot: " + wordsGame);
	}
}
