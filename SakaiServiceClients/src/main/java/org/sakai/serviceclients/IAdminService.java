package org.sakai.serviceclients;

import java.util.List;

import org.sakai.commons.Admin;
import org.sakai.commons.Course;
import org.sakai.commons.Person;
import org.sakai.commons.Role;
import org.sakai.commons.Section;
import org.sakai.commons.Student;
import org.sakai.commons.Teacher;

public interface IAdminService {
		public void createAdmin(Admin a);
		public void createStudent(Student s);
		public void createTeacher(Teacher t);
		
		public void updateAdmin(Admin a);
		public void updateStudent(Student s);
		public void updateTeacher(Teacher t);
		
		public void deleteAdmin(Admin a);
		public void deleteStudent(Student s);
		public void deleteTeacher(Teacher t);
		
		
		
		public void createCourse(Course c);
		public void updateCourse(Course c);
		public void deleteCourse(Course c);
		
		public void createSection(Section section);
		public void updateSection(Section s);
		public void deleteSection(Section s);
		
		public void assignTeacherToSection(Section section, Teacher teacher);
		public void addStudentToSection(Section section, Student student);
		public void addStudentListToSection(Section section, List<Student> student);
		
		public void createRole(Role role);		
		public void updateRole(Role role);
		public void deleteRole(Role role);
		
		public List<Student> getStudents();
		public List<Teacher> getTeachers();
		public List<Course> getCourses();
		public List<Admin> getAdmins();
		
		public Person getPerson(String username);
}
