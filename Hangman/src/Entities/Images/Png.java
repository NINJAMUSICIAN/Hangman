package Entities.Images;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Png {

	private Animation animation;
	private ArrayList<BufferedImage[]> sprites;
	
	public Png(String s){
		
		try{
			BufferedImage spritesheet = ImageIO.read(
					getClass().getResourceAsStream(s));
					
			sprites = new ArrayList<BufferedImage[]>();
			for(int i = 0; i < 1; i++){ 
				BufferedImage[] bi = 
						new BufferedImage[1];
				for(int j = 0; j < 1; j++){
					bi[j] = spritesheet.getSubimage(j * 640, i * 480, 640, 480);
				
				}
				sprites.add(bi);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		animation = new Animation();
		animation.setFrames(sprites.get(0));
		animation.setDelay(400);
	}
	
	public void draw(Graphics g){
		g.drawImage(animation.getImage(), 0, 0, 640, 480, null);
	}
	
}
