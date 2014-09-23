package org.sakai.serviceclients;

import java.util.List;

import org.sakai.commons.Assignment;
import org.sakai.commons.AssignmentStudent;
import org.sakai.commons.Section;
import org.sakai.commons.Student;

public interface IStudentService {
	public List<Section> getSections(long id);
	public List<Assignment> getAssignments(long sectionId);
	public List<AssignmentStudent> listAssignmentStudent(long student_id, long section_id);
	public AssignmentStudent getAssignmentStudent(long student_id,long assignment_id);
	public Student getStudent(long id);
	
}
