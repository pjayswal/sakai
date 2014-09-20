package org.SakaiCommons;

public class Course {
	private int id;
	private String title;
	private String description;
	private String subjectCode;
	
	public Course() {	}
	
	public Course(String title, String description, String subjectCode) {
		super();
		this.title = title;
		this.description = description;
		this.subjectCode = subjectCode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSubjectCode() {
		return subjectCode;
	}
	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}
	
	
}
