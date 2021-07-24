package net.themcking.udpms.app;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.awt.Color;

import javax.swing.*;

import net.themcking.udpms.util.FontManager;

public class CustomDialogs {
	private static JDialog dialog;
	
	private static void createDialog(int width, int height, String title) {
		dialog = null;
		dialog = new JDialog();
		dialog.setMinimumSize(new Dimension(width, height));
		dialog.setSize(new Dimension(width, height));
		dialog.setResizable(false);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setTitle(title);
		dialog.setLayout(null);
		dialog.setVisible(true);
		dialog.setLocation((net.themcking.udpms.Udpms.window.getSize().width/2)-(width/2) + net.themcking.udpms.Udpms.window.getLocation().x,(net.themcking.udpms.Udpms.window.getSize().height/2)-(height/2) + net.themcking.udpms.Udpms.window.getLocation().y);
		FontManager.init();
	}
	
	public static void showExceptionDialog(Exception e) {
		net.themcking.udpms.Udpms.window.setVisible(false);
		createDialog(550,400, "Unexpected error");
		
		JLabel title = new JLabel("An unexpected error occoured and the application has crashed",JLabel.CENTER);
		title.setBounds(30,10,490,40);
		title.setForeground(new Color(180, 50, 51));
		title.setFont(FontManager.ArialBold.deriveFont(16.0f));
		dialog.add(title);	
		
		JTextArea output = new JTextArea();
		output.setFont(FontManager.SourceCodePro.deriveFont(10.0f));
		output.setEditable(false);
		output.setBounds(30,60,490,250);
		output.setBackground(new Color(50,50,50));
		output.setForeground(new Color(250,200,0));
		dialog.add(output);
		
		JButton button1 = new JButton("Save to file");
		button1.setFont(FontManager.Arial.deriveFont(22.0f));
		button1.setBounds(30,320,240,40);
		dialog.add(button1);
		
		JButton button2 = new JButton("Close");
		button2.setFont(FontManager.Arial.deriveFont(22.0f));
		button2.setBounds(280,320,240,40);
		dialog.add(button2);
		
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		output.append(sw.toString());
		
		button2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(-1);
			}
		});
	}
}
																	