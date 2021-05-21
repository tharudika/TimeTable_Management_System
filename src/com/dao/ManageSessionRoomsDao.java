package com.dao;

import java.sql.*;
import java.util.ArrayList;

import com.models.Manage_SessionRooms;
import com.util.DBUtill;

public class ManageSessionRoomsDao {

	Connection con = DBUtill.getConnection();
	
	public void insertRooms(Manage_SessionRooms object) {
		String insert = "insert into session_rooms values(?,?,?) ";
		
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(insert);
			ps.setInt(1, object.getId());
			ps.setInt(2, object.getSession());
			ps.setString(3, object.getRoom());
			ps.execute();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	public ArrayList<Manage_SessionRooms> getSessions(){
		ArrayList<Manage_SessionRooms> sessions = new ArrayList<Manage_SessionRooms>();
		
		String query = "select * from session_rooms";
		Statement s;
		try {
			s = con.createStatement();
			ResultSet rs = s.executeQuery(query);
			
			while(rs.next()) {
				Manage_SessionRooms obj = new Manage_SessionRooms();
				obj.setId(rs.getInt(1));
				obj.setSession(rs.getInt(2));
				obj.setRoom(rs.getString(3));
				sessions.add(obj);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sessions;
	}
	
}
