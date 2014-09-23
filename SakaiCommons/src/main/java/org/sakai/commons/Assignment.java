package org.sakai.commons;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Type;


@Entity 
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
	
	@Lob
	private String assignments;
	
	@OneToMany(cascade=CascadeType.PERSIST)		//Unidirectional
	private List<AssignmentStudent> assignmentStudents = new ArrayList<AssignmentStudent>(); 
	
	

	
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

	

	public String getAssignments() {
		return assignments;
	}

	public void setAssignments(String assignments) {
		this.assignments = assignments;
	}

	public List<AssignmentStudent> getAssignmentStudents() {
		return assignmentStudents;
	}

	public void setAssignmentStudents(List<AssignmentStudent> assignmentStudents) {
		this.assignmentStudents = assignmentStudents;
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
	
	public AssignmentStudent getStudentGrade(Student student){
		for(AssignmentStudent as: this.assignmentStudents)
			if(as.getStudent().equals(student))
				return as;

		return null;
	}
	

}
