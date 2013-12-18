package Main;

import java.awt.Color;
import java.awt.Graphics;

import Entities.Word;
import GameState.Keys;

public class PlayState {

	private Word word;
	private long waitTimer;
	private int started = 0;
	private int guessesMade = 0;
	private int wrongGuesses = 0;
	private boolean able = true, guessed = false;
	
	private String[] guessedLets;
	private String[] wrongLets;
	private String[] rightLets;
	
	public PlayState(){
		init();
	}
	
	public void initArrays(){
		for(int i = 0; i < guessedLets.length; i++){
			setGuessed(i, " ", false);
		}
		
		for(int i = 0; i < wrongLets.length; i++){
			setWrong(i, " ", false);
		}
		
		for(int i = 0; i < rightLets.length; i++){
			setRight(i, " ", false);
		}
		
	}
	
	public void init(){
		word = new Word(this);
		word.splitWord();
		
		guessedLets = new String[word.getWord().length() + 6];
		wrongLets = new String[6];
		rightLets = new String[word.getWord().length()];
		
		initArrays();
	}
	
	public void setGuessed(int num, String let, boolean print){//which place in array && what the letter is to be put in
		guessedLets[num] = let;
		if(print){
		for(int i = 0; i < guessedLets.length; i++){
			System.out.println("letter guessed so far " + guessedLets[i]);
			}
		}
	}
	public void setRight(int num, String let, boolean print){//which place in array && what the letter is to be put in
		rightLets[num] = let;
			if(print){
			for(int i = 0; i < rightLets.length; i++){
				System.out.println("right letters so far " + rightLets[i]);
				}
			}
		}
	public void setWrong(int num, String let, boolean print){
		wrongLets[num] = let;
		if(print){
		for(int i = 0; i < wrongLets.length; i++){
			System.out.println("wrong letters so far " + wrongLets[i]);
			}
		}
	}
	
	public String[] getGuessedArr(){return guessedLets;}
	public String[] getWrongArr(){return wrongLets;}
	public String[] getRightArr(){return rightLets;}
	
	
	
	public void setAble(boolean b){
		able = b;
	}
	
	public void startTimer(){
		
			waitTimer = System.nanoTime();
		
	}
	
	public void moveWait(){
		//counts down time before you can guess again
		if(started == 1){
			long elapsed = (System.nanoTime() - waitTimer) / 1000000;
			if(elapsed > 1000){
				System.out.println("goNow");
				setAble(true);
				guessed = false;
				started = 0;
			}
		}
	}
	
	public void update(){
		handleInput();
		moveWait();
	}
	
	public void draw(Graphics g){
	g.setColor(Color.gray);	
	g.fillRect(0, 0, 640, 480);
	}

	public void checkIt(String g){
		word.checkGuess(g);
		able = false;
		guessed = true;
		guessesMade++;
		startTimer();
		started = 1;
		moveWait();
	}
	
	public void handleInput(){
		if(able){
			if(Keys.isPressed(Keys.C)){
				checkIt("c");
				}
		if(Keys.isPressed(Keys.D)){
			checkIt("d");
			}
		}
	}

	public int getGuessesMade(){return guessesMade;}
	public int getWrongGuesses(){return wrongGuesses;}
	public void setWrongGuesses(int s){wrongGuesses = s;}
}
