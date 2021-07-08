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

public class ViewWilker extends JFrame {

	private JPanel contentPane;
	private static final long serialVersionUID = 1L;
	public Object[][] isiTable = null;
	private JTable tableWilker;
	JScrollPane scrollTable = new JScrollPane();
	String[] header = {"ID Wilayah Kerja", "Wilayah Kerja"};


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewWilker frame = new ViewWilker();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	public ViewWilker() {
		setTitle("View Wilayah Kerja");
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 450, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label = new JLabel("Form View Gaji");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(159, 23, 96, 14);
		contentPane.add(label);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 65, 363, 214);
		contentPane.add(scrollPane);
		
		tableWilker = new JTable();
		scrollPane.setViewportView(tableWilker);
		
		Koneksi k = new Koneksi();
		Connection mysql = k.getConnection();
		try {
			Statement state = mysql.createStatement();
			String sql = "Select * from wilayahkerja";
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
				isiTable[x][0]=res.getString("id_wilayahKerja");
				isiTable[x][1]=res.getString("nama_wilayahKerja");
				x++;
			}
			tableWilker.setModel(new DefaultTableModel(isiTable, header));
			getContentPane().add(scrollTable, BorderLayout.NORTH);
			state.close();
			res.close();
		}
		
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null, ex.getMessage());
		}
	}
}
