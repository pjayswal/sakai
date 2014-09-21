package org.SakaiServices;

import java.util.List;

import org.SakaiCommons.Assignment;
import org.SakaiCommons.AssignmentStudent;
import org.SakaiCommons.Section;
import org.SakaiCommons.Student;
import org.SakaiDaoInterfaces.IPersonDAO;
import org.SakaiServiceClients.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.REQUIRED)
public class StudentService implements IStudentService {
	private IPersonDAO studentDAO;

	public StudentService() {
	}

	@Autowired
	public StudentService(IPersonDAO studentDAO) {
		super();
		this.studentDAO = studentDAO;
	}

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
