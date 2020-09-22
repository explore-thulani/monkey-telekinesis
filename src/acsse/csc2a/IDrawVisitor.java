package acsse.csc2a;

import acsse.csc2a.entities.GameBackground;
import acsse.csc2a.entities.GameObject;

/**
 * 
 */

/**
 * @author Mr T Ncube
 *
 */
public interface IDrawVisitor {
	public void draw(GameBackground background);
	public void draw(GameObject obj);
}
