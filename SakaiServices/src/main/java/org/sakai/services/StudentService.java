package org.sakai.services;

import java.util.List;

import org.sakai.commons.Assignment;
import org.sakai.commons.AssignmentStudent;
import org.sakai.commons.Section;
import org.sakai.commons.Student;
import org.sakai.daointerfaces.IPersonDAO;
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


	public List<Section> getSections(long id) {

		// Transaction tx =
		// sessionFactory.getCurrentSession().beginTransaction();
		Student student = (Student) studentDAO.get(id);
		List<Section> sectionList = student.getSections();
		// tx.commit();
		return sectionList;

	}

	public List<Assignment> getAssignments(Section section) {
		// Transaction tx =
		// sessionFactory.getCurrentSession().beginTransaction();
		List<Assignment> assignmentList = section.getAssignments();
		// tx.commit();
		return assignmentList;
	}

	public List<AssignmentStudent> getAssignmentStudent(Student student,
			Section section) {
//		Transaction tx = sessionFactory.getCurrentSession().beginTransaction();
		List<AssignmentStudent> gradeList = studentDAO.getAssignmentGradeList(student.getId());
//		tx.commit();
		return gradeList;
	}

}
