package org.SakaiServiceClients;

import java.util.List;

import org.SakaiCommons.Assignment;
import org.SakaiCommons.AssignmentStudent;
import org.SakaiCommons.Section;
import org.SakaiCommons.Student;


public interface IFacultyService {
	public List<Section> getCourses(long id);
	public List<Student> getStudents(Section section);
	
	public void CreateAssignment(Section section,Assignment assignment);
	public List<Assignment> getAssignments(Section section);
	
	public List<AssignmentStudent> getAssignmentStudent(Assignment assignment, Section section);
	
	public void UpdateAssignmnetStudent(AssignmentStudent as);
}