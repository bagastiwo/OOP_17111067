package oop_17111067;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class EntryJabatan extends JFrame {

	private JPanel contentPane;
	private JTextField textField_IdJabatan;
	private JTextField textField_Jabatan;
	private JTextField textField_IDGaji;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntryJabatan frame = new EntryJabatan();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	void clear() {
		textField_IdJabatan.setText("");
		textField_Jabatan.setText("");
		textField_IDGaji.setText("");
	}

	/**
	 * Create the frame.
	 */
	public EntryJabatan() {
		setTitle("Entry Jabatan");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFormEntryJabatan = new JLabel("Form Entry Jabatan");
		lblFormEntryJabatan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFormEntryJabatan.setBounds(153, 11, 133, 14);
		contentPane.add(lblFormEntryJabatan);
		
		JLabel lblIdJabatan = new JLabel("ID Jabatan");
		lblIdJabatan.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdJabatan.setBounds(49, 60, 65, 14);
		contentPane.add(lblIdJabatan);
		
		JLabel lblJabatan = new JLabel("Jabatan");
		lblJabatan.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblJabatan.setBounds(49, 108, 46, 14);
		contentPane.add(lblJabatan);
		
		JLabel label = new JLabel(":");
		label.setFont(new Font("Tahoma", Font.BOLD, 11));
		label.setBounds(124, 60, 16, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel(":");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(124, 108, 16, 14);
		contentPane.add(label_1);
		
		textField_IdJabatan = new JTextField();
		textField_IdJabatan.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_IdJabatan.setBounds(150, 57, 65, 20);
		contentPane.add(textField_IdJabatan);
		textField_IdJabatan.setColumns(10);
		
		textField_Jabatan = new JTextField();
		textField_Jabatan.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_Jabatan.setBounds(150, 105, 133, 20);
		contentPane.add(textField_Jabatan);
		textField_Jabatan.setColumns(10);
		
		JButton btnSimpan = new JButton("Simpan");
		btnSimpan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Koneksi k = new Koneksi();
				Connection mysql = k.getConnection();
				try {
					Statement stat = mysql.createStatement();
					String sql = "INSERT INTO jabatan VALUES ('"
							+ textField_IdJabatan.getText()+"','"
							+ textField_Jabatan.getText()+"','"
							+ textField_IDGaji.getText()+"');";
					int i = stat.executeUpdate(sql);
					if (i==1) {
						JOptionPane.showMessageDialog(null, "Entry Data Berhasil");
					}
					clear();
				}
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		
		btnSimpan.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSimpan.setBounds(49, 193, 89, 23);
		contentPane.add(btnSimpan);
		
		JButton btnClear = new JButton("Clear Form");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClear.setBounds(150, 193, 110, 23);
		contentPane.add(btnClear);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Koneksi k = new Koneksi();
				Connection mysql = k.getConnection();
				try {
					Statement state = mysql.createStatement();
					String sql = "UPDATE jabatan SET nama_Jabatan='"
							+ textField_Jabatan.getText()+"', id_gaji='"
							+ textField_IDGaji.getText()+"' WHERE id_jabatan='"
							+ textField_IdJabatan.getText()+"';";
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
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.setBounds(270, 193, 89, 23);
		contentPane.add(btnUpdate);
		
		JButton btnCari = new JButton("Cari");
		btnCari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Koneksi k = new Koneksi();
				Connection mysql = k.getConnection();
				try {
					Statement state = mysql.createStatement();
					String sql = "SELECT * FROM jabatan WHERE id_jabatan LIKE '%"
							+ textField_IdJabatan.getText()+"%';";
					ResultSet res = state.executeQuery(sql);
					if (res.next()) {
						textField_IdJabatan.setText(res.getString(1));
						textField_Jabatan.setText(res.getString(2));
						textField_IDGaji.setText(res.getString(3));
					} else {
						JOptionPane.showMessageDialog(null, "Data Tidak Ditemukan");
					}
				}
				
				catch (Exception ex) {
					JOptionPane.showMessageDialog(null, ex.getMessage());
				}
			}
		});
		btnCari.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCari.setBounds(270, 56, 65, 23);
		contentPane.add(btnCari);
		
		JLabel lblIdGaji = new JLabel("ID Gaji");
		lblIdGaji.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdGaji.setBounds(49, 150, 65, 14);
		contentPane.add(lblIdGaji);
		
		JLabel label_3 = new JLabel(":");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(124, 150, 16, 14);
		contentPane.add(label_3);
		
		textField_IDGaji = new JTextField();
		textField_IDGaji.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_IDGaji.setColumns(10);
		textField_IDGaji.setBounds(150, 147, 65, 20);
		contentPane.add(textField_IDGaji);
	}
}
