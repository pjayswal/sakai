package org.sakai.services;

import java.util.List;

import org.sakai.commons.Course;
import org.sakai.commons.Admin;
import org.sakai.commons.Person;
import org.sakai.commons.Role;
import org.sakai.commons.Section;
import org.sakai.commons.Student;
import org.sakai.commons.Teacher;
import org.sakai.daointerfaces.ICourseDAO;
import org.sakai.daointerfaces.IPersonDAO;
import org.sakai.daointerfaces.IRoleDAO;
import org.sakai.daointerfaces.ISectionDAO;
import org.sakai.daointerfaces.IStudentDAO;
import org.sakai.daointerfaces.ITeacherDao;
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
	@Autowired
	private IStudentDAO studentDAO;
	@Autowired
	private ITeacherDao teacherDAO;
	
	public void createAdmin(Admin a) {
		personDAO.create(a);
	}
	public void createStudent(Student s){
		studentDAO.create(s);
	}
	
	public void createTeacher(Teacher teacher){
		teacherDAO.create(teacher);
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
	public Person getPerson(String username){
		return personDAO.getPerson(username);
	}

	public void updateAdmin(Admin a) {
		personDAO.update(a);
		
	}
	public void updateStudent(Student s) {
		studentDAO.update(s);
		
	}
	public void updateTeacher(Teacher t) {
		teacherDAO.update(t);
		
	}
	public void deleteAdmin(Admin a) {
		personDAO.delete(a);
		
	}
	public void deleteStudent(Student s) {
		studentDAO.delete(s);
		
	}
	public void deleteTeacher(Teacher t) {
		teacherDAO.delete(t);
		
	}
	public void updateCourse(Course c) {
		// TODO Auto-generated method stub
		
	}
	public void deleteCourse(Course c) {
		// TODO Auto-generated method stub
		
	}
	public void updateSection(Section s) {
		// TODO Auto-generated method stub
		
	}
	public void deleteSection(Section s) {
		// TODO Auto-generated method stub
		
	}
	public void updateRole(Role role) {
		// TODO Auto-generated method stub
		
	}
	public void deleteRole(Role role) {
		// TODO Auto-generated method stub
		
	}
	public List<Student> getStudents() {
		return studentDAO.getAll();
	}
	public List<Teacher> getTeachers() {
		return teacherDAO.getAll();
	}
	public List<Course> getCourses() {
		// TODO Auto-generated method stub
		return null;
	}
	public List<Admin> getAdmins() {
		// TODO Auto-generated method stub
		return null;
	}


}
