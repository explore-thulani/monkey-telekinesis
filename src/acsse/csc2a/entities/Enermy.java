package acsse.csc2a.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
/**
 * The Enermy is a game object that attacks the player in the game
 */

/**
 * 
 * @author Mr T Ncube
 *
 */
public class Enermy extends GameObject implements ObjectProduct {

	//Constant enemy speed
	private static final int SPEED = 5;
	
	Handler handler;
	
	//Getter for enemy speed
	public static int getSpeed() {
		return SPEED;
	}
	
	public Enermy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		velX = SPEED;
		velY = SPEED;
		
		this.handler =handler;
	}

	//This method controls how the enemy moves on the screen and checks for collision
	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		if(x <= 0 || x >= 640-32)
		{
			velX *= -1;
		}
		
		if(y <= 0 || y >= 480-32)
		{
			velY *= -1;
		}
		collision();
	}
	
	//This method checks if the enemy collides with the weapon(Banana was ice initially), if it does the enemy dies!
	private void collision(){
		
		for(int i = 0; i < handler.obj.size(); i++)
		{
			GameObject tempObject = handler.obj.get(i);
			
			if(tempObject.getId() == ID.Ice){
				if(getBounds().intersects(tempObject.getBounds())){
					handler.removeObj(this);
				}
			}
		}
	}
	
	//Gets Image for the enemy
	public BufferedImage image()
	{
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File("data/Goomba.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	@Override
	public void render(Graphics g) {
		g.drawImage(image(), x, y, 32, 32, null);
	}

	@Override
	public Rectangle getBounds() {	
		return new Rectangle(x, y, 10, 10);
	}
}
