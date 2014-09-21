package org.SakaiServices;

import java.util.ArrayList;
import java.util.List;

import org.SakaiCommons.Assignment;
import org.SakaiCommons.AssignmentStudent;
import org.SakaiCommons.Course;
import org.SakaiCommons.Section;
import org.SakaiCommons.Student;
import org.SakaiDAO.CourseDAO;
import org.SakaiDAO.SectionDAO;
import org.SakaiDaoInterfaces.IPersonDAO;
import org.SakaiServiceClients.IStudentService;

public class StudentService implements IStudentService	{
	private IPersonDAO studentDAO;
	private CourseDAO courseDAO;
	private SectionDAO sectionDAO;

	
	public StudentService() {	}
	
	public List<Section> getCourses(long id) {
		Student student = (Student) studentDAO.get(id);
		return student.getSections();
	}

	public List<Assignment> getAssignments(Section section) {
		return section.getAssignments();
	}

	public List<AssignmentStudent> getAssignmentStudent(Student student,
			Section section) {
		List<Section> sections = getCourses(student.getId());
		List<AssignmentStudent> gradeList = new ArrayList<AssignmentStudent>();
		for(Section sec: sections){
			
		}
		
		return null;
	}

}
