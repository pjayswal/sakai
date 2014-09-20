package org.SakaiCommons;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Section {
	
	@Id @GeneratedValue
	private int id;
	
	@ManyToOne
	private Teacher faculty;
	
	@ManyToMany(mappedBy="sections")
	private List<Student> students;
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	private int studentLimit;
	
	public Section() {	}
	
	public Section(Teacher teachedBy, Date startDate, Date endDate, int studentLimit) {
		super();
		this.faculty = teachedBy;
		this.startDate = startDate;
		this.endDate = endDate;
		this.studentLimit = studentLimit;
	}
	

	public Teacher getTeachedBy() {
		return faculty;
	}

	public void setTeachedBy(Teacher teachedBy) {
		this.faculty = teachedBy;
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
		return students;
	}
	

	public int getStudentLimit() {
		return studentLimit;
	}

	public void setStudentLimit(int studentLimit) {
		this.studentLimit = studentLimit;
	}

	public void setEnrolledStudents(List<Student> enrolledStudents) {
		this.students = enrolledStudents;
	}

	public void addStudent(Student student){
		this.students.add(student);
	}
}
