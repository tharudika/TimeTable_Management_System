package com.FrontEnd;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.dao.LocationDao;
import com.models.Location;
import com.util.DBUtill;

//import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import java.awt.FlowLayout;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;

public class ManageLocation extends JFrame implements MouseListener, ActionListener{

	private JPanel contentPane;
	private JTextField textField_BuidName;
	private JTextField textField_RName;
	private JTextField textField_Capctiy; 
	
	private JButton btnNewButton_Update;
	private JButton btnNewButton_Delete;
	private JButton btnNewButton_Clear;
	private JTable table;
	
	private JRadioButton rdbtnNewRadioButton_LecHall;
	private JRadioButton rdbtnNewRadioButton_Lab;
	
	private static ResultSet rs  = null;
	private DBUtill db;
	private LocationDao location;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageLocation frame = new ManageLocation();
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
	public ManageLocation() {
		
		db = new DBUtill();
		location = new LocationDao();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1174, 744);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField_BuidName = new JTextField();
		textField_BuidName.setBounds(251, 529, 221, 41);
		contentPane.add(textField_BuidName);
		textField_BuidName.setColumns(10);
		
		textField_RName = new JTextField();
		textField_RName.setEditable(false);
		textField_RName.setBounds(251, 632, 221, 40);
		contentPane.add(textField_RName);
		textField_RName.setColumns(10);
		
		textField_Capctiy = new JTextField();
		textField_Capctiy.setBounds(868, 632, 174, 40);
		contentPane.add(textField_Capctiy);
		textField_Capctiy.setColumns(10);
		
		rdbtnNewRadioButton_LecHall = new JRadioButton("LectuerHall");
		buttonGroup.add(rdbtnNewRadioButton_LecHall);
		rdbtnNewRadioButton_LecHall.setBounds(790, 529, 103, 21);
		contentPane.add(rdbtnNewRadioButton_LecHall);
		
		rdbtnNewRadioButton_Lab = new JRadioButton("Laboraltory");
		buttonGroup.add(rdbtnNewRadioButton_Lab);
		rdbtnNewRadioButton_Lab.setBounds(939, 529, 103, 21);
		contentPane.add(rdbtnNewRadioButton_Lab);
		
	    btnNewButton_Delete = new JButton("Delete ");
		btnNewButton_Delete.addActionListener(this);
		btnNewButton_Delete.setBackground(Color.YELLOW);
		btnNewButton_Delete.setFont(new Font("Sitka Heading", Font.PLAIN, 18));
		btnNewButton_Delete.setBounds(846, 192, 225, 41);
		contentPane.add(btnNewButton_Delete);
		
	    btnNewButton_Clear = new JButton("Clear");
		btnNewButton_Clear.setFont(new Font("Sitka Heading", Font.PLAIN, 18));
		btnNewButton_Clear.setBackground(Color.WHITE);
		btnNewButton_Clear.addActionListener(this);
		btnNewButton_Clear.setBounds(846, 318, 225, 41);
		contentPane.add(btnNewButton_Clear);
		
		btnNewButton_Update = new JButton("Update");
		btnNewButton_Update.addActionListener(this);
		btnNewButton_Update.setFont(new Font("Sitka Heading", Font.PLAIN, 18));
		btnNewButton_Update.setBackground(Color.CYAN);
		btnNewButton_Update.setBounds(846, 64, 225, 41);
		contentPane.add(btnNewButton_Update);
		
		JLabel lblNewLabel = new JLabel("Manage Location");
		lblNewLabel.setFont(new Font("Sitka Heading", Font.PLAIN, 25));
		lblNewLabel.setBounds(524, 21, 233, 41);
		contentPane.add(lblNewLabel);
		
		JLabel BName = new JLabel("Building Name");
		BName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		BName.setBounds(77, 527, 134, 18);
		contentPane.add(BName);
		
		JLabel RName = new JLabel("Room Name");
		RName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RName.setBounds(67, 637, 144, 13);
		contentPane.add(RName);
		
		JLabel RType = new JLabel("Room Type");
		RType.setFont(new Font("Tahoma", Font.PLAIN, 15));
		RType.setBounds(670, 518, 132, 27);
		contentPane.add(RType);
		
		JLabel Cacity = new JLabel("Capacity");
		Cacity.setFont(new Font("Tahoma", Font.PLAIN, 15));
		Cacity.setBounds(670, 647, 93, 26);
		contentPane.add(Cacity);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(51, 110, 541, 261);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.addMouseListener(this);
		
