package org.SakaiServices;

import java.util.List;

import org.SakaiCommons.Assignment;
import org.SakaiCommons.AssignmentStudent;
import org.SakaiCommons.Section;
import org.SakaiCommons.Student;
import org.SakaiCommons.Teacher;
import org.SakaiDAO.AssignmentDAO;
import org.SakaiDAO.AssignmentStudentDAO;
import org.SakaiDAO.SectionDAO;
import org.SakaiDaoInterfaces.IPersonDAO;
import org.SakaiServiceClients.IFacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class FacultyService implements IFacultyService{
	private IPersonDAO facultyDAO;
	private SectionDAO sectionDAO;
	private AssignmentStudentDAO assignmentStudentDAO;
	private AssignmentDAO assignmentDAO;
	
	@Autowired
	public FacultyService(IPersonDAO facultyDAO, SectionDAO sectionDAO,
			AssignmentStudentDAO assignmentStudentDAO,
			AssignmentDAO assignmentDAO) {
		super();
		this.facultyDAO = facultyDAO;
		this.sectionDAO = sectionDAO;
		this.assignmentStudentDAO = assignmentStudentDAO;
		this.assignmentDAO = assignmentDAO;
	}

	public List<Section> getSecctions(long id) {
		Teacher teacher = (Teacher)facultyDAO.get(id);
		return teacher.getSections();
	}

	

	public List<Student> getStudents(long sectionId) {
		Section section = sectionDAO.get(sectionId);
		return section.getStudents();
	}

	public void CreateAssignment(long sectionId, Assignment assignment) {
		Section section = sectionDAO.get(sectionId);
		section.addAssignment(assignment);
		sectionDAO.update(section);
	}

	public List<Assignment> getAssignments(long sectionId) {
		Section section = sectionDAO.get(sectionId);
		return section.getAssignments();
	}

	public List<AssignmentStudent> getAssignmentStudent(long assignmentId) {
		Assignment assignment = assignmentDAO.get(assignmentId);
		return assignment.getAssignmentStudent();
	}

	public void UpdateAssignmnetStudent(AssignmentStudent as) {
		assignmentStudentDAO.update(as);		
	}

}
