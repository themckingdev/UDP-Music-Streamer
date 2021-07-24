package net.themcking.udpms;


import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;
import javax.swing.*;

import com.jtattoo.plaf.hifi.HiFiLookAndFeel;

import net.themcking.udpms.app.MainActivity;
import net.themcking.udpms.util.MenuEvent;
import net.themcking.udpms.app.CustomDialogs;

@SuppressWarnings("serial")
public class Udpms extends JFrame implements ActionListener {
	public static JMenuItem[] jmenuitem_file;
	public static JFrame window;
	
	public Udpms() {
		// Initalize Window
		window = new JFrame();
		window.setTitle("UDP Music Streamer");
		window.setResizable(false);
		window.setMinimumSize(new Dimension(1100,675));
		window.setSize(new Dimension(1100,675));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
		/*
		try {
			int i[] = new int[5];
			int i2 = i[10];
		} catch(Exception e) {
			CustomDialogs.showExceptionDialog(e);
		}
		*/
		
		// Initalize MenuBar
		JMenuBar menubar = new JMenuBar();
		JMenu jmenu_file = new JMenu();
		jmenu_file = new JMenu("File");
		jmenuitem_file = new JMenuItem[5];
		jmenuitem_file[0] = new JMenuItem("Open single File");
		jmenuitem_file[1] = new JMenuItem("Open Playlist");
		jmenuitem_file[2] = new JMenuItem("New Playlist");
		jmenuitem_file[3] = new JMenuItem("Close");
		jmenuitem_file[4] = new JMenuItem("Exit");
		menubar.add(jmenu_file);
		window.setJMenuBar(menubar);
		for(int i = 0 ;i < 5; i++) {
			jmenu_file.add(jmenuitem_file[i]);
			jmenu_file.addActionListener(this);
		}
		new MenuEvent();
		
		//Display MainActivity
		MainActivity mainActivity = new MainActivity(window);
		window.add(mainActivity.content());
	}
	
	public static void main(String[] args) {
		Properties props = new Properties();
		props.put("centerWindowTitle", "on");
		props.put("backgroundPattern", "off");
		props.put("backgroundColor","30 30 30");
		props.put("controlColor", "0 0 0");
		HiFiLookAndFeel.setCurrentTheme(props);
		try {
			UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException| UnsupportedLookAndFeelException e) {
			e.printStackTrace();
		}
		
		new Udpms();
		

	}
	@Override
	public void actionPerformed(ActionEvent e) {
	}

}
