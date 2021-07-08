package oop_17111067;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuView frame = new MenuView();
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
	
	public MenuView() {
		setTitle("Menu View");
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
		mntmEntryData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MenuEntry me = new MenuEntry();
				me.setVisible(true);
			}
		});
		
		mnTools.add(mntmEntryData);
		
		JMenuItem mntmViewData = new JMenuItem("View Data");
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
		
		JButton btnViewPegawai = new JButton("View Pegawai");
		btnViewPegawai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewPegawai vp = new ViewPegawai();
				vp.setVisible(true);
			}
		});
		btnViewPegawai.setBounds(132, 35, 160, 23);
		contentPane.add(btnViewPegawai);
		
		JButton btnViewGaji = new JButton("View Gaji");
		btnViewGaji.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewGaji vg = new ViewGaji();
				vg.setVisible(true);
			}
		});
		btnViewGaji.setBounds(132, 69, 160, 23);
		contentPane.add(btnViewGaji);
		
		JButton btnViewWilayahKerja = new JButton("View Wilayah Kerja");
		btnViewWilayahKerja.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewWilker vw = new ViewWilker();
				vw.setVisible(true);
			}
		});
		btnViewWilayahKerja.setBounds(132, 103, 160, 23);
		contentPane.add(btnViewWilayahKerja);
		
		JButton btnViewJabatan = new JButton("View Jabatan");
		btnViewJabatan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ViewJabatan vj = new ViewJabatan();
				vj.setVisible(true);
			}
		});
		btnViewJabatan.setBounds(132, 137, 160, 23);
		contentPane.add(btnViewJabatan);
	}

}
