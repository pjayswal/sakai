package org.sakai.commons;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Teacher extends Person{
	
	@OneToMany(mappedBy="faculty", cascade=CascadeType.ALL)
	private List<Section> sections = new ArrayList<Section>();
	@OneToMany(mappedBy="advisor")
	private List<Student> advisees = new ArrayList<Student>();
	
	public Teacher() {	}
	
	public Teacher(String name, String phone, String email,Address address,UserCredential user) {
		super(name, phone, email, address);
		
		setUser(user);
	}
	public void addSection(Section section){
		sections.add(section);
	}
	
	public void addAdvisee(Student student){
		advisees.add(student);
	}
	public List<Section> getSections() {
		return sections;
	}
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	public List<Student> getAdvisee() {
		return advisees;
	}
	public void setAdvisee(List<Student> advisee) {
		this.advisees = advisee;
	}
	
	

}
