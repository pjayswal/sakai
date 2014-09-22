package org.SakaiServiceClients;

import java.util.List;

import org.SakaiCommons.Assignment;
import org.SakaiCommons.AssignmentStudent;
import org.SakaiCommons.Section;
import org.SakaiCommons.Student;


public interface IFacultyService {
	public List<Section> getSecctions(long id);
	public List<Student> getStudents(long sectionId);
	
	public void CreateAssignment(long sectionId,Assignment assignment);
	public List<Assignment> getAssignments(long sectionId);
	
	public List<AssignmentStudent> getAssignmentStudent(long assignmentId);
	
	public void UpdateAssignmnetStudent(AssignmentStudent as);
}
