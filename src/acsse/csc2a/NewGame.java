/**
 * 
 */
package acsse.csc2a;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import acsse.csc2a.ui.Game;



/**
 * @author Mr T Ncube
 *
 */
public class NewGame extends JFrame{
	
/**
 * This Class allows the user to start a new Game
 * There are 4 buttons Start Game, Help About and Exit
 * Start game allows the user to start the game
 * Help allows the use to know what to do in the game and see game controls
 * About tells the user what the game is about and other additional information
 * 
 */
	public NewGame(){
		//Frame title
		setTitle("Monkey Village Menu");
		setSize(600,600);
		
		//Panel for Buttons
		JPanel panel = new JPanel();
		
		//Game Buttons
		JButton btnStart = new JButton("Start Game");
		JButton btnHelp = new JButton("Help");
		JButton btnAbout = new JButton("About");
		JButton btnQuit = new JButton("Exit");
		
		//Button listener that allows the user to start the game
		btnStart.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				new Game();
			}
		});
		
		//Button listener that allows the user to view game controls and how to play the game
		btnHelp.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("To move the player use keys w = up, a = left, s = down, d = right!");
				System.out.println("To control the banana use keyboard key up, left, down, right!");

			}
		});
		
		//Buttom listener that allows the user to access informatiom about the game
		btnAbout.addActionListener(new ActionListener()
		{

			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.out.println("Monkey Village is a game about monkeys and invaders in the Village!");
			}
		});
		
		//Button listener that allows the user to quit the game
		btnQuit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		
		//Adding all buttons to the panel
		panel.add(btnStart);
		panel.add(btnHelp);
		panel.add(btnAbout);
		panel.add(btnQuit);
		
		
		//adding panel buttons to the frame
		this.add(panel, BorderLayout.SOUTH);
		
		//Setting up the Frame details
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
	
}
