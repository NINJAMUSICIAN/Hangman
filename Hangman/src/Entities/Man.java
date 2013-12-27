package Entities;

import java.awt.Graphics;

public class Man {

	private int wrongs = 0;
	private boolean won = false;
	private int wrongGuesses;
	
	public Man(int wrongGuesses){
		this.wrongGuesses = wrongGuesses;
	}

	private void drawHead(Graphics g){
		if(wrongs >= 1){
			g.drawOval(100, 100, 40, 40);
		}
	}
	private void drawBody(Graphics g){
		if(wrongs >= 2){
			g.drawLine(120, 140, 120, 240);
		}
	}
	private void drawLeftLeg(Graphics g){
		if(wrongs >= 3){
			g.drawLine(120, 240, 90, 300);
		}
	}
	private void drawRightLeg(Graphics g){
		if(wrongs >= 4){
			g.drawLine(120, 240, 150, 300);
		}
	}
	private void drawRightArm(Graphics g){
		if(wrongs >= 5){
			g.drawLine(120, 150, 140, 240);
		}
	}
	private void drawLeftArm(Graphics g){
		if(wrongs >= 6){
			g.drawLine(120, 150, 100, 240);
		}
	}
	
	private void drawLoser(Graphics g){
		if(wrongs >= 6){
			g.drawString("YOU LOSE!!!", 300, 40);
		}
	}
	
	private void drawWinner(Graphics g){
		if(won){
			g.drawString("YOU WIN!!!!", 300, 40);
		}
	}
	
	public void update(int howMany, boolean hasWon){
		wrongs = howMany;
		won = hasWon;
	}

	public void draw(Graphics g){
		drawHead(g);
		drawBody(g);
		drawLeftLeg(g);
		drawRightLeg(g);
		drawRightArm(g);
		drawLeftArm(g);
		drawLoser(g);
		drawWinner(g);
	}
	
}
