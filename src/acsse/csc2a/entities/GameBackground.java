package acsse.csc2a.entities;

import acsse.csc2a.IDrawVisitor;
import acsse.csc2a.IDrawable;

/**
 * 
 */

/**
 * @author Mr T Ncube
 *
 * GameBackground accepts the visitor to draw it
 */
public class GameBackground implements IDrawable{

	public GameBackground() {
	}

	@Override
	public void accept(IDrawVisitor visitor) {
		visitor.draw(this);
	}
}
