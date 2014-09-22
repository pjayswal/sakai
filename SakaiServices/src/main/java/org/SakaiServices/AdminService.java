package org.SakaiServices;

import java.util.List;

import org.SakaiCommons.Course;
import org.SakaiCommons.Person;
import org.SakaiCommons.Section;
import org.SakaiCommons.Student;
import org.SakaiCommons.Teacher;
import org.SakaiDAO.CourseDAO;
import org.SakaiDAO.PersonDAO;
import org.SakaiDAO.SectionDAO;
import org.SakaiServiceClients.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class AdminService implements IAdminService {

	private PersonDAO personDAO;
	private CourseDAO courseDAO;
	private SectionDAO sectionDAO;
	
	@Autowired
	public AdminService(PersonDAO personDAO, CourseDAO courseDAO,
			SectionDAO sectionDAO) {
		super();
		this.personDAO = personDAO;
		this.courseDAO = courseDAO;
		this.sectionDAO = sectionDAO;
	}

	public void createUser(Person p) {
		personDAO.create(p);
	}

	public void createCourse(Course c) {
		courseDAO.create(c);
	}

	public void createSection(Section section) {
		sectionDAO.create(section);
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

}
