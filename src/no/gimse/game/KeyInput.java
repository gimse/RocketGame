package no.gimse.game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	private Handler handler;
	
	
	public KeyInput(Handler handler){
		this.handler=handler;
	}
	
	public void keyPressed(KeyEvent e){
		
		int key =e.getKeyCode();
		
		if (key==KeyEvent.VK_RIGHT){
			for (int i=0;i<handler.size();i++){
				GameObject midObj = handler.get(i);
				if (midObj.getID()==ID.Rocket1 && midObj instanceof Rocket1){
					Rocket1 midRocket = (Rocket1)midObj;
					Rocket1booster[] rocketsboters = midRocket.getRockesboosters();
					for (int j=0;j<rocketsboters.length;j++){
						if (rocketsboters[j].getId()==IDBooster.H){
							rocketsboters[j].turnOn();
						}
					}
				}
			}
		}
		if (key==KeyEvent.VK_LEFT){
			for (int i=0;i<handler.size();i++){
				GameObject midObj = handler.get(i);
				if (midObj.getID()==ID.Rocket1 && midObj instanceof Rocket1){
					Rocket1 midRocket = (Rocket1)midObj;
					Rocket1booster[] rocketsboters = midRocket.getRockesboosters();
					for (int j=0;j<rocketsboters.length;j++){
						if (rocketsboters[j].getId()==IDBooster.V){
							rocketsboters[j].turnOn();
						}
					}
				}
			}
		}
	}
	public void keyReleased(KeyEvent e){
		int key =e.getKeyCode();
		if (key==KeyEvent.VK_RIGHT){
			for (int i=0;i<handler.size();i++){
				GameObject midObj = handler.get(i);
				
				if (midObj.getID()==ID.Rocket1 && midObj instanceof Rocket1){
					Rocket1 midRocket = (Rocket1)midObj;
					Rocket1booster[] rocketsboters = midRocket.getRockesboosters();
					for (int j=0;j<rocketsboters.length;j++){
						if (rocketsboters[j].getId()==IDBooster.H){
							rocketsboters[j].turnOff();
						}
					}
				}
			}
		}
		if (key==KeyEvent.VK_LEFT){
			for (int i=0;i<handler.size();i++){
				GameObject midObj = handler.get(i);
				if (midObj.getID()==ID.Rocket1 && midObj instanceof Rocket1){
					Rocket1 midRocket = (Rocket1)midObj;
					Rocket1booster[] rocketsboters = midRocket.getRockesboosters();
					for (int j=0;j<rocketsboters.length;j++){
						if (rocketsboters[j].getId()==IDBooster.V){
							rocketsboters[j].turnOff();
						}
					}
				}
			}
		}
	}
	
}
