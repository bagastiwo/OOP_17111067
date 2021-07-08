package oop_17111067;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class EntryWilKer extends JFrame {

	private JPanel contentPane;
	private JTextField textField_IDWilker;
	private JTextField textField_Wilkernya;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntryWilKer frame = new EntryWilKer();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	void clear() {
		textField_IDWilker.setText("");
		textField_Wilkernya.setText("");
	}

	/**
	 * Create the frame.
	 */
	public EntryWilKer() {
		setTitle("Entry Wilayah Kerja");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFormEntryWilayah = new JLabel("Form Entry Wilayah Kerja");
		lblFormEntryWilayah.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFormEntryWilayah.setBounds(133, 33, 162, 14);
		contentPane.add(lblFormEntryWilayah);
		
		JButton button = new JButton("Cari");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Koneksi k = new Koneksi();
				Connection mysql = k.getConnection();
				try {
					Statement state = mysql.createStatement();
					String sql = "SELECT * FROM wilayahkerja WHERE id_wilayahKerja LIKE '%"
							+ textField_IDWilker.getText()+"%';";
					ResultSet res = state.executeQuery(sql);
					if (res.next()) {
						textField_IDWilker.setText(res.getString(1));
						textField_Wilkernya.setText(res.getString(2));
					} else {
						JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
					}
				}
				
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}				
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 11));
		button.setBounds(296, 79, 65, 23);
		contentPane.add(button);
		
		textField_IDWilker = new JTextField();
		textField_IDWilker.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_IDWilker.setColumns(10);
		textField_IDWilker.setBounds(176, 80, 65, 20);
		contentPane.add(textField_IDWilker);
		
		JLabel label_1 = new JLabel(":");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(150, 83, 16, 14);
		contentPane.add(label_1);
		
		JLabel lblIdWilayahKerja = new JLabel("ID Wilayah Kerja");
		lblIdWilayahKerja.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdWilayahKerja.setBounds(37, 83, 103, 14);
		contentPane.add(lblIdWilayahKerja);
		
		JLabel lblWilayahKerja = new JLabel("Wilayah Kerja");
		lblWilayahKerja.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblWilayahKerja.setBounds(37, 134, 84, 14);
		contentPane.add(lblWilayahKerja);
		
		JLabel label_4 = new JLabel(":");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(150, 134, 16, 14);
		contentPane.add(label_4);
		
		textField_Wilkernya = new JTextField();
		textField_Wilkernya.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_Wilkernya.setColumns(10);
		textField_Wilkernya.setBounds(176, 131, 133, 20);
		contentPane.add(textField_Wilkernya);
		
		JButton button_1 = new JButton("Simpan");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Koneksi k = new Koneksi();
				Connection mysql = k.getConnection();
				try {
					Statement stat = mysql.createStatement();
					String sql = "INSERT INTO wilayahkerja VALUES ('"
							+ textField_IDWilker.getText()+ "','"
							+ textField_Wilkernya.getText()+"');";
					
					int i = stat.executeUpdate(sql);
					if (i==1) {
						JOptionPane.showMessageDialog(null, "Entry Data Berhasil");
					}
					clear();
				}
				
				catch (Exception ex) {
					JOptionPane.showInputDialog(null, ex.getMessage());
				}
			}
		});
		
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setBounds(61, 192, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Clear Form");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_2.setBounds(162, 192, 110, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Update");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Koneksi k = new Koneksi();
				Connection mysql = k.getConnection();
				try {
					Statement state = mysql.createStatement();
					String sql = "UPDATE wilayahkerja SET nama_wilayahKerja='"
							+ textField_Wilkernya.getText()+"' WHERE id_wilayahKerja='"
							+ textField_IDWilker.getText()+"';";
					int i = state.executeUpdate(sql);
					if (i==1) {
						JOptionPane.showMessageDialog(null, "Data Berhasil di Update");
					}
					clear();
				}
				
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}				
			}
		});
		button_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_3.setBounds(282, 192, 89, 23);
		contentPane.add(button_3);
	}

}
