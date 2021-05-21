package com.FrontEnd;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dao.LocationDao;
import com.models.Location;

import javax.swing.JButton;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Enumeration;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JLabel;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;

public class AddLocation extends JFrame implements ActionListener {

	
	private JPanel contentPane;
	private JTextField textField_BuidName;
	private JTextField textField_RoomName;
	private JTextField textField_Capcity;
	
	private JButton btnNewButton_Clear;
	private JButton btnNewButton_Save;
	private JRadioButton rdbtnNewRadioButton_R_TypeLecHall;
	private JRadioButton rdbtnNewRadioButtonR_Type_Lab;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	
	
	private LocationDao location;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddLocation frame = new AddLocation();
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
	public AddLocation() {
		
		location = new LocationDao();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1366, 768);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ADD LOCATION");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblNewLabel.setBounds(417, 50, 208, 44);
		lblNewLabel.setForeground(Color.BLACK);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Add Rooms building wise");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(94, 185, 191, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel BName = new JLabel("Building Name");
		BName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		BName.setBounds(94, 282, 166, 22);
		contentPane.add(BName);
		
		JLabel RName = new JLabel("Room Name");
		RName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		RName.setBounds(94, 357, 149, 27);
		contentPane.add(RName);
		
		JLabel RType = new JLabel("Room Type");
		RType.setFont(new Font("Tahoma", Font.PLAIN, 18));
		RType.setBounds(94, 465, 146, 36);
		contentPane.add(RType);
		
		JLabel Cacity = new JLabel("Capacity");
		Cacity.setFont(new Font("Tahoma", Font.PLAIN, 18));
		Cacity.setBounds(94, 588, 149, 36);
		contentPane.add(Cacity);
		
		textField_BuidName = new JTextField();
		textField_BuidName.setBounds(337, 270, 209, 36);
		contentPane.add(textField_BuidName);
		textField_BuidName.setColumns(10);
		
		textField_RoomName = new JTextField();
		textField_RoomName.setBounds(337, 357, 209, 36);
		contentPane.add(textField_RoomName);
		textField_RoomName.setColumns(10);
		
		textField_Capcity = new JTextField();
		textField_Capcity.setBounds(332, 583, 214, 36);
		contentPane.add(textField_Capcity);
		textField_Capcity.setColumns(10);
		
	    rdbtnNewRadioButton_R_TypeLecHall = new JRadioButton("LectureHall");
	    buttonGroup.add(rdbtnNewRadioButton_R_TypeLecHall);
		rdbtnNewRadioButton_R_TypeLecHall.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButton_R_TypeLecHall.setBounds(354, 474, 166, 21);
		contentPane.add(rdbtnNewRadioButton_R_TypeLecHall);
		
	    rdbtnNewRadioButtonR_Type_Lab = new JRadioButton("Laboraltory");
	    buttonGroup.add(rdbtnNewRadioButtonR_Type_Lab);
		rdbtnNewRadioButtonR_Type_Lab.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNewRadioButtonR_Type_Lab.setBounds(616, 474, 146, 21);
		contentPane.add(rdbtnNewRadioButtonR_Type_Lab);
		
		btnNewButton_Clear = new JButton("Clear");
		btnNewButton_Clear.addActionListener(this);
		btnNewButton_Clear.setBackground(Color.YELLOW);
		btnNewButton_Clear.setForeground(Color.BLACK);
		btnNewButton_Clear.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_Clear.setBounds(417, 639, 103, 44);
		contentPane.add(btnNewButton_Clear);
		
	    btnNewButton_Save = new JButton("Save");
		btnNewButton_Save.addActionListener(this);
		btnNewButton_Save.setBackground(Color.CYAN);
		btnNewButton_Save.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_Save.setBounds(641, 639, 85, 44);
		contentPane.add(btnNewButton_Save);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if( e.getSource() == btnNewButton_Clear ) {
			
			textField_BuidName.setText(null);
			textField_RoomName.setText(null);
			textField_Capcity.setText(null);
			buttonGroup.clearSelection();
			
			
		}
		
		
		
		
		if( e.getSource() ==btnNewButton_Save ) {
		
		String buildName = textField_BuidName.getText();
		String rName = textField_RoomName.getText();
		String capacity = textField_Capcity.getText();
		String r_type = "";
		
		if( buildName.equals("")) {
			JOptionPane.showMessageDialog(this, "Please Enter a Building Name", "Insert Error", JOptionPane.WARNING_MESSAGE);
			return ;
		}
		else  if( rName.equals("")) {
			JOptionPane.showMessageDialog(this, "Please Enter a Room Name", "Insert Error", JOptionPane.WARNING_MESSAGE);
			return ;
		}else if(!(rdbtnNewRadioButton_R_TypeLecHall.isSelected() | rdbtnNewRadioButtonR_Type_Lab.isSelected())) {
			JOptionPane.showMessageDialog(this, "Please Select a Room Type", "Insert Error", JOptionPane.WARNING_MESSAGE);
			return ;
		}
		
		
		int capcity;
		
		try {
			capcity = Integer.parseInt(capacity);				
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(this, "Inputs are not Valid, Please Check Again ", "Insert Error", JOptionPane.WARNING_MESSAGE);
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
		
		InsertLocation( buildName, r_type ,rName, capcity );
		
		textField_BuidName.setText(null);
		textField_RoomName.setText(null);
		textField_Capcity.setText(null);
		buttonGroup.clearSelection();
		
		}
		
		
		
	}
	
	
	public void InsertLocation( String buildName, String rtype, String rName, int capcity ){
		
		Location l = new Location(buildName, rtype, rName, capcity);
		try {
			location.insertLocation(l);
			this.showPlainMessageDialog("Successfuly Inserted", "Insert");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("gg");
			e.printStackTrace();
		}	
		
		
		
		
	}
	
	public void showWarningMessageDialog(String message, String title) {
		JOptionPane.showMessageDialog(getParent(), message, title, JOptionPane.WARNING_MESSAGE);;
	}
	
	public void showPlainMessageDialog(String message, String title) {
		JOptionPane.showMessageDialog(getParent(), message, title, JOptionPane.PLAIN_MESSAGE);
	}
}
