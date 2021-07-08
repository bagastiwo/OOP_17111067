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

public class EntryGaji extends JFrame {

	private JPanel contentPane;
	private JTextField text_IDGaji;
	private JTextField text_NominalGaji;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntryGaji frame = new EntryGaji();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	void clear() {
		text_IDGaji.setText("");
		text_NominalGaji.setText("");
	}

	/**
	 * Create the frame.
	 */
	public EntryGaji() {
		setTitle("Entry Gaji");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFormEntryGaji = new JLabel("Form Entry Gaji");
		lblFormEntryGaji.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFormEntryGaji.setBounds(162, 30, 110, 14);
		contentPane.add(lblFormEntryGaji);
		
		JButton button = new JButton("Cari");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Koneksi k = new Koneksi();
				Connection mysql = k.getConnection();
				try {
					Statement state = mysql.createStatement();
					String sql = "SELECT * FROM gaji WHERE id_gaji LIKE '%"
							+ text_IDGaji.getText()+"%';";
					ResultSet res = state.executeQuery(sql);
					if (res.next()) {
						text_IDGaji.setText(res.getString(1));
						text_NominalGaji.setText(res.getString(2));
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
		button.setBounds(279, 75, 65, 23);
		contentPane.add(button);
		
		text_IDGaji = new JTextField();
		text_IDGaji.setFont(new Font("Tahoma", Font.BOLD, 11));
		text_IDGaji.setColumns(10);
		text_IDGaji.setBounds(159, 76, 65, 20);
		contentPane.add(text_IDGaji);
		
		JLabel label_1 = new JLabel(":");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(133, 79, 16, 14);
		contentPane.add(label_1);
		
		JLabel lblIdGaji = new JLabel("ID Gaji");
		lblIdGaji.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdGaji.setBounds(44, 79, 65, 14);
		contentPane.add(lblIdGaji);
		
		JLabel lblNominalGaji = new JLabel("Nominal Gaji");
		lblNominalGaji.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNominalGaji.setBounds(44, 130, 79, 14);
		contentPane.add(lblNominalGaji);
		
		JLabel label_4 = new JLabel(":");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(133, 130, 16, 14);
		contentPane.add(label_4);
		
		text_NominalGaji = new JTextField();
		text_NominalGaji.setFont(new Font("Tahoma", Font.BOLD, 11));
		text_NominalGaji.setColumns(10);
		text_NominalGaji.setBounds(159, 127, 133, 20);
		contentPane.add(text_NominalGaji);
		
		JButton button_1 = new JButton("Simpan");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Koneksi k = new Koneksi();
				Connection mysql = k.getConnection();
				try {
					Statement stat = mysql.createStatement();
					String sql = "INSERT INTO gaji VALUES ('"
							+ text_IDGaji.getText()+"','"
							+ text_NominalGaji.getText()+"');";
					int i = stat.executeUpdate(sql);
					if (i==1) {
						JOptionPane.showMessageDialog(null, "Entry Data Berhasil!");
					}
					clear();
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setBounds(58, 188, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Clear Form");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_2.setBounds(159, 188, 110, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Update");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Koneksi k = new Koneksi();
				Connection mysql = k.getConnection();
				try {
					Statement state = mysql.createStatement();
					String sql = "UPDATE gaji SET nominal_gaji='"
							+ text_NominalGaji.getText()+"' WHERE id_gaji='"
							+ text_IDGaji.getText()+"';";
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
		button_3.setBounds(279, 188, 89, 23);
		contentPane.add(button_3);
	}

}
