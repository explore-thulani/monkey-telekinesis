package acsse.csc2a.entities;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * The player is a game object which will appear as the monkey on the game play screen
 */

/**
 * 
 * @author Mr T Ncube
 *
 */

public class Player extends GameObject implements ObjectProduct{

	//Player speed
	private final static int SPEED = 3;
	
	//Counter for player lives
	private int count = 0;
	
	Handler handler;


	/**
	 * @return the sPEED
	 */
	public static int getSPEED() {
		return SPEED;
	}
	
	public Player(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	@Override
	public void tick() {
			
		//if(x >= 0 && x <= 640-50 && y >= 0 && y <= 480-50){
		x += velX;
		y += velY;//}
		
		x = clamp(x, 0, 640-50);
		y = clamp(y, 0, 480-50);
		
		if(y < 0 || y <= (2*(480-50)/3)+50)
		{
			velY *= -1;
		}
		collision();
			
	}
	//Reads player image
	public BufferedImage image(String fileName)
	{
		BufferedImage image = null;
		try {
			image = ImageIO.read(new File(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	@Override
	public void render(Graphics g) {
		if(id == ID.Player)
		{
			String fileName = "data/product_monkey.png";
			g.drawImage(image(fileName), x,y,50,50, null);
		}
	}
	
	//Checks for collisions, if the enemy collides with the player 4 times, the player dies and the game ends
	private void collision(){
		
		for(int i = 0; i < handler.obj.size(); i++)
		{
			GameObject tempObject = handler.obj.get(i);
			
			if(tempObject.getId() == ID.Enermy){
				if(getBounds().intersects(tempObject.getBounds())){
					count++;
					if(count >= 4)
					{
						System.out.println("Game Over");
						System.exit(0);
					}
				}
			}
		}
	}
	
	@Override
	public Rectangle getBounds() {
		
		return new Rectangle(x, y, 10, 10);
	}

}
