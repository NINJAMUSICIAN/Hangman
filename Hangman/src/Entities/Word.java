package Entities;

import Main.PlayState;

public class Word {

	String[] words;
	
	private String word = "rdag";
	char[] cArray = word.toCharArray();
	private String[] rightGuessed = new String[10];
	private String[] wrongGuessed;
	
	private int amountRight;
	
	private PlayState playstate;
	
	public Word(PlayState p){
		playstate = p;
	}
	
	public String getWord(){return word;}
	public void setWord(String s){word = s;}
	
	public int findWhere(String s){
		int here = -1;
		for(int i = 0; i < words.length; i++){
				if(s.equalsIgnoreCase(words[i])){
				here = i;
			}
		}
		return here;
	}
	
	public boolean alreadyGuessed(String s){
		boolean returned = false;
		
		if(playstate.getGuessesMade() > 0){
			for(int i = 0; i < playstate.getGuessedArr().length; i++){
				if(playstate.getGuessedArr()[i].contains(s)){
					System.out.println("you already guessed that!");
					returned = true;
				}
			}
		}
		return returned;
	}
	
		
	public void checkGuess(String s){
		int temp = 0;
		
		if(!alreadyGuessed(s)){
					if(word.contains(s)){
						System.out.println("right!");
						System.out.println("correct guess was " + s);
						
						temp = findWhere(s);
						playstate.setGuessed(playstate.getGuessesMade(), s, true);
						playstate.setRight(temp, s, true);
						
					}else{
						
						System.out.println("wrong");
						System.out.println("you guessed " + s);
						
						
						
						playstate.setGuessed(playstate.getGuessesMade(), s, true);
						playstate.setWrong(playstate.getWrongGuesses(), s, true);
						playstate.setWrongGuesses(playstate.getWrongGuesses() + 1);
						
			}
		}
	}
	
	public void splitWord(){
		words = word.split("(?!^)");
		for(int i = 0; i < words.length; i++){
			System.out.println(words[i]);
		}
	}
	
	public void soFar(){
		
		
		
	}
}
