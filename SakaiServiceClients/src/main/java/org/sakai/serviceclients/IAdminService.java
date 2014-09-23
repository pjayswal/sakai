package org.sakai.serviceclients;

import java.util.List;

import org.sakai.commons.Course;
import org.sakai.commons.Person;
import org.sakai.commons.Role;
import org.sakai.commons.Section;
import org.sakai.commons.Student;
import org.sakai.commons.Teacher;

public interface IAdminService {
		public void createUser(Person p);
		public void createCourse(Course c);
		public void createSection(Section section);
		public void assignTeacherToSection(Section section, Teacher teacher);
		public void addStudentToSection(Section section, Student student);
		public void addStudentListToSection(Section section, List<Student> student);
		public void createRole(Role role);		
		public Person getPerson(String username);
		
}
