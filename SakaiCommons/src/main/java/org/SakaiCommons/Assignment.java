package org.SakaiCommons;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;



public class Assignment {

	@Id @GeneratedValue
	private long id;
	
	@NotNull
	private String title;
	
	private String details;
	
	@NotNull
	private Date openDate;
	@NotNull
	private Date dueDate;
	
	@NotNull
	private String gradePoint;
	
	
	private List<String> assignments = new ArrayList<String>();
	
	@OneToMany//Unidirectional
	private List<AssignmentStudent> assignmentStudents = new ArrayList<AssignmentStudent>(); 
	
	
	public void addAssignments(String newAssignment){
		assignments.add(newAssignment);
	}
	
	public Assignment() {
		// TODO Auto-generated constructor stub
	}
	
	public Assignment(String title, String details, Date openDate, Date dueDate) {
		super();
		this.title = title;
		this.details = details;
		this.openDate = openDate;
		this.dueDate = dueDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public List<String> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<String> assignments) {
		this.assignments = assignments;
	}

	public String getGradePoint() {
		return gradePoint;
	}

	public void setGradePoint(String gradePoint) {
		this.gradePoint = gradePoint;
	}

	public List<AssignmentStudent> getAssignmentStudent() {
		return assignmentStudents;
	}

	public void setAssignmentStudent(List<AssignmentStudent> assignmentStudent) {
		this.assignmentStudents = assignmentStudent;
	}
	
	public void addAssignmentStudent(AssignmentStudent assignmentStudent){
		assignmentStudents.add(assignmentStudent);
	}
	
	
	

}
