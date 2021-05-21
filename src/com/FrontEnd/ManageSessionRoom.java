package com.FrontEnd;



import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dao.LocationDao;
import com.dao.ManageSessionRoomsDao;
import com.dao.SessionDetailsDao;
import com.models.Location;
import com.models.Manage_SessionRooms;
import com.models.Session;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class ManageSessionRoom extends JFrame {

	private JPanel contentPane;
	private JTextField textbox;
	private JComboBox session, room;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageSessionRoom frame = new ManageSessionRoom();
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
	public ManageSessionRoom() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1204, 696);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Manage Session Room");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(208, 44, 295, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_SSession = new JLabel("Select Session");
		lblNewLabel_SSession.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_SSession.setBounds(168, 231, 241, 21);
		contentPane.add(lblNewLabel_SSession);
		
		JLabel lblNewLabel_SRoom = new JLabel("Select Room");
		lblNewLabel_SRoom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_SRoom.setBounds(168, 318, 124, 21);
		contentPane.add(lblNewLabel_SRoom);
		
		JLabel lblNewLabel_SSection = new JLabel("Selected Section");
		lblNewLabel_SSection.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_SSection.setBounds(162, 416, 144, 13);
		contentPane.add(lblNewLabel_SSection);
		
		
		
		JButton btnNewButton_1 = new JButton("Clear");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setForeground(Color.YELLOW);
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton_1.setBounds(745, 509, 117, 39);
		contentPane.add(btnNewButton_1);
		
		textbox = new JTextField();
		textbox.setBounds(407, 394, 289, 72);
		contentPane.add(textbox);
		textbox.setColumns(10);
		
		
		SessionDetailsDao daoObject = new SessionDetailsDao();
		ArrayList<Session> sessionList = daoObject.getSessions();
		
		ArrayList<Integer> idList = new ArrayList<>();
		
		for(int i=0;i<sessionList.size();i++) {
			idList.add(sessionList.get(i).getId());
		}
		
		session = new JComboBox(idList.toArray());
		session.setForeground(Color.BLACK);
		session.setBackground(Color.WHITE);
		session.setBounds(363, 234, 333, 21);
		contentPane.add(session);
		
		LocationDao dao = new LocationDao();
		ArrayList<Location> loc = dao.getlocation();
		ArrayList<String>rooms = new ArrayList<String>();
		
		for(int i=0;i<loc.size();i++) {
			rooms.add(loc.get(i).getRoomName());
		}
		
		//System.out.println(rooms);
		
		room = new JComboBox(rooms.toArray());
		room.setBounds(363, 321, 333, 21);
		contentPane.add(room);
		
		JButton add = new JButton("Submit");
		add.setForeground(Color.BLUE);
		add.setFont(new Font("Tahoma", Font.PLAIN, 25));
		add.setBackground(Color.CYAN);
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedID = Integer.parseInt(session.getSelectedItem().toString());
				String SelectedRoom = room.getSelectedItem().toString();
				
				ManageSessionRoomsDao object = new ManageSessionRoomsDao();
				Manage_SessionRooms sessionRoom = new Manage_SessionRooms();
				sessionRoom.setSession(selectedID);
				sessionRoom.setRoom(SelectedRoom);
				object.insertRooms(sessionRoom);
				resetData();
			}
		});
		add.setBounds(425, 509, 144, 39);
		contentPane.add(add);
		
	}
	
	public void resetData() {
		session.setSelectedIndex(0);
		room.setSelectedIndex(0);
		textbox.setText(null);
	}
}
