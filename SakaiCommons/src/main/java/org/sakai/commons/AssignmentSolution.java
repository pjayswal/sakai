package org.sakai.commons;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
public class AssignmentSolution {
	
	@Id @GeneratedValue
	private long id;
	
	@OneToOne
	private Student student;
	
	@Temporal(TemporalType.DATE)
	private Date submitedDate;	
	private String gradeAchieved;
	
	@Lob
	private byte [] submittedAssignment;
	
	@Transient
	private MultipartFile webFile;

	
	
	
	public AssignmentSolution() {
		super();
	}
	

	public AssignmentSolution(long id, Student student, Date submitedDate,
			String gradeAchieved, MultipartFile webFile) {
		super();
		this.id = id;
		this.student = student;
		this.submitedDate = submitedDate;
		this.gradeAchieved = gradeAchieved;
		this.webFile = webFile;
		try {
			this.submittedAssignment=webFile.getBytes();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public byte[] getSubmittedAssignment() {
		return submittedAssignment;
	}


	public void setSubmittedAssignment(byte[] submittedAssignment) {
		this.submittedAssignment = submittedAssignment;
	}


	public MultipartFile getWebFile() {
		return webFile;
	}


	public void setWebFile(MultipartFile webFile) {
		try {
			this.submittedAssignment=webFile.getBytes();
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

	public void setSubmitedDate(String submitedDate) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		try {
			this.submitedDate = formatter.parse(submitedDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
}
