package org.SakaiServiceClients;

import java.util.List;

import org.SakaiCommons.Course;
import org.SakaiCommons.Person;
import org.SakaiCommons.Role;
import org.SakaiCommons.Section;
import org.SakaiCommons.Student;
import org.SakaiCommons.Teacher;

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
