package acsse.csc2a.factory;

import acsse.csc2a.entities.Handler;
import acsse.csc2a.entities.ID;
import acsse.csc2a.entities.ObjectProduct;


public abstract class ObjectFactory{
	
	public abstract ObjectProduct produceSnake(int x, int y, ID id, Handler handler);

	public abstract ObjectProduct produceIce(int x, int y, ID id, Handler handler);

	public abstract ObjectProduct producePlayer(int x, int y, ID id, Handler handler);

	public abstract ObjectProduct produceEnemy(int x, int y, ID id, Handler handler);
}