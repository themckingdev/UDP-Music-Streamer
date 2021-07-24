package net.themcking.udpms.util;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import net.themcking.udpms.Udpms;

public class MenuEvent implements ActionListener {
	
	public MenuEvent() {
		for(int i = 0; i < Udpms.jmenuitem_file.length; i++) {
			 Udpms.jmenuitem_file[i].addActionListener(this);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() ==  Udpms.jmenuitem_file[0]) {
			JFileChooser jfc = new JFileChooser();
			File file;
			if(jfc.showOpenDialog( Udpms.window) == JFileChooser.APPROVE_OPTION) {
				file = jfc.getSelectedFile();
				
				String s1 = file.getAbsolutePath();
				String s2[] = s1.split("\\u005c");
				//s2[s2.length-1].indexOf(".")
				String type = s2[s2.length-1].substring(s2[s2.length-1].indexOf(".") + 1);
				
				if(type == FileType.OGG || type == FileType.WAV || type == FileType.MP3) {
					
				} else {
					JOptionPane.showMessageDialog(Udpms.window, "Failed to open file!\nThe file type \"" + type + "\" is not supported.", "", JOptionPane.WARNING_MESSAGE);
				}
			}
		}
	}
	
}
