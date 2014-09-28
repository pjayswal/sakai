package org.sakai.commons;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
public class Student extends Person{
	
	@ManyToMany (mappedBy="students")
	private List<Section> sections= new ArrayList<Section>();
	
	@ManyToOne
	private Teacher advisor;
	
	private int rollNum;
	
	public Student() {
	}
	
	public Student(String name, String phone, String email,Address address,int rollNum,UserCredential user) {
		super(name, phone, email, address,user);
		this.rollNum=rollNum;
		
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
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return getName();
	}
	
}
