package com.FrontEnd;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import com.dao.ManageSessionRoomsDao;
import com.dao.SessionDetailsDao;
import com.models.Manage_SessionRooms;
import com.models.Session;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.ScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTabbedPane;

public class AddLocations extends JFrame {

	private JPanel contentPane;
	private JTable table;
	DefaultTableModel tableModel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLocations frame = new AddLocations();
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
	public AddLocations() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1372, 719);
		contentPane = new JPanel();
		contentPane.setForeground(Color.GREEN);
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Add Locations");
		lblNewLabel.setBackground(Color.GREEN);
		lblNewLabel.setBounds(464, 56, 293, 30);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		contentPane.add(lblNewLabel);
		
		table = new JTable();
		table.setBounds(179, 386, 303, -145);
		table.setForeground(Color.BLACK);
		table.setBackground(Color.BLACK);
		contentPane.add(table);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(189, 142, 990, 383);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Sessions", null, panel, null);
		panel.setLayout(null);
		
		tableModel = new DefaultTableModel() {
			public Class<?> getColumnClass(int column) {
			switch (column) {
			case 0:
			return Integer.class;
			case 1:
			return String.class;
			case 2:
			return String.class;
			case 3:
			return String.class;
			case 4:
			return String.class;
			case 5:
			return String.class;
			case 6:
			return String.class;
			case 7:
			return String.class;
			default:
			return String.class;
		
			}
			}
			};

			table = new JTable(tableModel);
			
			tableModel.addColumn("ID");
			tableModel.addColumn("Lecturer 1");
			tableModel.addColumn("Lecturer 2");
			tableModel.addColumn("Subject Code");
			tableModel.addColumn("Subject Name");
			tableModel.addColumn("Group ID");
			tableModel.addColumn("Tag");
			tableModel.addColumn("Room");



			ManageSessionRoomsDao manObject = new ManageSessionRoomsDao();
			ArrayList<Manage_SessionRooms> array = manObject.getSessions();

			SessionDetailsDao daoSession = new SessionDetailsDao();
			for(int i=0;i<array.size();i++) {

			tableModel.addRow(new Object[0]);
			Session object = daoSession.getSessionByID(array.get(i).getId());
			
			
			tableModel.setValueAt(array.get(i).getId(), i, 0);
			tableModel.setValueAt(object.getFirstLec(), i, 1);
			tableModel.setValueAt(object.getSecondLec(), i, 2);
			tableModel.setValueAt(object.getSubjectCode(), i, 3);
			tableModel.setValueAt(object.getSubject(), i, 4);
			tableModel.setValueAt(object.getMainGroup(), i, 5);
			tableModel.setValueAt(object.getTag(), i, 6);
			tableModel.setValueAt(array.get(i).getRoom(), i, 7);
			
			}

			JTableHeader header = table.getTableHeader();
			header.setBackground(new Color(102, 153, 255));
			
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(10,24,699,318);
			panel.add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_2, null);
	}
}
