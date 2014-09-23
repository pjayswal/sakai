package org.sakai.serviceclients;

import java.util.List;

import org.sakai.commons.Assignment;
import org.sakai.commons.AssignmentStudent;
import org.sakai.commons.Section;
import org.sakai.commons.Student;


public interface IFacultyService {
	public List<Section> getSecctions(long id);
	public List<Student> getStudents(long sectionId);
	
	public void CreateAssignment(long sectionId,Assignment assignment);
	public List<Assignment> getAssignments(long sectionId);
	
	public List<AssignmentStudent> getAssignmentStudent(long assignmentId);
	
	public void UpdateAssignmnetStudent(AssignmentStudent as);
}
