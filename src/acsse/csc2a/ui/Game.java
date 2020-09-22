package acsse.csc2a.ui;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JPanel;

import acsse.csc2a.GameState;
import acsse.csc2a.KeyInput;
import acsse.csc2a.Menu;
import acsse.csc2a.Window;
import acsse.csc2a.entities.GameBackground;
import acsse.csc2a.entities.GameObject;
import acsse.csc2a.entities.Handler;
import acsse.csc2a.state.Paused;
import acsse.csc2a.state.Playing;


/**
 * The Game class allows the Switching of the game states using the state Design Pattern
 * The Visitor Design pattern is used in order to paint the game Components within the Game Panel
 * A game thread is also created for the game
 * An array list is created to store game objects
 * There are constant attributes for the width and height that will be used for the Game Window
 * 
 */

/**
 * @author Mr T Ncube
 *
 */
public class Game extends JPanel implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Possible Game states
	public GameState playing;
	public GameState paused;
	public GameState menu;
	
	//Current game state
	GameState gameState = null;

	GameBackground background = new GameBackground();
	
	ArrayList<GameObject> objects = null;


	private boolean running = false;
	
	private Thread thread;
	
	private Handler handler;
	
	public static final int WIDTH = 640, HEIGHT = 480;
	
	public Game(){
		
		handler = new Handler();
		
		//Adding key listener for game controls
		this.addKeyListener(new KeyInput(handler));	
		
		//Creating new Game window
		new Window(WIDTH, HEIGHT, "Monkey Village", this);
	
		this.requestFocusInWindow(true);
		
		// Initial game state
		gameState = menu;
		
		//Executed depending on the state of the game
		if(gameState == playing){
			new Playing(this,handler);
		}else if(gameState == menu){
			 new Menu(this);
		}else if(gameState == paused){
			new Paused(this);
		}
		this.requestFocusInWindow(true);
	}
	
	//Setting the game state
	public void setGameState(GameState newGameState){
		
		gameState = newGameState;
		
	}
	
	public void gameMenu() {
		gameState.gameMenu();
	}

	public void gameStart() {
		gameState.gameStart(handler);
	}

	public void gamePause() {
		gameState.gamePause();
	}

	//Getters for game states
	public GameState getPlaying(){
		return playing;
	}
	public GameState getPaused(){
		return paused;
	}

	public GameState getMenu(){
		return menu;
	}

	//Start game thread
	public synchronized void start(){
		
		running  = true;
		thread = new Thread(this);
		thread.start();
	} 
	
	//Stopping game
	public synchronized void stop(){
		
		try{
			thread.join();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			running = false;
		}
	}
	
	//Running the game thread
	public void run() {
		
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(running){
			
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				delta--;
			}
			
			if(running){
				
				repaint();
				frames++;
				
				if(System.currentTimeMillis() - timer > 1000){
					timer += 1000;
					//System.out.println("FPS: " + frames);
					frames = 0;
				}
			}
			
		}
		stop();
	}

	private void tick(){
		handler.tick();
	}
	
	
	//Painting game Components to the game panel using the Visitor Design Pattern
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		handler.visitor.setGraphics(g);
		
		//painting the game background
		background.accept(handler.visitor);
		
		handler.render(g);
		
	}
}
