package com.models;

public class ManageLocation {
	
	private String BuildingNmae;
	private String Roomtype;
	private String RoomName;
	private int Capacity;
	
public ManageLocation() {}
	
	public ManageLocation(String buildingNmae, String roomtype, String roomName, int capacity) {
		super();
		BuildingNmae = buildingNmae;
		Roomtype = roomtype;
		RoomName = roomName;
		Capacity = capacity;
	}
	
	
	
	

	public String getBuildingNmae() {
		return BuildingNmae;
	}

	public String getRoomtype() {
		return Roomtype;
	}

	public String getRoomName() {
		return RoomName;
	}

	public int getCapacity() {
		return Capacity;
	}

	public void setBuildingNmae(String buildingNmae) {
		BuildingNmae = buildingNmae;
	}

	public void setRoomtype(String roomtype) {
		Roomtype = roomtype;
	}

	public void setRoomName(String roomName) {
		RoomName = roomName;
	}

	public void setCapacity(int capacity) {
		Capacity = capacity;
	}
	
	

}
