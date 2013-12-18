package Main;

import java.awt.Color;
import java.awt.Graphics;

import Entities.Word;
import GameState.Keys;

public class PlayState {

	private Word word;
	private long waitTimer;
	private boolean able = true;
	
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
	
	public void moveWait(){ //counts down time before you can guess again
		setAble(false);
		waitTimer = System.nanoTime();
		long elapsed = (System.nanoTime() - waitTimer) / 1000000;
		
		if(elapsed > 1000){
			System.out.println("goNow");
			setAble(true);
		}
	}
	
	public void update(){
		handleInput();
	}
	
	public void draw(Graphics g){
	g.setColor(Color.gray);	
	g.fillRect(0, 0, 640, 480);
	}

	public void handleInput(){
		if(able){
		if(Keys.isPressed(Keys.D)){
			word.checkGuess("d");
			moveWait();
			}
		}
	}
}
