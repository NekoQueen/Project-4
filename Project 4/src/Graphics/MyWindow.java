package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class MyWindow extends JFrame implements KeyListener{
	
	int width = 800;
	int height = 800;
	Hero egg;
	Hero egg2;
	boolean itemPickedUp;
	BufferedImage landscape;
	
	
	
	public static void main(String[] args) {
		new MyWindow();
		
	}
	public MyWindow(){
		egg = new Hero("egg", "/images/heroes/gudetama.png", 100, 100);
		egg2 = new Hero("egg2", "/images/heroes/egg.png", 100, 400);
		itemPickedUp = false;
		landscape = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)landscape.getGraphics();
		paintLandscape(g2);
		
		
		//the following are JFrame methods
		setVisible(true);
		setSize(width, height);//units in px
		setLocation(200,150);//setLocation(right, down);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			//static constant references for special close operation
		addKeyListener(this);
		
		
	}
	public void paint(Graphics g){
		//Graphics is a crayon box
		//Graphics2d is like an art kit
		BufferedImage image = new BufferedImage(width,height,BufferedImage.TYPE_INT_ARGB);
		Graphics2D g2 = (Graphics2D)image.getGraphics();
		
		g2.setColor(new Color(50, 100, 200));
		g2.fillRect(0,  0,  width, height);
		
		g2.drawImage(landscape, 0, 0, null);
		
		
		
		if(Math.abs(egg.getX()- egg2.getX()) + Math.abs(egg.getY()- egg2.getY()) < 10){
			itemPickedUp = true;
		}
		
		if(!itemPickedUp){
			g2.drawImage(egg2.getImage(), egg2.getX(), egg2.getY(), null);
		}
		
		g2.drawImage(egg.getImage(), egg.getX(), egg.getY(), null);
		
		
//		g2.setColor(Color.white);
//		g2.fillRect(0, 0, width, height);
//		
//		g2.setColor(Color.red);		
//		g2.fillOval(50, 100, 10, 10);
//		g2.setColor(Color.black);
//		g2.drawOval(50, 100, 10, 10);
//		
//		g2.setColor(Color.red);		
//		g2.fillOval(150, 100, 10, 10);
//		g2.setColor(Color.black);
//		g2.drawOval(150, 100, 10, 10);
//		
//		g2.setColor(Color.black);
//		g2.drawOval(20, 50, 200, 200);
//		
//		g2.drawString("^", 155, 125);
//		g2.drawArc(154, 118, 6, 6, 180, 180);
//		
//		g2.drawString("^", 155, 150);
//		g2.drawArc(154, 143, 6, 6, 180, 180);
//		
//		g2.drawArc(95, 100, 25, 25, 0, 180);//Arc
//			//g2.drawArc(x, y, width, height, startDEG, lengthDEG);
//		
//		g2.drawString("You cut my face", 210, 90);//String
//			//g2.drawString("String", x, y);
//		g2.setColor(Color.red);
//		g2.drawLine(0,  0, width, height);//Line
//			//g2.drawLine(start x, start y, end x, end y);
//		
//		
//		
////		g2.setColor(Color.blue);
////		int squareD = 20;
////		int margin = 2;
////		
////		for(int x = 0; x < width; x += squareD + margin){
////			for(int y = 0; y < height; y += squareD + margin){
////				g2.fillRect(x, y, squareD, squareD);
////				g2.setColor(new Color(0, 0, x));
////				
////			}
////		}
//		//draw bufferedImage on the canvas
//		
//		
		g.drawImage(image, 0, 0, null);
		
		
		
	}
	
	public void paintLandscape(Graphics2D g2){
		
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_UP){
			egg.moveUp();
		}else if(key == KeyEvent.VK_DOWN){
			egg.moveDown();
		}else if(key == KeyEvent.VK_LEFT){
			egg.moveLeft();
		}else if(key == KeyEvent.VK_RIGHT){
			egg.moveRight();
		}
		if(key == KeyEvent.VK_W){
			egg2.moveUp();
		}else if(key == KeyEvent.VK_S){
			egg2.moveDown();
		}else if(key == KeyEvent.VK_A){
			egg2.moveLeft();
		}else if(key == KeyEvent.VK_D){
			egg2.moveRight();
		}
		
		repaint();
	}
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
