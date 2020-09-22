package acsse.csc2a.state;

import java.util.Random;

import acsse.csc2a.GameState;
import acsse.csc2a.entities.GameObject;
import acsse.csc2a.entities.Handler;
import acsse.csc2a.entities.ID;
import acsse.csc2a.factory.ObjectFactory;
import acsse.csc2a.factory.ObjectsFactory;
import acsse.csc2a.ui.Game;


/**
 * Playing is executed after the menu if the Start Game button was clicked
 */

/**
 * 
 * @author Mr T Ncube
 *
 */

public class Playing implements GameState {
	
	//Attributes
	Game game;
	ObjectFactory factory = null;

	Random rand = new Random();
	
	public Playing(Game newGame, Handler handler) {
		game = newGame;
		gameStart(handler);
	}

	@Override
	public void gameMenu() {
		System.out.println("Menu");
		game.setGameState(game.menu);
	}

	@Override
	public void gameStart(Handler handler) {
		factory = new ObjectsFactory();
		
		//using the factory to add 
		for(int i = 0; i < 6; i++){
			
			handler.addObj((GameObject)factory.produceEnemy(rand.nextInt(Game.WIDTH-32), rand.nextInt((Game.HEIGHT-32)/2), ID.Enermy, handler));
		}
		handler.addObj((GameObject)factory.produceSnake(Game.WIDTH-30, Game.HEIGHT-30, ID.Snake, handler));
		handler.addObj((GameObject)factory.producePlayer((Game.WIDTH-50)/2,(Game.HEIGHT-50), ID.Player, handler));
		handler.addObj((GameObject)factory.produceIce((Game.WIDTH-10)/2,(Game.HEIGHT-10), ID.Ice, handler));
		
		}
	
	@Override
	public void gamePause() {
		gameMenu();
		game.setGameState(game.paused);
	}
}
