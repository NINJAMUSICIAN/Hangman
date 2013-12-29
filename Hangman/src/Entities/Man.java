package Entities;

import java.awt.Graphics;

public class Man {

	private int wrongs = 5;
	private boolean won = false;
	private int wrongGuesses;
	
	public Man(int wrongGuesses){
		this.wrongGuesses = wrongGuesses;
	}

	private void drawHead(Graphics g){
		if(wrongs >= 1){
			g.drawOval(400, 101, 90, 90);
			g.drawOval(399, 100, 92, 92);
		}
	}
	private void drawBody(Graphics g){
		if(wrongs >= 2){
			g.drawLine(445, 192, 445, 364);
			g.drawLine(446, 192, 446, 364);
			
		}
	}
	private void drawLeftLeg(Graphics g){
		if(wrongs >= 3){
			//g.drawLine(120, 240, 90, 300);
			g.drawLine(446, 364, 416, 424);
			g.drawLine(447, 364, 417, 424);
		}
	}
	private void drawRightLeg(Graphics g){
		if(wrongs >= 4){
			
			//g.drawLine(120, 240, 150, 300);
			g.drawLine(446, 364, 476, 424);
			g.drawLine(447, 364, 477, 424);
		}
	}
	private void drawRightArm(Graphics g){
		if(wrongs >= 5){
			g.drawLine(445, 210, 480, 300);
			g.drawLine(445, 209, 480, 299);
			g.drawLine(445, 208, 480, 298);
		}
	}
	private void drawLeftArm(Graphics g){
		if(wrongs >= 6){
			g.drawLine(445, 210, 410, 300);
			g.drawLine(445, 209, 410, 299);
			g.drawLine(445, 208, 410, 298);
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
