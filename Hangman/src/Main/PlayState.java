package Main;

import java.awt.Color;
import java.awt.Graphics;

import Entities.Word;
import GameState.Keys;

public class PlayState {

	private Word word;
	private long waitTimer;
	private int started = 0;
	private boolean able = true, guessed = false;;
	
	public PlayState(){
		init();
	}
	
	public void init(){
		word = new Word();
		word.splitWord();
	}
	
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

	public void handleInput(){
		if(able){
		if(Keys.isPressed(Keys.D)){
			word.checkGuess("d");
			able = false;
			guessed = true;
			startTimer();
			started = 1;
			moveWait();
			}
		}
	}
}
