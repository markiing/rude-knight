package rudeknight.view;

import java.awt.Color;
import java.text.DecimalFormat;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class FPSViewer  {
	private JLabel frameRate;
	private DecimalFormat formatter = new DecimalFormat("#.##");

	public FPSViewer(JPanel parent) {
		// TODO Auto-generated constructor stub
		this.frameRate = new JLabel("0");
		this.frameRate.setForeground(Color.white);
		parent.add(frameRate);
	}
	
	public void update(double executions) {
		// TODO Auto-generated method stub
		frameRate.setText(formatter.format(executions) + "FPS");
	}

}
