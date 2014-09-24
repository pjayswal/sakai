package org.sakai.daointerfaces;

import java.util.List;

import org.sakai.commons.AssignmentSolution;
import org.sakai.commons.Student;

public interface IStudentDAO {
	public void create(Student p);
	public void update(Student p);
	public Student get(long id);
	public void delete(Student p);
	public Student load(long id);
	public List<AssignmentSolution> getAssignmentGradeList(long id);
	public List<Student> getAll();
	
}
