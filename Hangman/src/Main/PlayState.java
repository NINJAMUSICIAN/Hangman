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
	private int rightGuesses = 0;
	private boolean able = true, guessed = false, won = false;
	
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
		System.out.println("");
	}
	public void setRight(int num, String let, boolean print){//which place in array && what the letter is to be put in
		rightLets[num] = let;
			if(print){
			for(int i = 0; i < rightLets.length; i++){
				System.out.println("right letters so far " + rightLets[i]);
				
				}
			}
			System.out.println("");
		}
	public void setWrong(int num, String let, boolean print){
		wrongLets[num] = let;
		if(print){
		for(int i = 0; i < wrongLets.length; i++){
			System.out.println("wrong letters so far " + wrongLets[i]);
			
			}
		}
		System.out.println("");
	}
	
	public String[] getGuessedArr(){return guessedLets;}
	public String[] getWrongArr(){return wrongLets;}
	public String[] getRightArr(){return rightLets;}
	
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
		checkWin();
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
			if(Keys.isPressed(Keys.A)){
				checkIt("a");
				}
			else if(Keys.isPressed(Keys.B)){
				checkIt("b");
				}
			else if(Keys.isPressed(Keys.C)){
				checkIt("c");
				}
			else if(Keys.isPressed(Keys.D)){
				checkIt("d");
				}
			else if(Keys.isPressed(Keys.E)){
				checkIt("e");
				}
			else if(Keys.isPressed(Keys.F)){
				checkIt("f");
				}
			else if(Keys.isPressed(Keys.G)){
				checkIt("g");
				}
			else if(Keys.isPressed(Keys.H)){
				checkIt("h");
				}
			else if(Keys.isPressed(Keys.I)){
				checkIt("i");
				}
			else if(Keys.isPressed(Keys.J)){
				checkIt("j");
				}
			else if(Keys.isPressed(Keys.K)){
				checkIt("k");
				}
			else if(Keys.isPressed(Keys.L)){
				checkIt("l");
				}
			else if(Keys.isPressed(Keys.M)){
				checkIt("m");
				}
			else if(Keys.isPressed(Keys.N)){
				checkIt("n");
				}
			else if(Keys.isPressed(Keys.O)){
				checkIt("o");
				}
			else if(Keys.isPressed(Keys.P)){
				checkIt("p");
				}
			else if(Keys.isPressed(Keys.Q)){
				checkIt("q");
				}
			else if(Keys.isPressed(Keys.R)){
				checkIt("r");
				}
			else if(Keys.isPressed(Keys.S)){
				checkIt("s");
				}
			else if(Keys.isPressed(Keys.T)){
				checkIt("t");
				}
			else if(Keys.isPressed(Keys.U)){
				checkIt("u");
				}
			else if(Keys.isPressed(Keys.V)){
				checkIt("v");
				 }
			else if(Keys.isPressed(Keys.W)){
				checkIt("w");
				}
			else if(Keys.isPressed(Keys.X)){
				checkIt("x");
				}
			else if(Keys.isPressed(Keys.Y)){
				checkIt("y");
				}
			 else if(Keys.isPressed(Keys.Z)){
				checkIt("z");
				}
		}
	}

	public int getGuessesMade(){return guessesMade;}
	public int getWrongGuesses(){return wrongGuesses;}
	public void setWrongGuesses(int s){wrongGuesses = s;}
	public int getRightGuesses(){return rightGuesses;}
	public void setRightGuesses(int s){rightGuesses = s;}
	public void setAble(boolean b){
		able = b;
	}

	public void checkWin(){
		boolean won = false;
		//System.out.println(word.getWord().length());
		
		if(rightGuesses == word.getWord().length()){
			System.out.println("you win!");
			won = true;
		}
	
	}
	
}
