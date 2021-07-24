package net.themcking.udpms.app.components.button;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ButtonModel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class PrevButton extends JButton {

	public PrevButton() {
		super.setContentAreaFilled(false);
		super.setLayout(null);
	}
	
	protected void paintComponent(Graphics g) {
		ButtonModel state = super.getModel();
		int w = super.getBounds().width;
		int h = super.getBounds().height;
		
		if(state.isPressed()) {
			g.setColor(new Color(25, 25, 25));
			g.fillRect(0, 0, w, h);
			super.paintComponent(g);
		} else {
			g.setColor(new Color(60, 60, 60));
			g.fillRect(0, 0, w, h);
			super.paintComponent(g);
		}
	}
	
	protected void paintBorder(Graphics g) {
		ButtonModel state = super.getModel();
		int w = super.getBounds().width;
		int h = super.getBounds().height;
		if(state.isPressed()) {
			g.setColor(new Color(0, 0, 0));
			g.drawRect(0, 0, w, h);
			super.paintComponent(g);
		} else {
			g.setColor(new Color(90, 90, 90));
			g.drawRect(0, 0, w, h);
			super.paintComponent(g);
		}
	}
}
