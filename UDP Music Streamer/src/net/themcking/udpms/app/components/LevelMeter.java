package net.themcking.udpms.app.components;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import javax.swing.JButton;
import javax.swing.JComponent;

@SuppressWarnings("serial")
public class LevelMeter extends JComponent {
	private int value;
	
	public LevelMeter() {
	}
	
	public LevelMeter(int value) {
		this.value = value;
		this.setLayout(null);
	}
	
	public void setValue(int value) {
		this.value = value;
	}
	
	public int getValue() {
		return this.value;
	}
	
	
	public void paint(Graphics g) {
		int width = this.getBounds().width;
		int height = this.getBounds().height;
		
		g.setColor(new Color(40, 40, 40));
		g.fill3DRect(12,39,width - (11*2)-1,247,false);
		g.setColor(new Color(45,45,45));
		for(int i = 0; i < 20; i++) {
			g.fillRect(16, height - (24 + (i * 12)), width - (16*2), 8);
		}
		
		super.paint(g);
	}
}