package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.models.Location;

//import com.models.Lecture;

public class DBUtill {
	
	
	private static Connection con = null;
	private static ResultSet rs = null;
	private static PreparedStatement pst = null;
	private static Statement stmt = null;
	
	private static final String url = "jdbc:mysql://127.0.0.1:3308/tms";
	private static final String user = "root";
	private static final String passwrd = "";	 
	
	static {		
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection( url, user, passwrd);
		} catch (ClassNotFoundException e) {
			System.err.println("Exception :" +e.getMessage());
		} catch (SQLException e) {
			System.err.println("Exception :" +e.getMessage());
		}		
	}
	
	public DBUtill() {}
	
	public static Connection getConnection(){
		return con;
	}
	
	
	/* public ResultSet searchByEmpType( String searchType, int searchText ) {
		 rs = null;
		 
		 try {			
				String query = "select * from employee_details where "+searchType+"= '"+searchText+"' ";
				System.out.println(query);
				pst = con.prepareStatement(query);
				//pst.setInt(0, Integer.parseInt(id));	
				rs = pst.executeQuery(query);			
			} catch (SQLException e) {			
				e.printStackTrace();
			}		
		 
		 return rs;
	 }
	 
	 
	 public ResultSet refreshEmployeeTable() {	
		 
			try {
				getConnection();
				String query = "Select * From employee_details";
				
				pst = con.prepareStatement(query);
				rs = pst.executeQuery(query);			
			} catch (Exception e) {			
				System.out.println("Data Loading Error!!\n Please Check The Connection");
				System.err.println("Exception :" +e.getMessage());
			}		
			return rs;			
		}
	 
	 public Lecture searchLectureById(int empID) {		
			try {
				stmt = con.createStatement();
				String sql = "select* from employee_details where empID = '"+empID+"'";
				rs = stmt.executeQuery(sql);
				
				if( rs.next() ) {
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String faculty = rs.getString(3);
					String department = rs.getString(4);
					String centre = rs.getString(5);
					String buiding = rs.getString(6);
					double rank = rs.getDouble(7);
					
									
					return new Lecture( id, name, faculty, department, centre, buiding, rank);
					
				}
			}catch( SQLException e ) {
				System.out.println("searchLectureById");
				System.err.println("Exception :" +e.getMessage());
			}
			
			return null;
			
		}*/
	
	 public ResultSet refreshAddLocationTable() {	
		 
			try {
				getConnection();
				String query = "Select * From location";
				
				pst = con.prepareStatement(query);
				rs = pst.executeQuery(query);			
			} catch (Exception e) {			
				System.out.println("Data Loading Error!!\n Please Check The Connection");
				System.err.println("Exception :" +e.getMessage());
			}		
			return rs;			
		}
	
	
	
	 public Location searchLocationByName(String RName) {		
			try {
				stmt = con.createStatement();
				String sql = "select * from location where RoomName = '"+RName+"'";
				rs = stmt.executeQuery(sql);
				
				if( rs.next() ) {
					String buildingNmae = rs.getString(1);
					String  roomtype = rs.getString(2);
					String roomName = rs.getString(3);
				    int capacity = rs.getInt(4);
					
					
					return new Location(buildingNmae,roomtype,roomName,capacity);
					
				}
			}catch( SQLException e ) {
				System.out.println("searchLectureById");
				System.err.println("Exception :" +e.getMessage());
			}
			
			return null;
			
		}
	
	
	  public ResultSet searchByLocationType( String searchType, String searchText ) {
		  	rs = null;
	 
			 try {			
					String query = "select * from location where "+searchType+"= '"+searchText+"' ";
					System.out.println(query);
					pst = con.prepareStatement(query);
					//pst.setInt(0, Integer.parseInt(id));	
					rs = pst.executeQuery(query);			
				} catch (SQLException e) {			
					e.printStackTrace();
				}		
			 
			 return rs;
	  }
	  
	  
	  
	  
	

}
