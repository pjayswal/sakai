package org.SakaiServices;

import java.util.List;

import org.SakaiCommons.Assignment;
import org.SakaiCommons.AssignmentStudent;
import org.SakaiCommons.Section;
import org.SakaiCommons.Student;
import org.SakaiCommons.Teacher;

import org.SakaiDaoInterfaces.IAssignmentDAO;
import org.SakaiDaoInterfaces.IAssignmentStudentDAO;
import org.SakaiDaoInterfaces.IPersonDAO;
import org.SakaiDaoInterfaces.ISectionDAO;
import org.SakaiServiceClients.IFacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class FacultyService implements IFacultyService{
	@Autowired
	private IPersonDAO facultyDAO;
	@Autowired
	private ISectionDAO sectionDAO;
	@Autowired
	private IAssignmentStudentDAO assignmentStudentDAO;
	@Autowired
	private IAssignmentDAO assignmentDAO;
	
	public FacultyService() {
		// TODO Auto-generated constructor stub
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
