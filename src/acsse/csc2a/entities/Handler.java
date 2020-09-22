package acsse.csc2a.entities;

import java.awt.Graphics;
import java.util.ArrayList;

import acsse.csc2a.entities.GameObject;
import acsse.csc2a.ui.DrawGraphicsVisior;

/**
 * Handler handles the addition and removal of Game objects into/out of the Game Objects Array List 
 */

/**
 * 
 * @author Mr T Ncube
 *
 */
public class Handler {
	
	//Creating new Game Object Array List
	public ArrayList<GameObject> obj = new ArrayList<GameObject>();
	public DrawGraphicsVisior visitor = new DrawGraphicsVisior();
	
	//Adds functionality to the GameObjects in the Array list
	public void tick(){
		for(int i = 0; i < obj.size(); i++){
			GameObject tempObj = obj.get(i);
			tempObj.tick();
		}
	}	
	
	//Allows game objects to be rendered
	public void render(Graphics g){
		for(int i = 0; i < obj.size(); i++){
			GameObject tempObj = obj.get(i);
			
			tempObj.render(g);
			//tempObj.accept(visitor);
		}
	}
	//Adds Game object into the array list
	public void addObj(GameObject obj){
		this.obj.add(obj);
	}
	//Removes Game Object from the Array List
	public void removeObj(GameObject obj){
		this.obj.remove(obj);
	}
	
	//Accepts the Game Objects in the Array List to be Drawn
	public void drawGameEntities(ArrayList<GameObject> objects){
		this.obj = objects;
		for(GameObject object: objects){
			object.accept(visitor);
		}

	}
	
}
