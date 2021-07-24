package net.themcking.udpms.util.thread;

import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.JFrame;

import org.jsfml.system.Vector2i;

import net.themcking.udpms.util.IMouse;

public class MouseThread extends Thread implements MouseListener, MouseMotionListener {
	private IMouse imouse;
	private JComponent comp;
	private JFrame frame;
	private volatile int x_pos = 0;
	private volatile int y_pos = 0;
	private boolean isFocused = false;
	
	public MouseThread(JFrame frame, JComponent component) {
		this.comp = component;
		this.frame = frame;
	}
	
	public void run() {
		int x_old = 0;
		int y_old = 0;
		int x_new = 0;
		int y_new = 0;
		
		while(true) {
			x_new = frame.getBounds().x + comp.getBounds().x + MouseInfo.getPointerInfo().getLocation().x;
			y_new = frame.getBounds().y + comp.getBounds().y + MouseInfo.getPointerInfo().getLocation().y;
			if(x_new != x_old || y_new != y_old) {
				x_pos = x_new;
				y_pos = y_new;
				x_old = x_new;
				y_old = y_new;
			}
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(isFocused) imouse.mouseClicked(x_pos, y_pos);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if(isFocused) imouse.mousePressed(x_pos, y_pos);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(isFocused) imouse.mouseReleased(x_pos, y_pos);
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		isFocused = true;
		imouse.mouseEntered(x_pos, y_pos);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		isFocused = false;
		imouse.mouseExited(x_pos, y_pos);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		if(isFocused) imouse.mouseMoved(x_pos, y_pos);
	}
	
	@Override
	public void mouseDragged(MouseEvent e) {}
}
