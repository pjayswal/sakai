package org.SakaiDaoInterfaces;

import java.util.List;

import org.SakaiCommons.AssignmentStudent;
import org.SakaiCommons.Person;
import org.SakaiCommons.Student;

public interface IPersonDAO {
	public void create(Person p);
	public void update(Person p);
	public Person get(long id);
	public void delete(Person p);
	public Person load(long id);
	public List<AssignmentStudent> getAssignmentGradeList(long id);
}
