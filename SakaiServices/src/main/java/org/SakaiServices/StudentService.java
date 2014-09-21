package org.SakaiServices;

import java.util.List;

import org.SakaiCommons.Assignment;
import org.SakaiCommons.AssignmentStudent;
import org.SakaiCommons.Section;
import org.SakaiCommons.Student;
import org.SakaiDAO.CourseDAO;
import org.SakaiDAO.SectionDAO;
import org.SakaiDaoInterfaces.IPersonDAO;
import org.SakaiServiceClients.IStudentService;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRED)
public class StudentService implements IStudentService {
	private IPersonDAO studentDAO;
	private SessionFactory sessionFactory;

	// private AssignmentDAO assignmentDAO;
	// private AssignmentStudentDAO assignmentStudentDAO;

	public StudentService() {
	}

	public StudentService(IPersonDAO studentDAO, CourseDAO courseDAO,
			SectionDAO sectionDAO, SessionFactory sessionFactory) {
		super();
		this.studentDAO = studentDAO;
		this.sessionFactory = sessionFactory;
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
