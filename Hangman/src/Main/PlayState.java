package Main;

import java.awt.Color;
import java.awt.Graphics;

import Entities.Word;
import GameState.Keys;

public class PlayState {

	Word word;
	
	public PlayState(){
		init();
	}
	
	public void init(){
		word = new Word();
		System.out.println(word.getWord());
	}

	public void moveWait(){ //counts down time before you can guess again
		
	}
	
	public void update(){
		handleInput();
	}
	
	public void draw(Graphics g){
	g.setColor(Color.gray);	
	g.fillRect(0, 0, 640, 480);
	}

	public void handleInput(){
		
		if(Keys.isPressed(Keys.D)){
			word.checkGuess("d");
		}
	}
}
