package net.themcking.udpms.app.components;

import javax.swing.JComponent;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.PointerInfo;

import org.jsfml.system.Time;

import net.themcking.udpms.util.FontManager;

@SuppressWarnings("serial")
public class TimeBar extends JComponent {
	private Time t_max;
	private Time t_set;
	private boolean hover = false;
	
	public TimeBar() {
		FontManager.init();
		this.setLayout(null);
	}
	
	public TimeBar(Time max, Time current) {
		t_max = max;
		t_set = current;
		
		this.setPreferredSize(new Dimension(this.getBounds().width,this.getBounds().height));
		
		FontManager.init();
		this.setLayout(null);
		this.repaint();
	}
	
	public void setMaxTime(Time max) {
		t_max = max;
		repaint();
	}
	
	public Time getMaxTime() {
		return t_max;
	}
	
	public void setCurrentTime(Time current) {
		t_set = current;
		this.repaint();
	}
	
	public Time getCurrentTime() {
		return t_set;
	}
	
	public void paint(Graphics g) {
		int w_max = (this.getBounds().width) - (24 * 2);
		int w_set = (int) ((((t_set.asMilliseconds() * 100) / t_max.asMilliseconds()) * w_max) / 100);
		super.paint(g);
		
		g.setFont(FontManager.Arial.deriveFont(14.0f));
		g.setColor(new Color(0,0,0,80));
		g.fillRect(3+24,3+10,w_max,5);
		if(hover) g.fillOval(3+w_set+20,3+4,16,16);
		
		g.setColor(new Color(113,113,113));
		g.fillRect(24,10,w_max,5);
		g.setColor(new Color(172, 16, 25));
		g.fillRect(24,10,w_set,5);
		if(hover) g.fillOval(w_set+20,4,16,16);
	}
	
}

class MouseThread extends Thread {
	private PointerInfo mouse;
	
	@Override
	public void run() {
		try {
			super.sleep(2);
		} catch (InterruptedException e) {
		}
	}
}
