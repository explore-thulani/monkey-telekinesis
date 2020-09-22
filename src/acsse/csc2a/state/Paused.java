package acsse.csc2a.state;
import acsse.csc2a.*;
import acsse.csc2a.entities.Handler;
import acsse.csc2a.ui.Game;


/**
 * Executed when the game is paused
 */

/**
 * @author Mr T Ncube
 *
 */
public class Paused implements GameState {

	Game game;
	
	public Paused(Game newGame) {
		game = newGame;
	}

	@Override
	public void gameMenu() {
		System.out.println("Menu");
		game.setGameState(game.menu);
	}

	@Override
	public void gameStart(Handler handler) {
		game.setGameState(game.playing);
	}

	@Override
	public void gamePause() {
		gameMenu();
		game.setGameState(game.paused);
	}
}
