package no.gimse.game;

import java.awt.Color;
import java.awt.Graphics;

public class Player extends GameObject {

	public Player(int x, int y, ID id) {
		super(x, y, id);

		
	}

	@Override
	public void tick() {
		x+=velX;
		y+=velY;
		

	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		//g.fillRect(x, y, 10, 10);
	}
	
}
