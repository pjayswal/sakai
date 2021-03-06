package org.sakai.commons;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Section {

	@Id
	@GeneratedValue
	private long id;
	
	private String title;

	@ManyToOne(cascade = CascadeType.MERGE)
	private Teacher faculty;

	@ManyToMany
	//(mappedBy="sections", cascade=CascadeType.ALL)
	@JoinTable(name = "Student_Section", joinColumns = {
			@JoinColumn(name = "section_id") }, inverseJoinColumns = { @JoinColumn(name = "student_id") })
	private List<Student> students = new ArrayList<Student>();

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date startDate;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date endDate;

	private int studentLimit;

	@OneToMany(mappedBy = "section")
	// bidirectional
	private List<Assignment> assignments = new ArrayList<Assignment>();

	@ManyToOne
	private Course course;

	public Section() {
	}

	public Section(String title,Date startDate, Date endDate, int studentLimit, Course course) {
		super();
		this.startDate = startDate;
		this.endDate = endDate;
		this.studentLimit = studentLimit;
		this.course = course;
		this.title = title;
		course.addSection(this);
		System.out.println("Section Added with course: " + course.getTitle());
	}

	public Section(String title, Teacher faculty, List<Student> students,
			Date startDate, Date endDate) {
		super();
		this.title = title;
		this.faculty = faculty;
		this.students = students;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public void addAssignment(Assignment assignment) {
		this.assignments.add(assignment);
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



	public int getStudentLimit() {
		return studentLimit;
	}

	public void setStudentLimit(int studentLimit) {
		this.studentLimit = studentLimit;
	}


	public void addStudent(Student student) {
		this.students.add(student);
		student.addSection(this);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
		for(Student s:students){
			s.addSection(this);
		}
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
		course.addSection(this);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	

}
