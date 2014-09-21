package org.SakaiServiceClients;

import java.util.List;

import org.SakaiCommons.Assignment;
import org.SakaiCommons.AssignmentStudent;
import org.SakaiCommons.Section;
import org.SakaiCommons.Student;

public interface IStudentService {
	public List<Section> getCourses(long id);
	public List<Assignment> getAssignments(Section section);
	public List<AssignmentStudent> getAssignmentStudent(Student student, Section section);
	
}
