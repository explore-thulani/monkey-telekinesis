package acsse.csc2a.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Ice which changed to a Banana will appear on the Game play screen as the weapon
 */

/**
 * @author Mr T Ncube
 *
 */
public class Ice extends GameObject implements ObjectProduct{
	
	//Weapon speed
	private final static int SPEED = 5;
	Handler handler;

	/**
	 * @return the sPEED
	 */
	public static int getSPEED() {
		return SPEED;
	}

	public Ice(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
	}

	@Override
	public void tick() {
		
		x += velX;
		y += velY;
		
		x = clamp(x, 0, 640-20);
		y = clamp(y, 0, 480-20);
	}

	@Override
	public void render(Graphics g) {
		if(id == ID.Ice){
			String fileName = "data/banana.png";
			g.drawImage(image(fileName), x, y, 20, 20, null);
		}
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle(x, y, 19, 19);
	}
	
	//Reads Banana Image
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

}
