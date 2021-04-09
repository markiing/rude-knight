package rudeknight.game;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JLabel;

import rudeknight.model.Player;
import rudeknight.view.UIManager;

public class GameEngine implements Runnable {
	
	private UIManager uiManager;
	private Thread thread;
	private boolean isRunning;
	
	public GameEngine() {
		uiManager = new UIManager(this, Definitions.CAMERA_WIDTH, Definitions.CAMERA_HEIGHT);
		init();
	}
	
	private JFrame MountFrame() {
		JFrame frame = new JFrame(Definitions.GAME_WINDOW_TITLE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(Definitions.CAMERA_WIDTH, Definitions.CAMERA_HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.add(uiManager);
		return frame;
	}
	
	 private synchronized void init() {
		MountFrame();
		this.thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	
	
	public static void main(String[] args) {
		new GameEngine();
	}

	@Override
	public void run() {
		long lastTime = System.nanoTime();
        double ns = 1000000000 / Definitions.MAX_FPS;
        double delta = 0;
        long timer = System.currentTimeMillis();
        while (isRunning && !thread.isInterrupted()) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
            	gameLoop(delta);
            	delta--;
            }
        	uiManager.repaint(delta);
        }
	}
	
	
	public void gameLoop(double delta) {
		//RENDER FPS TIME
		uiManager.updateFPSViewer(delta * Definitions.MAX_FPS);
	}
	
}
