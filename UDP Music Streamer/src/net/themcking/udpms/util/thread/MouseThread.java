package net.themcking.udpms.util.thread;

import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComponent;

//import org.jsfml.system.Vector2i;

import net.themcking.udpms.util.IMouse;

public class MouseThread extends Thread implements MouseListener {
	private IMouse m;
	private volatile int x_pos = 0;
	private volatile int y_pos = 0;
	
	public MouseThread(JComponent c) {
	}
	
	public void run() {
		int x_old = 0, y_old = 0;
		int x_new = 0, y_new = 0;
		while(true) {
			x_new = MouseInfo.getPointerInfo().getLocation().x;
			y_new = MouseInfo.getPointerInfo().getLocation().y;
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
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
