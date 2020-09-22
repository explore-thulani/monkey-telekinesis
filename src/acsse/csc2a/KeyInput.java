package acsse.csc2a;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import acsse.csc2a.entities.GameObject;
import acsse.csc2a.entities.Handler;
import acsse.csc2a.entities.ID;
import acsse.csc2a.entities.Ice;
import acsse.csc2a.entities.Player;



/**
 * Key KeyInput is for game controls for the Player and the Weapon
 */

/**
 * 
 * @author Mr T Ncube
 *
 */
public class KeyInput extends KeyAdapter{
	
	Handler handler;
	
	public KeyInput(Handler handler)
	{
		this.handler = handler;
	}

	//Key pressed for game control
	@Override
	public void keyPressed(KeyEvent e)
	{
		int key = e.getKeyCode();
		
		for(int i = 0; i < handler.obj.size(); i++)
		{
			GameObject tempObj = handler.obj.get(i);
			
			//Controls for the Player which is a Monkey
			if(tempObj.getId() == ID.Player )
			{
				if(key == KeyEvent.VK_W){tempObj.setVelY(-Player.getSPEED());}
				if(key == KeyEvent.VK_S){tempObj.setVelY(Player.getSPEED());}
				if(key == KeyEvent.VK_A){tempObj.setVelX(-Player.getSPEED());}
				if(key == KeyEvent.VK_D){tempObj.setVelX(Player.getSPEED());}
			}
			
			//Controls for the weapon which is a banana
			if(tempObj.getId() == ID.Ice)
			{
				
				if(key == KeyEvent.VK_UP){tempObj.setVelY(-Ice.getSPEED());}
				if(key == KeyEvent.VK_DOWN){tempObj.setVelY(Ice.getSPEED());}
				if(key == KeyEvent.VK_LEFT){tempObj.setVelX(-Ice.getSPEED());}
				if(key == KeyEvent.VK_RIGHT){tempObj.setVelX(Ice.getSPEED());}
				if(key == KeyEvent.VK_SPACE){tempObj.setVelY(-Ice.getSPEED());}
			}
		}
		//Exit Game Key
		if(key == KeyEvent.VK_ESCAPE){
			System.exit(0);
		}
	}
	
	@Override
	public void keyReleased(KeyEvent e)
	{
		int key = e.getKeyCode();
		

		/*for(int i = 0; i < handler.obj.size(); i++)
		{
			GameObject tempObj = handler.obj.get(i);
			if(tempObj.getId() == ID.Player)
			{
			tempObj.setVelY(0);		
			tempObj.setVelX(0);}
		}*/
	}
}
