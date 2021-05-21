package com.dao;

import java.sql.*;

import com.util.DBUtill;

public class StatisticsDAOImpl {
	Connection con = DBUtill.getConnection();
	public int getRoom(String type) {
	//Connection con = db.connect();
	String countRooms = "select count(RoomName) as roomCount from location where RoomType = '"+type+"' ";
	
	int countType = 0;
	
	try {
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery(countRooms);
		rs.next();
		
		countType = rs.getInt("roomCount");
		
		//con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return countType;
}
	
	
	
	
	public int registeredCount(String value) {

		 
		 int lecCount = 0;

		 String getStudents = "select count(*) as total from "+value+" ";

		 try {
		Statement stat = con.createStatement();
		ResultSet rs = stat.executeQuery(getStudents);
		rs.next();
		lecCount = rs.getInt("total");

		 } catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}

		 return lecCount;
		}
	
	
	public String latestRecord(String value) {
		

		 String lastRecord = "";

		 int column = 0;

		 if(value.equals("employee_details")) {
		column = 2;
		}else if(value.equals("student_group")) {
		column = 7;
		}else if(value.equals("subject_details")) {
		column = 2;
		}


		 String latestrecordQuery = "select * from "+value+" ";
		try {
		Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		ResultSet rs = st.executeQuery(latestrecordQuery);
		rs.last();
		lastRecord = rs.getString(column);
		} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		}

		 return lastRecord;
		}
	
}
