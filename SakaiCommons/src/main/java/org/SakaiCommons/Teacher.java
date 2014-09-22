package org.SakaiCommons;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Teacher extends Person{
	
	@OneToMany(mappedBy="faculty")
	private List<Section> sections;
	@OneToMany(mappedBy="advisor")
	private List<Student> advisee;
	
	public Teacher() {	}
	
	public List<Section> getSections() {
		return sections;
	}
	public void setSections(List<Section> sections) {
		this.sections = sections;
	}
	public List<Student> getAdvisee() {
		return advisee;
	}
	public void setAdvisee(List<Student> advisee) {
		this.advisee = advisee;
	}
	
	

}
