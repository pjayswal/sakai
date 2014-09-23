package org.sakai.daointerfaces;

import java.util.List;

import org.sakai.commons.AssignmentStudent;
import org.sakai.commons.Person;

public interface IPersonDAO {
	public void create(Person p);
	public void update(Person p);
	public Person get(long id);
	public void delete(Person p);
	public Person load(long id);
	public List<AssignmentStudent> getAssignmentGradeList(long id);
	public Person getPerson(String username);
}
