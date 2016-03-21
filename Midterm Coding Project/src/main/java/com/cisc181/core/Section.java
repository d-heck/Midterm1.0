package com.cisc181.core;

import java.util.UUID;

public class Section {
	
	//Attributes
	private UUID SemeseterID;
	private UUID CourseID;
	private UUID SectionID;
	private int RoomID;
	
	//Getters and Setters
	public UUID getSemeseterID() {
		return SemeseterID;
	}
	public void setSemeseterID(UUID semeseterID) {
		SemeseterID = semeseterID;
	}
	public UUID getCourseID() {
		return CourseID;
	}
	public void setCourseID(UUID courseID) {
		CourseID = courseID;
	}
	public UUID getSectionID() {
		return SectionID;
	}
	public void setSectionID(UUID sectionID) {
		SectionID = sectionID;
	}
	public int getRoomID() {
		return RoomID;
	}
	public void setRoomID(int roomID) {
		RoomID = roomID;
	}

	//Constructors
	public Section(UUID semeseterID, UUID courseID, UUID sectionID, int roomID) {
		super();
		SemeseterID = semeseterID;
		CourseID = courseID;
		SectionID = sectionID;
		RoomID = roomID;
	}
	public Section() {
	}
	
}
