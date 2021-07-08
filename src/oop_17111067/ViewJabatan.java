package oop_17111067;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class ViewJabatan extends JFrame {

	private static final long serialVersionUID = 1L;
	public Object[][] isiTable = null;
	private JPanel contentPane;
	private JTable tableJabatan;
	JScrollPane scrollTable = new JScrollPane();
	String[] header = {"ID Jabatan", "Jabatan", "ID Gaji"};

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewJabatan frame = new ViewJabatan();
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
	public ViewJabatan() {
		setTitle("View Jabatan");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblFormViewJabatan = new JLabel("Form View Jabatan");
		lblFormViewJabatan.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblFormViewJabatan.setBounds(159, 35, 124, 14);
		contentPane.add(lblFormViewJabatan);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 65, 363, 214);
		contentPane.add(scrollPane);
		
		tableJabatan = new JTable();
		scrollPane.setViewportView(tableJabatan);
		
		Koneksi k = new Koneksi();
		Connection mysql = k.getConnection();
		
		try {
			Statement state = mysql.createStatement();
			String sql = "Select * from jabatan";
			ResultSet res = state.executeQuery(sql);
			ResultSetMetaData meta = res.getMetaData();
			int kolom = meta.getColumnCount();
			int baris = 0;
			while(res.next()) {
				baris = res.getRow();
			}
			isiTable = new Object[baris][kolom];
			int x = 0;
			res.beforeFirst();
			while(res.next()) {
				isiTable[x][0]=res.getString("id_jabatan");
				isiTable[x][1]=res.getString("nama_Jabatan");
				isiTable[x][2]=res.getString("id_gaji");
				x++;
			}
			tableJabatan.setModel(new DefaultTableModel(isiTable, header));
			getContentPane().add(scrollTable, BorderLayout.NORTH);
			state.close();
			res.close();
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
}
