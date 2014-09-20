package org.SakaiCommons;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Student extends Person{
	
	@ManyToMany
	@JoinTable(name="Student_Section",
			joinColumns={@JoinColumn(name="student_id")},
			inverseJoinColumns={@JoinColumn(name="section_id")}
	)
	private List<Section> sections;
	
	@ManyToOne
	private Teacher advisor;
	
	private int rollNum;
	
	public Student() {	}
	public Student(List<Section> sections, Teacher advisor, int rollNum) {
		super();
		this.sections = sections;
		this.advisor = advisor;
		this.rollNum = rollNum;
	}
	
	public void addSection(Section section){
		this.sections.add(section);
	}
	public List<Section> getSections() {
		return sections;
	}
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	public Teacher getAdvisor() {
		return advisor;
	}
	public void setAdvisor(Teacher advisor) {
		this.advisor = advisor;
	}
	public int getRollNum() {
		return rollNum;
	}
	public void setRollNum(int rollNum) {
		this.rollNum = rollNum;
	}
	
	
}
