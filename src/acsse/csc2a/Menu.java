package acsse.csc2a;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import acsse.csc2a.entities.Handler;
import acsse.csc2a.ui.Game;

/**
 * Menu is Executed at the Beginning of the game\
 */

/**
 * @author Mr T Ncube
 *
 */
public class Menu extends KeyAdapter implements GameState {

	Game game;
	public Menu(Game newGame) {
		game = newGame;
	}

	@Override
	public void gameMenu() {
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
	
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		System.out.println(key);
		if(key == KeyEvent.VK_ENTER)
		{
			game.setGameState(game.playing);
		}
	}
	public void keyReleased(KeyEvent e){
		
	}
}
