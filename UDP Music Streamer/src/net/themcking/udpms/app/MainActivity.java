package net.themcking.udpms.app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jsfml.system.Time;

import net.themcking.udpms.app.components.TimeBar;
import net.themcking.udpms.app.components.LevelMeter;
import net.themcking.udpms.util.FontManager;
import net.themcking.udpms.app.components.button.*;

public class MainActivity implements ListSelectionListener, ActionListener {
	private ListModel<String> listmodel_folder;
	private ListModel<String> listmodel_track;
	private Time time;
	private JPanel main;
	private JPanel panel1[];
	private JPanel panel2[];
	private JPanel panel3;
	private JPanel panel4;
	private JPanel panel5[];
	private JPanel panel6[];
	private JPanel panel7[];
	private JList<?> jlist_folder;
	private JList<?> jlist_track;
	private JTextField textfield_folder;
	private JTextField textfield_track;
	private PlayButton button_play;
	private PauseButton button_pause;
	private StopButton button_stop;
	//private PrevButton button_prev;
	//private NextButton button_next;
	private RewindButton button_rewind;
	private ForwardButton button_forward;

	@SuppressWarnings({ "unchecked", "rawtypes", "static-access" })
	public MainActivity(JFrame window) {
		FontManager.init();
		
		//Panels
		main = new JPanel();
		main.setLayout(null);
		main.setBounds(0, 0, window.getSize().width, window.getSize().height);
		
		panel1 = new JPanel[2];
		panel1[0] = new JPanel();
		panel1[0].setLayout(null);
		panel1[0].setBounds(16,16,290,30);
		panel1[0].setBackground(new Color(52,52,52));
		panel1[1] = new JPanel();
		panel1[1].setLayout(null);
		panel1[1].setBounds(16,46,290,455);
		panel1[1].setBackground(new Color(45,45,45));
		
		panel2 = new JPanel[2];
		panel2[0] = new JPanel();
		panel2[0].setLayout(null);
		panel2[0].setBounds(316,16,550,30);
		panel2[0].setBackground(new Color(52,52,52));
		panel2[1] = new JPanel();
		panel2[1].setLayout(null);
		panel2[1].setBounds(316,46,550,455);
		panel2[1].setBackground(new Color(45,45,45));
		
		panel3 = new JPanel();
		panel3.setLayout(null);
		panel3.setBounds(16,510,1060,100);
		panel3.setBackground(new Color(45,45,45));
		
		panel4 = new JPanel();
		panel4.setLayout(null);
		panel4.setBounds(((panel3.getBounds().width / 2) - 356 / 2), 45, 360, 44);
		panel4.setBackground(new Color(43, 43, 43));
		panel4.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		
		panel5 = new JPanel[2];
		panel5[0] = new JPanel();
		panel5[0].setLayout(null);
		panel5[0].setBounds(876,16,200,30);
		panel5[0].setBackground(new Color(52,52,52));
		panel5[1] = new JPanel();
		panel5[1].setLayout(null);
		panel5[1].setBounds(876,46,200,120);
		panel5[1].setBackground(new Color(45,45,45));
		
		panel6 = new JPanel[2];
		panel6[0] = new JPanel();
		panel6[0].setLayout(null);
		panel6[0].setBounds(876,176,95,30);
		panel6[0].setBackground(new Color(52,52,52));
		panel6[1] = new JPanel();
		panel6[1].setLayout(null);
		panel6[1].setBounds(876,205,95,296);
		panel6[1].setBackground(new Color(45,45,45));
		
		panel7 = new JPanel[2];
		panel7[0] = new JPanel();
		panel7[0].setLayout(null);
		panel7[0].setBounds(981,176,95,30);
		panel7[0].setBackground(new Color(52,52,52));
		panel7[1] = new JPanel();
		panel7[1].setLayout(null);
		panel7[1].setBounds(981,205,95,296);
		panel7[1].setBackground(new Color(45,45,45));
		
		//Labels
		JLabel title_panel1 = new JLabel("Folder",JLabel.CENTER);
		title_panel1.setFont(FontManager.Arial.deriveFont(24.0f));
		title_panel1.setForeground(new Color(185,185,185));
		title_panel1.setBounds(0,0,290,30);
		
		JLabel title_panel2 = new JLabel("Track",JLabel.CENTER);
		title_panel2.setFont(FontManager.Arial.deriveFont(24.0f));
		title_panel2.setForeground(new Color(185,185,185));
		title_panel2.setBounds(0,0,550,30);
		
		JLabel title_panel5 = new JLabel("Connection",JLabel.CENTER);
		title_panel5.setFont(FontManager.Arial.deriveFont(24.0f));
		title_panel5.setForeground(new Color(185,185,185));
		title_panel5.setBounds(0,0,200,30);
		
		JLabel title_panel6 = new JLabel("Level",JLabel.CENTER);
		title_panel6.setFont(FontManager.Arial.deriveFont(22.0f));
		title_panel6.setForeground(new Color(185,185,185));
		title_panel6.setBounds(0,0,95,30);
		
		JLabel title_panel7 = new JLabel("Volume",JLabel.CENTER);
		title_panel7.setFont(FontManager.Arial.deriveFont(22.0f));
		title_panel7.setForeground(new Color(185,185,185));
		title_panel7.setBounds(0,0,95,30);
		
		//Selection Lists
		String s[] = {"A","B","C"};
		jlist_folder = new JList(s);
		jlist_folder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlist_folder.setVisibleRowCount(5);
		jlist_folder.setLayoutOrientation(JList.VERTICAL_WRAP);
		jlist_folder.setBackground(new Color(40,40,40));
		jlist_folder.setBorder(BorderFactory.createEmptyBorder());
		jlist_folder.setFixedCellWidth(256);
		jlist_folder.addListSelectionListener(this);
		
		jlist_track = new JList(s);
		jlist_track.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jlist_track.setVisibleRowCount(5);
		jlist_track.setLayoutOrientation(JList.VERTICAL_WRAP);
		jlist_track.setBackground(new Color(40,40,40));
		jlist_track.setBorder(BorderFactory.createEmptyBorder());
		jlist_track.setFixedCellWidth(516);
		jlist_track.addListSelectionListener(this);
		
		//Scroll Panes
		JScrollPane scrollpane1 = new JScrollPane(jlist_folder);
		scrollpane1.setBounds(16,16,258,393);
		scrollpane1.setPreferredSize(new Dimension(258,393));
		
		JScrollPane scrollpane2 = new JScrollPane(jlist_track);
		scrollpane2.setBounds(16,16,518,393);
		scrollpane2.setPreferredSize(new Dimension(518,393));
		
		//Output Textfields
		textfield_folder = new JTextField();
		textfield_folder.setEditable(false);
		textfield_folder.setBounds(16, 417, 258, 28);
		textfield_folder.setBackground(new Color(40,40,40));
		textfield_folder.setFont(FontManager.ArialBold.deriveFont(16.0f));
		
		textfield_track = new JTextField();
		textfield_track.setEditable(false);
		textfield_track.setBounds(16, 417, 518, 28);
		textfield_track.setBackground(new Color(40,40,40));
		textfield_track.setFont(FontManager.ArialBold.deriveFont(16.0f));

		//Timebar
		TimeBar timebar = new TimeBar();
		timebar.setBounds(0,10,1060,40);
		timebar.setMaxTime(time.getSeconds(600));
		timebar.setCurrentTime(time.getSeconds(150));
		
		//Level Meter
		LevelMeter lv = new LevelMeter();
		lv.setValue(10);
		lv.setBounds(0, 0, panel6[1].getBounds().width, panel6[1].getBounds().height);
		panel6[1].add(lv);
		
		main.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				System.out.println("Mouse clicked");
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Mouse pressed");
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				System.out.println("Mouse released");
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				System.out.println("Mouse entered");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				System.out.println("Mouse exited");
			}
			
		});
		
		//Control Buttons
		//button_prev = new MuteButton();
		//button_prev.setBounds((panel4.getBounds().width / 2) - (44 / 2) - 150, 7, 44, 30);
		//button_prev.addActionListener(this);
		
		button_rewind = new RewindButton();
		button_rewind.setBounds((panel4.getBounds().width / 2) - (44 / 2) - 100, 7, 44, 30);
		button_rewind.addActionListener(this);
		
		button_pause = new PauseButton();
		button_pause.setBounds((panel4.getBounds().width / 2) - (44 / 2) - 50, 7, 44, 30);
		button_pause.addActionListener(this);
		
		button_play = new PlayButton();
		button_play.setBounds((panel4.getBounds().width / 2) - (44 / 2), 7, 44, 30);
		button_play.addActionListener(this);
		
		button_stop = new StopButton();
		button_stop.setBounds((panel4.getBounds().width / 2) - (44 / 2) + 50, 7, 44, 30);
		button_stop.addActionListener(this);
		
		button_forward = new ForwardButton();
		button_forward.setBounds((panel4.getBounds().width / 2) - (44 / 2) + 100, 7, 44, 30);
		button_forward.addActionListener(this);
		
		//button_next = new LoopButton();
		//button_next.setBounds((panel4.getBounds().width / 2) - (44 / 2) + 150, 7, 44, 30);
		//button_next.addActionListener(this);
		
		//Add components to panels
		panel1[0].add(title_panel1);
		panel1[1].add(scrollpane1);
		panel1[1].add(textfield_folder);
		panel2[0].add(title_panel2);
		panel2[1].add(scrollpane2);
		panel2[1].add(textfield_track);
		panel5[0].add(title_panel5);
		panel6[0].add(title_panel6);
		panel7[0].add(title_panel7);
		panel3.add(timebar);
		panel4.add(button_play);
		panel4.add(button_pause);
		panel4.add(button_stop);
		//panel4.add(button_prev);
		//panel4.add(button_next);
		panel4.add(button_rewind);
		panel4.add(button_forward);
		panel3.add(panel4);
		main.add(panel1[0]);
		main.add(panel1[1]);
		main.add(panel2[0]);
		main.add(panel2[1]);
		main.add(panel5[0]);
		main.add(panel5[1]);
		main.add(panel6[0]);
		main.add(panel6[1]);
		main.add(panel7[0]);
		main.add(panel7[1]);
		main.add(panel3);
	}
	
	public JComponent content() {
		return main;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == jlist_folder) {
			textfield_folder.setText(" ".concat((String)jlist_folder.getSelectedValue()));
		}
		if(e.getSource() == jlist_track) {
			textfield_track.setText(" ".concat((String)jlist_track.getSelectedValue()));
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button_pause) {
			button_play.setState(PlayButton.INACTIVE);
			button_play.setFocusable(true);
			button_pause.setState(PauseButton.ACTIVE);
			button_pause.setFocusable(false);
		}
		if(e.getSource() == button_play) {
			button_play.setState(PlayButton.ACTIVE);
			button_play.setFocusable(false);
			button_pause.setState(PauseButton.INACTIVE);
			button_pause.setFocusable(true);
		}
		if(e.getSource() == button_stop) {
			button_play.setState(PlayButton.INACTIVE);
			button_play.setFocusable(true);
			button_pause.setState(PauseButton.INACTIVE);
			button_pause.setFocusable(true);
		}
	}

}

