package org.sakai.services;

import java.util.List;

import org.sakai.commons.Course;
import org.sakai.commons.Person;
import org.sakai.commons.Role;
import org.sakai.commons.Section;
import org.sakai.commons.Student;
import org.sakai.commons.Teacher;
import org.sakai.daointerfaces.ICourseDAO;
import org.sakai.daointerfaces.IPersonDAO;
import org.sakai.daointerfaces.IRoleDAO;
import org.sakai.daointerfaces.ISectionDAO;
import org.sakai.serviceclients.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class AdminService implements IAdminService {
	@Autowired
	private IPersonDAO personDAO;
	@Autowired
	private ICourseDAO courseDAO;
	@Autowired
	private ISectionDAO sectionDAO;
	@Autowired
	private IRoleDAO roleDAO;
	
	
	public void createUser(Person p) {
		personDAO.create(p);
	}

	public void createCourse(Course c) {
		courseDAO.create(c);
	}

	public void createSection(Section section) {
		//sectionDAO.create(section);
		sectionDAO.update(section);
	}

	public void assignTeacherToSection(Section section, Teacher teacher) {
		section.setTeachedBy(teacher);
		sectionDAO.update(section);
	}

	public void addStudentToSection(Section section, Student student) {
		section.addStudent(student);
		sectionDAO.update(section);
	}

	public void addStudentListToSection(Section section, List<Student> student) {
		for(Student s : student)
			section.addStudent(s);
		sectionDAO.update(section);
	}

	public void createRole(Role role) {
		roleDAO.create(role);
	}
	public Person getPerson(String username){
		return personDAO.getPerson(username);
	}

}
