package org.sakai.commons;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
	
	@Temporal(TemporalType.DATE)
	private Date openDate;
	
	@Temporal(TemporalType.DATE)
	private Date dueDate;
	
	@NotEmpty
	private String gradePoint;
	
	@Lob
	private byte[] assignments;
	
	@Transient
	private MultipartFile webFile;
	 
	
	@OneToMany		//Unidirectional
	private List<AssignmentSolution> assignmentStudents = new ArrayList<AssignmentSolution>(); 
	
	@OneToOne
	@JoinColumn(name="section_id")
	private Section section;
	
	public Assignment() {
		// TODO Auto-generated constructor stub
	}
	
	public Assignment(String title, String details, String openDate, String dueDate, MultipartFile webFile) {
		super();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		this.title = title;
		this.details = details;
		try {
			this.openDate = formatter.parse(openDate);
			this.dueDate = formatter.parse(dueDate);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
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

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(String openDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			this.openDate = formatter.parse(openDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public byte[] getAssignments() {
		return assignments;
	}

	public void setAssignments(byte[] assignments) {
		this.assignments = assignments;
	}

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(String dueDate) {
SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			this.dueDate = formatter.parse(dueDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public List<AssignmentSolution> getAssignmentStudents() {
		return assignmentStudents;
	}

	public void setAssignmentStudents(List<AssignmentSolution> assignmentStudents) {
		this.assignmentStudents = assignmentStudents;
	}

	public String getGradePoint() {
		return gradePoint;
	}

	public void setGradePoint(String gradePoint) {
		this.gradePoint = gradePoint;
	}

	public List<AssignmentSolution> getAssignmentStudent() {
		return assignmentStudents;
	}

	public void setAssignmentStudent(List<AssignmentSolution> assignmentStudent) {
		this.assignmentStudents = assignmentStudent;
	}
	
	public void addAssignmentStudent(AssignmentSolution assignmentStudent){
		assignmentStudents.add(assignmentStudent);
	}
	
	public AssignmentSolution getStudentGrade(Student student){
		for(AssignmentSolution as: this.assignmentStudents)
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
