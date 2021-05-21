package com.models;

public class Session {
	
	int id;
	
	String firstLec;
	
	String secondLec;
	
	String tag;
	
	String room;
	
	String mainGroup;
	
	String subGroup;
	
	String subject;
	
	String subjectCode;
	
	int NoOfStudents;
	
	String day;
	
	String duration;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstLec() {
		return firstLec;
	}

	public void setFirstLec(String firstLec) {
		this.firstLec = firstLec;
	}

	public String getSecondLec() {
		return secondLec;
	}

	public void setSecondLec(String secondLec) {
		this.secondLec = secondLec;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}

	public String getMainGroup() {
		return mainGroup;
	}

	public void setMainGroup(String mainGroup) {
		this.mainGroup = mainGroup;
	}

	public String getSubGroup() {
		return subGroup;
	}

	public void setSubGroup(String subGroup) {
		this.subGroup = subGroup;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public int getNoOfStudents() {
		return NoOfStudents;
	}

	public void setNoOfStudents(int noOfStudents) {
		NoOfStudents = noOfStudents;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}
	
	

}
