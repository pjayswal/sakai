package org.sakai.commons;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AssignmentStudent {
	
	@Id @GeneratedValue
	private long id;
	
	@OneToOne
	private Student student;
	private Date submitedDate;	
	private String gradeAchieved;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}



	public String getGradeAchieved() {
		return gradeAchieved;
	}

	public void setGradeAchieved(String gradeAchieved) {
		this.gradeAchieved = gradeAchieved;
	}

	public Date getSubmitedDate() {
		return submitedDate;
	}

	public void setSubmitedDate(Date submitedDate) {
		this.submitedDate = submitedDate;
	}
	
	
	
	
}
