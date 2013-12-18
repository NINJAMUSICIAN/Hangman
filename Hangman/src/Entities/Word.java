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
		System.out.println(here);
		return here;
	}
	
	public void checkGuess(String s){
		int temp = 0;
		
		if(word.contains(s)){
			System.out.println("right!");
			System.out.println("correct guess was " + s);
			
			temp = findWhere(s);
			playstate.setGuessed(playstate.getGuessesMade(), s);
		}else{
			System.out.println("wrong");
			System.out.println("you guessed " + s);
			
			
			temp = findWhere(s);
			playstate.setGuessed(playstate.getGuessesMade(), s);
			
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
