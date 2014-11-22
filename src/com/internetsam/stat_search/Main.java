package com.internetsam.stat_search;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.SpinnerNumberModel;
import javax.swing.JTextPane;
import javax.swing.JToolBar;

public class Main extends JFrame {
	
	AlertHandler alert = new AlertHandler();

	public JPanel contentPane;
	public JTextField nameField;
	public JProgressBar scanProgress;
	public JButton btnStartScan;
	public JTextPane infoPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		
		setTitle("OC.TC Stat Search");
		setForeground(Color.GRAY);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 848, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnStartScan = new JButton("Start Scan");
		btnStartScan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(nameField.getText().trim().toLowerCase().contains(" ") || nameField.getText().trim().toLowerCase().length() > 16) {
					
					alert.error("Invalid name");
				}
				else if(scanProgress.isIndeterminate() != true){
					scanProgress.setIndeterminate(true);
					alert.info("Starting scan");
				}
				else {
					alert.warning("Scan already started!");
				}
			}
		});
		btnStartScan.setBounds(10, 532, 247, 23);
		contentPane.add(btnStartScan);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				System.exit(0);
			}
		});
		btnExit.setBounds(733, 532, 89, 23);
		contentPane.add(btnExit);
		
		nameField = new JTextField();
		nameField.setBounds(10, 501, 247, 20);
		contentPane.add(nameField);
		nameField.setColumns(10);
		
		JLabel lblEnterYourName = new JLabel("Enter your name here");
		lblEnterYourName.setBounds(10, 476, 247, 14);
		contentPane.add(lblEnterYourName);
		
		JComboBox statType = new JComboBox();
		statType.setModel(new DefaultComboBoxModel(new String[] {"Kills", "Deaths", "KD", "KK", "Monuments", "Wools", "Cores", "Playtime"}));
		statType.setSelectedIndex(0);
		
		statType.setToolTipText("Select the stat type to scan");
		statType.setBounds(10, 64, 107, 20);
		contentPane.add(statType);
		
		JLabel lblStatType = new JLabel("Stat Type");
		lblStatType.setBounds(10, 38, 107, 14);
		contentPane.add(lblStatType);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Day", "Week", "Ever"}));
		comboBox.setSelectedIndex(0);
		comboBox.setBounds(10, 122, 107, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"All", "Project Ares", "Blitz", "Ghost Squadron"}));
		comboBox_1.setSelectedIndex(0);
		comboBox_1.setBounds(10, 180, 107, 20);
		contentPane.add(comboBox_1);
		
		JLabel lblTimeFrame = new JLabel("Time Frame");
		lblTimeFrame.setBounds(10, 96, 107, 14);
		contentPane.add(lblTimeFrame);
		
		JLabel lblGamemode = new JLabel("Gamemode");
		lblGamemode.setBounds(10, 154, 107, 14);
		contentPane.add(lblGamemode);
		
		scanProgress = new JProgressBar();
		scanProgress.setForeground(Color.GREEN);
		scanProgress.setBounds(267, 532, 456, 23);
		contentPane.add(scanProgress);
		
		JSpinner maxPages = new JSpinner();
		maxPages.setToolTipText("Select the max number of pages it can scan, 0 for unlimited");
		maxPages.setModel(new SpinnerNumberModel(new Integer(1), new Integer(0), null, new Integer(1)));
		maxPages.setBounds(10, 240, 61, 20);
		contentPane.add(maxPages);
		
		JLabel lblMaxPages = new JLabel("Max Pages");
		lblMaxPages.setBounds(10, 212, 105, 16);
		contentPane.add(lblMaxPages);
		
		infoPane = new JTextPane();
		infoPane.setBounds(269, 12, 551, 508);
		contentPane.add(infoPane);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setFloatable(false);
		toolBar.setBounds(10, 0, 247, 20);
		contentPane.add(toolBar);
		
		JButton btnSettings = new JButton("Settings");
		btnSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		toolBar.add(btnSettings);
	}
}
