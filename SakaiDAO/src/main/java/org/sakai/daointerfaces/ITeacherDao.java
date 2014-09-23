package org.sakai.daointerfaces;

import java.util.List;

import org.sakai.commons.AssignmentStudent;
import org.sakai.commons.Teacher;

public interface ITeacherDao {
	public void create(Teacher p);
	public void update(Teacher p);
	public Teacher get(long id);
	public void delete(Teacher p);
	public Teacher load(long id);
	public List<Teacher> getAll();
}
