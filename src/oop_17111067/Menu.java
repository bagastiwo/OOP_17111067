package oop_17111067;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;

public class Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
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
	public Menu() {
		setTitle("Menu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 250);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		mnFile.add(mntmExit);
		
		JMenu mnTools = new JMenu("Tools");
		menuBar.add(mnTools);
		
		JMenuItem mntmEntryData = new JMenuItem("Entry Data");
		mntmEntryData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuEntry me = new MenuEntry();
				me.setVisible(true);
			}
		});
		mnTools.add(mntmEntryData);
		
		JMenuItem mntmViewData = new JMenuItem("View Data");
		mntmViewData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuView mv = new MenuView();
				mv.setVisible(true);
				
			}
		});
		mnTools.add(mntmViewData);
		
		JMenu mnOther = new JMenu("Other");
		menuBar.add(mnOther);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Proyek OOP \n"
						+ "Muhammad Bagasjati Pratiwo \n"
						+ "17111067"
						);
			}
		});
		mnOther.add(mntmAbout);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea txtrSilahkanMenggunakanToolsbar = new JTextArea();
		txtrSilahkanMenggunakanToolsbar.setForeground(Color.BLACK);
		txtrSilahkanMenggunakanToolsbar.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtrSilahkanMenggunakanToolsbar.setEditable(false);
		txtrSilahkanMenggunakanToolsbar.setLineWrap(true);
		txtrSilahkanMenggunakanToolsbar.setText("   Silahkan akses toolbar diatas\r\n   untuk menggunakan program.");
		txtrSilahkanMenggunakanToolsbar.setBounds(10, 11, 414, 168);
		contentPane.add(txtrSilahkanMenggunakanToolsbar);
	}
}
