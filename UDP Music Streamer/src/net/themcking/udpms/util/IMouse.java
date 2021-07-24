package net.themcking.udpms.util;

import java.awt.PointerInfo;

public interface IMouse {
	public void mouseMoved(int mouse_x, int mouse_y);
	public void mousePressed(int mouse_x, int mouse_y);
	public void mouseReleased(int mouse_x, int mouse_y);
	public void mouseClicked(int mouse_x, int mouse_y);
	public void mouseExited(int mouse_x, int mouse_y);
	public void mouseEntered(int mouse_x, int mouse_y);
	
}