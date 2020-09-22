package acsse.csc2a.entities;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import acsse.csc2a.ui.Game;

/**
 * Snake gives Telekinesis powers to the Player
 */

/**
 * @author Mr T Ncube
 *
 */
public class Snake extends GameObject implements ObjectProduct{
	
	private final static int SPEED = 2;
	//private int count = 0;
	Handler handler;
	//Graphics g;

	/**
	 * @return the sPEED
	 */
	public static int getSPEED() {
		return SPEED;
	}

	public Snake(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		this.handler = handler;
		velX = SPEED;
	}

	@Override
	public void tick() {
		
		x += velX;
		//y += velY;//}
		x = clamp(x, 0, 640-30);
		if(x <= 0 || x >= Game.WIDTH-30)
		{
			velX *= -1;
		}
		
		collision();
	}
	@Override
	public void render(Graphics g) {
		if(id == ID.Snake){
			String fileName = "data/snake.png";
			//g.setColor(Color.DARK_GRAY);
			g.drawImage(image(fileName), x, y, 30, 30, null);
		}
	}
	
private void collision(){
		
		for(int i = 0; i < handler.obj.size(); i++)
		{
			GameObject tempObject = handler.obj.get(i);
			
			if(tempObject.getId() == ID.Player){
				if(getBounds().intersects(tempObject.getBounds())){
						System.out.println("Game Over");
						System.exit(0);
				}
			}
		}
	}

	@Override
	public Rectangle getBounds() {
		
		return new Rectangle(x, y, 30, 30);
	}
	
	
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
