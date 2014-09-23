package org.sakai.serviceclients;

import java.util.List;

import org.sakai.commons.Assignment;
import org.sakai.commons.AssignmentStudent;
import org.sakai.commons.Section;
import org.sakai.commons.Student;

public interface IStudentService {
	public List<Section> getSections(long id);
	public List<Assignment> getAssignments(Section section);
	public List<AssignmentStudent> getAssignmentStudent(Student student, Section section);
	
}
