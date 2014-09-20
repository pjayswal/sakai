package org.SakaiCommons;

import java.util.List;

import javax.persistence.OneToMany;

public class Teacher extends Person{
	
	@OneToMany(mappedBy="faculty")
	private List<Section> sections;
	@OneToMany(mappedBy="advisor")
	private List<Student> advisee;
	
	

}
