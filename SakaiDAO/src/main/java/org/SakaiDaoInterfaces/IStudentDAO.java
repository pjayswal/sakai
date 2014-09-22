package org.SakaiDaoInterfaces;

import java.util.List;

import org.SakaiCommons.AssignmentStudent;
import org.SakaiCommons.Student;

public interface IStudentDAO {
	public void create(Student p);
	public void update(Student p);
	public Student get(long id);
	public void delete(Student p);
	public Student load(long id);
	public List<AssignmentStudent> getAssignmentGradeList(long id);
}
