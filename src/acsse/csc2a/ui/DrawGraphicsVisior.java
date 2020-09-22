package acsse.csc2a.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import acsse.csc2a.IDrawVisitor;
import acsse.csc2a.entities.GameBackground;
import acsse.csc2a.entities.GameObject;
import acsse.csc2a.entities.Handler;
import acsse.csc2a.entities.ID;

/**
 * The DrawGraphics visitor class draws the game objects and game background by implementing the IDrawVisitor
 */

/**
 * @author Mr T. Ncube
 *
 */
public class DrawGraphicsVisior implements IDrawVisitor{

	private Graphics g;
	private Handler handler;
	
	//Drawing Game Background
	@Override
	public void draw(GameBackground background) {
		g.clearRect(0, 0, Game.WIDTH, Game.HEIGHT);
		String fileName = "data/image.bmp";
		g.drawImage(image(fileName), 0, 0, Game.WIDTH, Game.HEIGHT, null);
	}
	
	//Drawing Game Objects
	@Override
	public void draw(GameObject obj) {
		for(int i = 0; i < handler.obj.size();i++ )
			obj = handler.obj.get(i);
			if(obj.getId() == ID.Player)
			{
				String fileName = "data/product_monkey.png";
				g.drawImage(image(fileName), obj.getX(),obj.getY(),32,32, null);
			}
			if(obj.getId() == ID.Enermy)
			{
				String fileName = "data/Goomba.png";
				g.drawImage(image(fileName), obj.getX(),obj.getY(),50,50, null);
			}
			if(obj.getId() == ID.Snake)
			{
				String fileName = "data/snake.png";
				g.drawImage(image(fileName), obj.getX(), obj.getY(), 30, 30, null);
			}	
	}
	
	//Accessors and Mutators
	public void setGraphics(Graphics g){
		this.g = g;
	}
	
	//Method that gets images from the data folder
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
