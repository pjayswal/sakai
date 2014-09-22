package org.SakaiCommons;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Section {
	
	@Id @GeneratedValue
	private int id;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private Teacher faculty;
	
	@ManyToMany(mappedBy="sections",cascade = CascadeType.PERSIST)
	private List<Student> students=new ArrayList<Student>();
	
	@Temporal(TemporalType.DATE)
	private Date startDate;
	@Temporal(TemporalType.DATE)
	private Date endDate;
	
	private int studentLimit;
	
	@OneToMany(cascade=CascadeType.PERSIST)//unidirectional
	private List<Assignment> assignments = new ArrayList<Assignment>();
	
	@ManyToOne
	@NotNull
	private Course course;
	
	
	public Section() {	}
	
	public Section(Teacher teachedBy, Date startDate, Date endDate, int studentLimit,Course course) {
		super();
		this.faculty = teachedBy;
		this.startDate = startDate;
		this.endDate = endDate;
		this.studentLimit = studentLimit;
		this.course=course;
		course.addSection(this);
	}
	

	public void addAssignment(Assignment assignment){
		this.assignments.add(assignment);
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Teacher getFaculty() {
		return faculty;
	}

	public void setFaculty(Teacher faculty) {
		this.faculty = faculty;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public List<Assignment> getAssignments() {
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
