package org.SakaiServices;

import java.util.List;

import org.SakaiCommons.Course;
import org.SakaiCommons.Person;
import org.SakaiCommons.Role;
import org.SakaiCommons.Section;
import org.SakaiCommons.Student;
import org.SakaiCommons.Teacher;
import org.SakaiDAO.CourseDAO;
import org.SakaiDAO.PersonDAO;
import org.SakaiDAO.RoleDAO;
import org.SakaiDAO.SectionDAO;
import org.SakaiDaoInterfaces.ICourseDAO;
import org.SakaiDaoInterfaces.IPersonDAO;
import org.SakaiDaoInterfaces.IRoleDAO;
import org.SakaiDaoInterfaces.ISectionDAO;
import org.SakaiServiceClients.IAdminService;
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

	public void createRole(Role role) {
		roleDAO.create(role);
		
	}

}
