package oop_17111067;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class MenuEntry extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuEntry frame = new MenuEntry();
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
	
	public MenuEntry() {
		setTitle("Menu Entry");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		JButton btnEntryPegawai = new JButton("Entry Pegawai");
		btnEntryPegawai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntryPegawai ep = new EntryPegawai();
				ep.setVisible(true);
			}
		});
		btnEntryPegawai.setBounds(133, 35, 160, 23);
		contentPane.add(btnEntryPegawai);
		
		JButton btnEntryGaji = new JButton("Entry Gaji");
		btnEntryGaji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntryGaji eg = new EntryGaji();
				eg.setVisible(true);
			}
		});
		btnEntryGaji.setBounds(133, 69, 160, 23);
		contentPane.add(btnEntryGaji);
		
		JButton btnEntryWilayahKerja = new JButton("Entry Wilayah Kerja");
		btnEntryWilayahKerja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntryWilKer ew = new EntryWilKer();
				ew.setVisible(true);
			}
		});
		btnEntryWilayahKerja.setBounds(133, 105, 160, 23);
		contentPane.add(btnEntryWilayahKerja);
		
		JButton btnEntryJabatan = new JButton("Entry Jabatan");
		btnEntryJabatan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EntryJabatan ej = new EntryJabatan();
				ej.setVisible(true);
			}
		});
		btnEntryJabatan.setBounds(133, 139, 160, 23);
		contentPane.add(btnEntryJabatan);
	}
}
