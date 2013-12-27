package Entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import Main.PlayState;

public class Word {

	int numWords;
	private int usedLetter = -1;
	
	private String lietro = "";
	private String[] startWords = new String[10];
	private String[] startLetter = new String[10];
	private int lietroPlace;
	private int lietroGo = 	0;
	String[] words;
	
	private String word = "";
	
	char[] cArray = word.toCharArray();
	private String[] rightGuessed = new String[10];
	private String[] wrongGuessed;
	
	private int amountRight;
	
	private PlayState playstate;
	
	public Word(PlayState p){
		playstate = p;
	}
	
	private void arrayInit(){
		for(int i = 0; i < startWords.length; i++){
			startLetter[i] = "";
		}
	}
	
	public void init(){
		arrayInit();
		word = makeAWord();
		splitWord();
		System.out.println(word);
	}
	
	public String makeAWord(){
		
		String word = "";
		
		try{
			
			InputStream in = getClass().getResourceAsStream("/Words");
			BufferedReader br = new BufferedReader(
					new InputStreamReader(in)
				);
			
			numWords = Integer.parseInt(br.readLine());
			 startWords = new String[numWords];
			for(int i  = 0; i < startWords.length; i++){
				String tempWord = br.readLine();
				startWords[i] = tempWord;
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Random r = new Random();
		int wordChoice = r.nextInt(startWords.length);
		word = startWords[wordChoice];
		
		return word;
	}
	
	public String getWord(){return word;}
	public void setWord(String s){word = s;}
	
	public int findWhere(String s){
		int here = -1;
		for(int i = 0; i < words.length; i++){
				if(s.equalsIgnoreCase(words[i])){
					if(i != usedLetter){
				usedLetter = i;
				here = i;
				}
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
						setLietroPlace(temp);
						setLetter(s);
						playstate.setGuessed(playstate.getGuessesMade(), s, true);
						playstate.setRight(temp, s, true);
						playstate.setRightGuesses(playstate.getRightGuesses() + 1);
						startLetter[temp] = s;
						
					}else{
						
						System.out.println("wrong");
						System.out.println("you guessed " + s);
						
						
						
						playstate.setGuessed(playstate.getGuessesMade(), s, true);
						playstate.setWrong(playstate.getWrongGuesses(), s, true);
						playstate.setWrongGuesses(playstate.getWrongGuesses() + 1);
						
			}
		}
	}
	
	public String getLetter(){
		return lietro;
	}
	private void setLetter(String s){
		lietro = s;
	}
	
	public int getLietroPlace(){
		return lietroPlace;
	}
	private void setLietroPlace(int i){
		lietroPlace = i;
	}
	
	public void splitWord(){
		words = word.split("(?!^)");
		for(int i = 0; i < words.length; i++){
			System.out.println(words[i]);
		}
	}
	
	public void soFar(){
		
		
		
	}

	public void drawDashes(Graphics g){
		for(int i = 1; i < word.length() + 1; i++){
			g.fillRect(i*60, 400, 40, 20);
		}
	}
	public void drawLetter(Graphics g, String s, int place){
		for(int i = 0; i < startLetter.length; i++){
			g.drawString(startLetter[i], 60 * i + 75, 395);
		}
		
	}
	public void draw(Graphics g){
		Font font = new Font("Serif", Font.BOLD, 32);
		g.setFont(font);
		g.setColor(Color.black);
		drawDashes(g);
		drawLetter(g, getLetter(), getLietroPlace());
	}
}
