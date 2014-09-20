package org.SakaiCommons;

import java.util.Date;
import java.util.List;

public class Section {
	private Teacher teachedBy;
	private List<Student> enrolledStudents;
	private Date startDate;
	private Date endDate;
	private int studentLimit;
	
	public Section() {	}
	
	public Section(Teacher teachedBy, Date startDate, Date endDate, int studentLimit) {
		super();
		this.teachedBy = teachedBy;
		this.startDate = startDate;
		this.endDate = endDate;
		this.studentLimit = studentLimit;
	}
	

	public Teacher getTeachedBy() {
		return teachedBy;
	}

	public void setTeachedBy(Teacher teachedBy) {
		this.teachedBy = teachedBy;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Student> getEnrolledStudents() {
		return enrolledStudents;
	}
	

	public int getStudentLimit() {
		return studentLimit;
	}

	public void setStudentLimit(int studentLimit) {
		this.studentLimit = studentLimit;
	}

	public void setEnrolledStudents(List<Student> enrolledStudents) {
		this.enrolledStudents = enrolledStudents;
	}

	public void addStudent(Student student){
		this.enrolledStudents.add(student);
	}
}
