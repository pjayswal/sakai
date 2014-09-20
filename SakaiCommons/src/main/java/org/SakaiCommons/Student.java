package org.SakaiCommons;

import java.util.List;

public class Student extends Person{
	private List<Section> registeredSections;
	private Teacher advisor;
	private int rollNum;
	
	public Student() {	}
	public Student(List<Section> sections, Teacher advisor, int rollNum) {
		super();
		this.registeredSections = sections;
		this.advisor = advisor;
		this.rollNum = rollNum;
	}
	
	public void addSection(Section section){
		this.registeredSections.add(section);
	}
	public List<Section> getSections() {
		return registeredSections;
	}
	public void setSections(List<Section> sections) {
		this.registeredSections = sections;
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
