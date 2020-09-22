package acsse.csc2a.factory;

import acsse.csc2a.entities.*;

/**
 * Objects factory produces the objects for the game
 */


/**
 * @author Mr T Ncube
 *
 */
public class ObjectsFactory extends ObjectFactory {

	@Override
	public ObjectProduct produceSnake(int x, int y, ID id, Handler handler) {
		return new Snake(x, y, id, handler);
	}

	@Override
	public ObjectProduct produceIce(int x, int y, ID id, Handler handler) {
		return new Ice(x, y, id, handler);
	}

	@Override
	public ObjectProduct producePlayer(int x, int y, ID id, Handler handler) {
		return new Player(x, y, id, handler);
	}

	@Override
	public ObjectProduct produceEnemy(int x, int y, ID id, Handler handler) {
		return new Enermy(x, y, id, handler);
	}
}
