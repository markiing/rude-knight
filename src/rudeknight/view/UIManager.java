package rudeknight.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.sql.Time;
import java.util.Date;

import javax.swing.JLabel;
import javax.swing.JPanel;

import rudeknight.game.GameEngine;
import rudeknight.game.InputManager;
import rudeknight.model.Player;

public class UIManager extends JPanel {
	
	private GameEngine engine;
	private Player player;
	private FPSViewer fpsViewer;
	private InputManager inputManager;
	
	public UIManager(GameEngine engine, int width, int height) {
		setPreferredSize(new Dimension(width, height));
		setMaximumSize(new Dimension(width, height));
		setMinimumSize(new Dimension(width, height));
		this.engine = engine;
		this.player = new Player();
		this.fpsViewer = new FPSViewer(this);
		setBackground(Color.BLACK);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g.create();
		player.draw(g2);
	}
	
	public void repaint(double delta) {
		super.repaint();
	}
	
	public void updateFPSViewer(double executions) {
		fpsViewer.update(executions);
	}

}
