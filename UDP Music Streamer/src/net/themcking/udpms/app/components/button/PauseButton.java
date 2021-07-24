package net.themcking.udpms.app.components.button;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ButtonModel;
import javax.swing.JToggleButton;

@SuppressWarnings("serial")
public class PauseButton extends JToggleButton {
	public static final int ACTIVE = 1;
	public static final int INACTIVE = 0;
	
	private int b = 0;
	
	public PauseButton() {
		super.setContentAreaFilled(false);
		super.setLayout(null);
	}
	
	public void setState(int state) {
		b = state;
		this.repaint();
	}
	
	protected void paintComponent(Graphics g) {
		ButtonModel state = super.getModel();
		int w = super.getBounds().width;
		int h = super.getBounds().height;
		
		if(state.isPressed() || b == 1) {
			g.setColor(new Color(25, 25, 25));
			g.fillRect(0, 0, w, h);
			g.setColor(new Color(36, 179, 50));
			g.fillRect(13,4,7,22);
			g.fillRect(24,4,7,22);
			super.paintComponent(g);
		}
		if(!state.isPressed() && b == 0) {
			g.setColor(new Color(60, 60, 60));
			g.fillRect(0, 0, w, h);
			g.setColor(new Color(150, 150, 150));
			g.fillRect(13,4,7,22);
			g.fillRect(24,4,7,22);
			super.paintComponent(g);
		}
	}
	
	protected void paintBorder(Graphics g) {
		ButtonModel state = super.getModel();
		int w = super.getBounds().width;
		int h = super.getBounds().height;
		if(state.isPressed() || b == 1) {
			g.setColor(new Color(0, 0, 0));
			g.drawRect(0, 0, w, h);
			super.paintComponent(g);
		}
		if(!state.isPressed() && b == 0) {
			g.setColor(new Color(90, 90, 90));
			g.drawRect(0, 0, w, h);
			super.paintComponent(g);
		}
	}
}
