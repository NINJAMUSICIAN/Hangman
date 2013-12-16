package Entities;

public class Word {

	private String word = "drag";
	
	public Word(){
		
	}
	
	public String getWord(){return word;}
	public void setWord(String s){word = s;}
	
	public void checkGuess(String s){
		if(word.contains(s)){
			System.out.println("right!");
		}else{
			System.out.println("wrong");
		}
	}
}
