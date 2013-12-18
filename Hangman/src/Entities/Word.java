package Entities;

public class Word {

	private String word = "drag";
	char[] cArray = word.toCharArray();
	private String[] rightGuessed = new String[10];
	private String[] wrongGuessed;
	
	private int amountRight;
	
	public Word(){
		
	}
	
	public String getWord(){return word;}
	public void setWord(String s){word = s;}
	
	public void checkGuess(String s){
		if(word.contains(s)){
			System.out.println("right!");
			rightGuessed[1] = s;
			amountRight++;
			for(int i = 0; i < amountRight; i++){
			}
			System.out.println("correct guess was " + rightGuessed[1]);
			
		}else{
			System.out.println("wrong");
		}
	}
	
	public void splitWord(){
		String[] words = word.split("(?!^)");
		for(int i = 0; i < words.length; i++){
			System.out.println(words[i]);
		}
	}
	
	public void soFar(){
		
		
		
	}
}
