package rudeknight.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import rudeknight.game.Definitions;
import rudeknight.game.InputManager;

public class Player extends GameObject {
	
	private InputManager inputManager;
	private int x = Definitions.HORIZONTAL_CENTER;
	private int y = Definitions.VERTICAL_CENTER;
	
	public Player() {
	}
	
	void moveLeft() {
		x--;
	}
	
	void moveRight() {
		x++;
	}
	
	void moveUp() {
		y++;
	}
	
	void moveDown() {
		y--;
	}
	
	
	@Override
	public void draw(Graphics2D g) {
		// TODO Auto-generated method stub
		 g.setColor(Color.RED);
	     g.drawOval(x, y, 10, 10);
	}
}
