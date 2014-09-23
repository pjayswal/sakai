package org.sakai.services;

import java.util.List;

import org.sakai.commons.Assignment;
import org.sakai.commons.AssignmentStudent;
import org.sakai.commons.Section;
import org.sakai.commons.Student;
import org.sakai.commons.Teacher;
import org.sakai.daointerfaces.IAssignmentDAO;
import org.sakai.daointerfaces.IAssignmentStudentDAO;
import org.sakai.daointerfaces.IPersonDAO;
import org.sakai.daointerfaces.ISectionDAO;
import org.sakai.daointerfaces.ITeacherDAO;
import org.sakai.serviceclients.IFacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation=Propagation.REQUIRES_NEW)
public class FacultyService implements IFacultyService{
	@Autowired
	private ITeacherDAO facultyDAO;
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

	public List<AssignmentStudent> getAssignmentStudentList(long assignmentId) {
		Assignment assignment = assignmentDAO.get(assignmentId);
		return assignment.getAssignmentStudent();
	}

	public void UpdateAssignmnetStudent(AssignmentStudent as) {
		assignmentStudentDAO.update(as);
		
	}

	public AssignmentStudent getAssignmentStudent(long assignmentStudentId) {
		return assignmentStudentDAO.get(assignmentStudentId);
	}

	public Teacher getTeacher(long id) {
		return facultyDAO.get(id);
	}

}
