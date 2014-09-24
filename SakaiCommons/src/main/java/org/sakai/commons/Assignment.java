package org.sakai.commons;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.multipart.MultipartFile;


@Entity 
public class Assignment {

	@Id @GeneratedValue
	private long id;
	
	@NotEmpty
	private String title;
	
	private String details;
	
	private String openDate;
	
	private String dueDate;
	
	@NotEmpty
	private String gradePoint;
	
	@Lob
	private byte[] assignments;
	
	@Transient
	private MultipartFile webFile;
	 
	
	@OneToMany		//Unidirectional
	private List<AssignmentStudent> assignmentStudents = new ArrayList<AssignmentStudent>(); 
	
	@OneToOne
	@JoinColumn(name="section_id")
	private Section section;
	
	public Assignment() {
		// TODO Auto-generated constructor stub
	}
	
	public Assignment(String title, String details, String openDate, String dueDate, MultipartFile webFile) {
		super();
		this.title = title;
		this.details = details;
		this.openDate = openDate;
		this.dueDate = dueDate;
		try {
			this.assignments = webFile.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	public String getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		this.openDate = openDate;
	}

	public byte[] getAssignments() {
		return assignments;
	}

	public void setAssignments(byte[] assignments) {
		this.assignments = assignments;
	}

	public String getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
		this.dueDate = dueDate;
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

	public Section getSection() {
		return section;
	}

	public void setSection(Section section) {
		this.section = section;
	}
	
	public MultipartFile getWebFile() {
		return webFile;
	}

	public void setWebFile(MultipartFile webFile) {
		this.webFile = webFile;
		try {
			this.assignments = webFile.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	

}
