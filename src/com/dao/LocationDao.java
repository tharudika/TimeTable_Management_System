package com.dao;

import java.sql.*;
import java.util.ArrayList;

import com.models.Location;

import com.util.DBUtill;

public class LocationDao {

	
	
	
	


		Connection con = DBUtill.getConnection();
		
		public void insertLocation(Location location) throws SQLException {
			// TODO Auto-generated method stub
			
			
			PreparedStatement pst = con.prepareStatement("insert into location values(?,?,?,?)");
			pst.setString(1, location.getBuildingNmae());
			pst.setString(2, location.getRoomtype());
			pst.setString(3, location.getRoomName());
			pst.setInt(4, location.getCapacity());
	
			
			
			pst.executeUpdate();	
		}
		
		
		public void updateLocation(Location location) throws SQLException {
			
			PreparedStatement pst = con.prepareStatement("update location set BuildingName=?,"+"RoomType=?,"+"Capacity=?  where RoomName = ?");;
			
			//pst.setString(1,order.getStaffName());
			pst.setString(1,location.getBuildingNmae());
			pst.setString(2, location.getRoomtype());			
			pst.setInt(3, location.getCapacity());
			pst.setString(4,location.getRoomName());
				
			
			pst.executeUpdate();		
		}
		
		public ArrayList<Location> getlocation(){
			
			ArrayList<Location> list = new ArrayList<Location>();
			String query = "select * from location";
			
			try {
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(query);
				
				while(rs.next()) {
					Location loc = new Location();
					
					loc.setBuildingNmae(rs.getString(1));
					loc.setRoomtype(rs.getString(2));
					loc.setRoomName(rs.getString(3));
					loc.setCapacity(rs.getInt(4));
					list.add(loc);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
			
		}
		
		public void deleteLocation(String RoomName) throws SQLException {

			PreparedStatement pst = con.prepareStatement("delete from location where RoomName = ?");
			pst.setString( 1, RoomName );
			pst.executeUpdate();
			
		}

		
}
