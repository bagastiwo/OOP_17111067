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

public class EntryPegawai extends JFrame {

	private JPanel contentPane;
	private JTextField textField_IDPegawai;
	private JTextField textField_NamaPeg;
	private JTextField textField_Alamat;
	private JTextField textField_NoHp;
	private JTextField textField_IDJabatan;
	private JTextField textField_Wilker;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EntryPegawai frame = new EntryPegawai();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	void clear() {
		textField_Alamat.setText("");
		textField_IDJabatan.setText("");
		textField_IDPegawai.setText("");
		textField_NamaPeg.setText("");
		textField_NoHp.setText("");
		textField_Wilker.setText("");
	}

	/**
	 * Create the frame.
	 */
	public EntryPegawai() {
		setTitle("Entry Pegawai");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 400);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFormEntryPegawai = new JLabel("Form Entry Pegawai");
		lblFormEntryPegawai.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFormEntryPegawai.setBounds(167, 36, 133, 14);
		contentPane.add(lblFormEntryPegawai);
		
		JButton button = new JButton("Cari");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Koneksi k = new Koneksi();
				Connection mysql = k.getConnection();
				try {
					Statement state = mysql.createStatement();
					String sql = "SELECT * FROM pegawai WHERE id_pegawai LIKE '%"
							+ textField_IDPegawai.getText()+"%';";
					
					ResultSet res = state.executeQuery(sql);
					if (res.next()) {
						textField_IDPegawai.setText(res.getString(1));
						textField_NamaPeg.setText(res.getString(2));
						textField_Alamat.setText(res.getString(3));
						textField_NoHp.setText(res.getString(4));
						textField_IDJabatan.setText(res.getString(5));
						textField_Wilker.setText(res.getString(6));
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
		button.setBounds(284, 81, 65, 23);
		contentPane.add(button);
		
		textField_IDPegawai = new JTextField();
		textField_IDPegawai.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_IDPegawai.setColumns(10);
		textField_IDPegawai.setBounds(164, 82, 65, 20);
		contentPane.add(textField_IDPegawai);
		
		JLabel label_1 = new JLabel(":");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_1.setBounds(138, 85, 16, 14);
		contentPane.add(label_1);
		
		JLabel lblIdPegawai = new JLabel("ID Pegawai");
		lblIdPegawai.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdPegawai.setBounds(45, 85, 65, 14);
		contentPane.add(lblIdPegawai);
		
		JLabel Nama = new JLabel("Nama");
		Nama.setFont(new Font("Tahoma", Font.BOLD, 11));
		Nama.setBounds(45, 121, 46, 14);
		contentPane.add(Nama);
		
		JLabel label_4 = new JLabel(":");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_4.setBounds(138, 121, 16, 14);
		contentPane.add(label_4);
		
		textField_NamaPeg = new JTextField();
		textField_NamaPeg.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_NamaPeg.setColumns(10);
		textField_NamaPeg.setBounds(164, 118, 133, 20);
		contentPane.add(textField_NamaPeg);
		
		JButton button_1 = new JButton("Simpan");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Koneksi k = new Koneksi();
				Connection mysql = k.getConnection();
				try {
					Statement stat = mysql.createStatement();
					String sql = "INSERT INTO pegawai VALUES ('"
							+ textField_IDPegawai.getText()+"','"
							+ textField_NamaPeg.getText()+"','"
							+ textField_Alamat.getText()+"','"
							+ textField_NoHp.getText()+"','"
							+ textField_IDJabatan.getText()+"','"
							+ textField_Wilker.getText()+"');";
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
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setBounds(65, 316, 89, 23);
		contentPane.add(button_1);
		
		JButton button_2 = new JButton("Clear Form");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		button_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_2.setBounds(166, 316, 110, 23);
		contentPane.add(button_2);
		
		JButton button_3 = new JButton("Update");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Koneksi k = new Koneksi();
				Connection mysql = k.getConnection();
				try {
					Statement state = mysql.createStatement();
					String sql = "UPDATE pegawai SET nama='"
							+ textField_NamaPeg.getText()+"', alamat='"
							+ textField_Alamat.getText()+"', noHp='"
							+ textField_NoHp.getText()+"', id_Jabatan='"
							+ textField_IDJabatan.getText()+"', id_wilayahKerja='"
							+ textField_Wilker.getText()+"' WHERE id_pegawai='"
							+ textField_IDPegawai.getText()+"';";
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
		button_3.setBounds(286, 316, 89, 23);
		contentPane.add(button_3);
		
		JLabel lblAlamat = new JLabel("Alamat");
		lblAlamat.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblAlamat.setBounds(45, 154, 46, 14);
		contentPane.add(lblAlamat);
		
		JLabel label_2 = new JLabel(":");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_2.setBounds(138, 154, 16, 14);
		contentPane.add(label_2);
		
		textField_Alamat = new JTextField();
		textField_Alamat.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_Alamat.setColumns(10);
		textField_Alamat.setBounds(164, 150, 133, 20);
		contentPane.add(textField_Alamat);
		
		JLabel lblNoHp = new JLabel("No HP");
		lblNoHp.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNoHp.setBounds(45, 186, 46, 14);
		contentPane.add(lblNoHp);
		
		JLabel label_3 = new JLabel(":");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_3.setBounds(138, 186, 16, 14);
		contentPane.add(label_3);
		
		textField_NoHp = new JTextField();
		textField_NoHp.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_NoHp.setColumns(10);
		textField_NoHp.setBounds(164, 183, 133, 20);
		contentPane.add(textField_NoHp);
		
		JLabel lblIdJabatan = new JLabel("ID Jabatan");
		lblIdJabatan.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdJabatan.setBounds(45, 219, 65, 14);
		contentPane.add(lblIdJabatan);
		
		JLabel label_5 = new JLabel(":");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_5.setBounds(138, 219, 16, 14);
		contentPane.add(label_5);
		
		textField_IDJabatan = new JTextField();
		textField_IDJabatan.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_IDJabatan.setColumns(10);
		textField_IDJabatan.setBounds(164, 216, 65, 20);
		contentPane.add(textField_IDJabatan);
		
		JLabel lblIdWilKerja = new JLabel("ID Wil. Kerja");
		lblIdWilKerja.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblIdWilKerja.setBounds(45, 250, 82, 14);
		contentPane.add(lblIdWilKerja);
		
		JLabel label_6 = new JLabel(":");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_6.setBounds(137, 250, 16, 14);
		contentPane.add(label_6);
		
		textField_Wilker = new JTextField();
		textField_Wilker.setFont(new Font("Tahoma", Font.BOLD, 11));
		textField_Wilker.setColumns(10);
		textField_Wilker.setBounds(163, 247, 65, 20);
		contentPane.add(textField_Wilker);
	}

}
