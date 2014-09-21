package org.SakaiServices;

import java.util.List;

import org.SakaiCommons.Assignment;
import org.SakaiCommons.AssignmentStudent;
import org.SakaiCommons.Section;
import org.SakaiCommons.Student;
import org.SakaiCommons.Teacher;
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
	
	@Autowired
	public FacultyService(IPersonDAO facultyDAO, SectionDAO sectionDAO,
			AssignmentStudentDAO assignmentStudentDAO) {
		super();
		this.facultyDAO = facultyDAO;
		this.sectionDAO = sectionDAO;
		this.assignmentStudentDAO = assignmentStudentDAO;
	}

	public List<Section> getSecctions(long id) {
		Teacher teacher = (Teacher)facultyDAO.get(id);
		return teacher.getSections();
	}

	public List<Student> getStudents(Section section) {
		return section.getStudents();
	}

	public void CreateAssignment(Section section, Assignment assignment) {
		// TODO Auto-generated method stub
		section.addAssignment(assignment);
		sectionDAO.update(section);
	}

	public List<Assignment> getAssignments(Section section) {
		return section.getAssignments();
	}

	public List<AssignmentStudent> getAssignmentStudent(Assignment assignment) {
		// TODO Auto-generated method stub
		return assignment.getAssignmentStudent();
	}

	public void UpdateAssignmnetStudent(AssignmentStudent as) {
		assignmentStudentDAO.update(as);		
	}

}
