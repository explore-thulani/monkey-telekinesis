package acsse.csc2a;

import acsse.csc2a.entities.Handler;

/**
 * Interface for the game states
 */

/**
 * @author Mr T Ncube
 */
public interface GameState {
	void gameMenu();
	void gameStart(Handler handler);
	void gamePause();
}
