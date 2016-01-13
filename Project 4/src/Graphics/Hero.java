package Graphics;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class Hero {
	
	BufferedImage sprite;
	String name;
	int x;
	int y;
	//"/images/heroes/gudetama.png"
	public Hero(String name, String imageLocation, int locationX, int locationY){
		this.name = name;
		int width = 300;
		int height = 250;
		x = locationX;
		y = locationY;
		sprite = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		URL url = getClass().getResource(imageLocation);
		
		try {
			BufferedImage original = ImageIO.read(url);
			//draw the image file into a scaled version on the sprite canvas
			Graphics2D g = (Graphics2D) sprite.getGraphics();
			int w = original.getWidth();
			int h = original.getHeight();
			g.drawImage(original, 0, 0, width, height, 0, 0, w, h, null);
				//What to draw, where to start(x,y), 
					//width of canvas(relative to start), 
					//height of canvas(relative to start),
					//Where to start from original(x,y), 
					//width of original,height,null
					
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	public BufferedImage getImage(){
		return sprite;
	}
	
	public String getName(){
		return name;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}



	public void moveUp() {
		// TODO Auto-generated method stub
		y-=20;
	}



	public void moveDown() {
		// TODO Auto-generated method stub
		y+=20;
	}



	public void moveLeft() {
		// TODO Auto-generated method stub
		x-=20;
	}



	public void moveRight() {
		// TODO Auto-generated method stub
		x+=20;
	}


}
