package acsse.csc2a.entities;

import java.awt.Graphics;
import java.awt.Rectangle;

import acsse.csc2a.IDrawVisitor;
import acsse.csc2a.IDrawable;
import acsse.csc2a.entities.Handler;

/**
 * 
 * @author Mr T Ncube
 *
 */

/**
 * 
 * The abstract GameObject class is the base class that contains game objects(player, enemy and weapon)
 * It also implements the IDrawable interface which allows the objects to be drawable on the Game Panel 
 *
 */
public abstract class GameObject implements IDrawable{

	//Object attributes for the position on the objects on the screen
	protected int x, y;
	//Identification of the specific object using the ID enumeration
	protected ID id;
	//Attributes for the Objects' velocity
	protected int velX, velY;
	
	public abstract void tick();
	public abstract void render(Graphics g);
	//Bounds set around the objects inorder to check for collisions
	public abstract Rectangle getBounds();
	
	//Handler handles the Game objects
	Handler handler;
	
	//This method prevents objects from moving out of the Screen during the game
	/**
	 * @param var, min, max
	 * 
	 * @return var
	 */
	public static int clamp(int var, int min, int max){
		if(var<=min){return min;}
		else if(var>=max){return max;}
		else{
			return var;
		}
	}
	
	private int counter = 0;
	
	/**
	 * @return the counter
	 */
	public int getCounter() {
		return counter;
	}

	/**
	 * @param counter the counter to set
	 */
	public void setCounter(int counter) {
		this.counter = counter;
	}
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * 
	 * @param x
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * 
	 * @return y
	 */
	public int getY() {
		return y;
	}
	
	/**
	 * 
	 * @param y
	 */
	public void setY(int y) {
		this.y = y;
	}

	public ID getId() {
		return id;
	}


	public void setId(ID id) {
		this.id = id;
	}


	public int getVelX() {
		return velX;
	}


	public void setVelX(int velX) {
		this.velX = velX;
	}


	public int getVelY() {
		return velY;
	}


	public void setVelY(int velY) {
		this.velY = velY;
	}
	
	public GameObject(int x, int y, ID id){
		this.x = x;
		this.y = y;
		this.id = id;
	}
	@Override
	public void accept(IDrawVisitor visitor) {
		visitor.draw(this);
	}
	
}