		refreshTableUpdate();
	}
	
	
	
	
	
		public void refreshTableUpdate() {
		
		DBUtill.getConnection();	
		rs = this.db.refreshAddLocationTable();
		//this.table.setModel(DbUtils.resultSetToTableModel(rs));
		
		textField_BuidName.setText(null);
		textField_RName.setText(null);
		textField_Capctiy.setText(null);
		buttonGroup.clearSelection();
		
	}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			if( e.getSource() == table ) {
				int row = table.getSelectedRow();
				String RoomName =  table.getValueAt(row, 2).toString();					
			
				Location loc = this.db.searchLocationByName(RoomName);	
											
				
				textField_BuidName.setText(loc.getBuildingNmae());
				textField_RName.setText(loc.getRoomName());
				textField_Capctiy.setText(Integer.toString(loc.getCapacity()));
				
				String type = loc.getRoomtype();
				
				
				/*rdbtnNewRadioButton_Lab.setActionCommand("lab");
				rdbtnNewRadioButton_LecHall.setActionCommand("LectuerHall");*/
				
				String s ="LectuerHall";
				
				if(type.startsWith("Lec")) {
					
					rdbtnNewRadioButton_LecHall.setSelected(true);
					
					
				}else {
					rdbtnNewRadioButton_Lab.setSelected(true);
				}
				
				/*if(type.equalsIgnoreCase(rbtn) ) {
					
					System.out.println("hi");
					rdbtnNewRadioButton_LecHall.setSelected(true);
				}else
					System.out.println("not run");
				Enumeration<AbstractButton> bg = buttonGroup.getElements();
				
				while(bg.hasMoreElements()) {
					
					JRadioButton jrd = (JRadioButton)bg.nextElement();
					
					if(type == jrd.getText()) {
										
						System.out.println(jrd.getText());
					}
					
				}*/
				
				//textField_RName.setText(Double.toString(lec.getRank()));
				
			
				
			}	
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			if( e.getSource() == btnNewButton_Update ) {
				

				String buildName = textField_BuidName.getText();
				String rName = textField_RName.getText();
				String capacity = textField_Capctiy.getText();
				String r_type = "";
				
				if( buildName.equals("")) {
					JOptionPane.showMessageDialog(this, "Building Name not valid", "Insert Error", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				else  if( rName.equals("")) {
					JOptionPane.showMessageDialog(this, "Room Name not valid", "Insert Error", JOptionPane.WARNING_MESSAGE);
					return ;
				}else if(!(rdbtnNewRadioButton_LecHall.isSelected() | rdbtnNewRadioButton_Lab.isSelected())) {
					JOptionPane.showMessageDialog(this, "Room Type not balid", "Insert Error", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				
				
				int capcity;
				
				try {
					capcity = Integer.parseInt(capacity);				
				}catch(Exception ex) {
					JOptionPane.showMessageDialog(this, "Capasity is not Valid, Please Check Again ", "Insert Error", JOptionPane.WARNING_MESSAGE);
					return;
				}
				
				
				Enumeration<AbstractButton> bg = buttonGroup.getElements();
				while(bg.hasMoreElements()) {
					
					JRadioButton jrd = (JRadioButton)bg.nextElement();
					
					if(jrd.isSelected()) {
						r_type = jrd.getText();				
						//jrd.setSelected(true);
					}
					
				}
				
				UpdateLocation( buildName, r_type ,rName, capcity );
				
				this.refreshTableUpdate();
				/*textField_BuidName.setText(null);
				textField_RName.setText(null);
				textField_Capctiy.setText(null);
				buttonGroup.clearSelection();*/
				
			}
			
			
			if(e.getSource() == btnNewButton_Delete) {
				String rName = textField_RName.getText();			
				DeleteLocation(rName);
							
				this.refreshTableUpdate();	
				
				
			}	
			
			if(e.getSource() == btnNewButton_Clear) {
				
				this.refreshTableUpdate();
			}
			
			
			//END
			
		}
	
	
		public void UpdateLocation( String buildName, String rtype, String rName, int capcity ){
			
			Location loc = null;
			loc = this.db.searchLocationByName(rName);
			
			loc.setBuildingNmae(buildName);
			loc.setRoomtype(rtype);
			loc.setCapacity(capcity);
			//Location l = new Location(buildName, rtype, rName, capcity);
			try {
				location.updateLocation(loc);
				showPlainMessageDialog("Successfuly Updated", "Update");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("gg");
				e.printStackTrace();
			}	
		}
		
		public void DeleteLocation( String roomName) {
			
			int confirm;
			
			confirm = showConfirmMessageDialog("Are you sure You want to delete Location details of room : " + roomName, "Confirm Required");
			
			if( confirm == 0 ) {
				try {
					location.deleteLocation(roomName);
					showMessageDialog("Successfully Location Details Deleted");		
				}catch(Exception e) {
					System.err.println("Exception :" +e.getMessage());
					e.printStackTrace();
									
				} 
			}
			
			
			
		}
		
		
		
	
		
		public void showWarningMessageDialog(String message, String title) {
			JOptionPane.showMessageDialog(getParent(), message, title, JOptionPane.WARNING_MESSAGE);;
		}
		
		public void showPlainMessageDialog(String message, String title) {
			JOptionPane.showMessageDialog(getParent(), message, title, JOptionPane.PLAIN_MESSAGE);
		}	
	
	
		public int showConfirmMessageDialog(String message, String title) {
			return JOptionPane.showConfirmDialog(getParent(), message, title, JOptionPane.YES_NO_OPTION);
		}
		
		public void showMessageDialog(String message) {
			JOptionPane.showMessageDialog(getParent(), message);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
