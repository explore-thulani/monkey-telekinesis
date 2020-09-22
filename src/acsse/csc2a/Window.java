package acsse.csc2a;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import acsse.csc2a.ui.Game;

public class Window extends JFrame{
	
	public Window(int width, int height, String title, Game game)
	{
		//Setting up window preferences
		game.setPreferredSize(new Dimension(width, height));
		game.setMaximumSize(new Dimension(width, height));
		game.setMinimumSize(new Dimension(width, height));
		//Sets window title
		this.setTitle(title);
		
		//Creating new panel for buttons
		JPanel pnl = new JPanel();
		
		//Creating Game Play Buttons
		JButton btnPause = new JButton("Pause Game");
		JButton btnQuit = new JButton("Quit Game");
		
		//Adding Game play buttons to the panel
		pnl.add(btnPause);
		pnl.add(btnQuit);
		
		//Adding action listeners for game play buttons
		btnPause.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				
			}
		});
		
		btnQuit.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);

			}
		});
		
		//Adding the game and button panels to the frame
		this.add(pnl, BorderLayout.SOUTH);
		this.add(game, BorderLayout.CENTER);
		
		//Setting up Game Frame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setVisible(true);
		this.pack();
		this.setLocationRelativeTo(null);
		
		//Starting the game
		game.start();
	}
}
