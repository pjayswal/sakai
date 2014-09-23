package org.sakai.services;

import java.util.List;

import org.sakai.commons.Assignment;
import org.sakai.commons.AssignmentStudent;
import org.sakai.commons.Section;
import org.sakai.commons.Student;
import org.sakai.daointerfaces.IAssignmentDAO;
import org.sakai.daointerfaces.IPersonDAO;
import org.sakai.daointerfaces.ISectionDAO;
import org.sakai.serviceclients.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class StudentService implements IStudentService {
	
	@Autowired
	private IPersonDAO studentDAO;
	@Autowired
	private ISectionDAO sectionDAO;
	
	private IAssignmentDAO assignmentDAO;
	
	public List<Section> getSections(long id) {
		Student student = (Student) studentDAO.get(id);
		List<Section> sectionList = student.getSections();
		return sectionList;
	}

	public List<Assignment> getAssignments(long sectionId) {
		Section section = sectionDAO.get(sectionId);
		return section.getAssignments();
	}


	public List<AssignmentStudent> listAssignmentStudent(long student_id,
			long section_id) {
		
		return assignmentDAO.listAssignmentStudent(student_id,section_id);
	}

	public AssignmentStudent getAssignmentStudent(long student_id,
			long assignment_id) {
		return assignmentDAO.getAssignmentStudent(student_id, assignment_id);
		
	}

}
