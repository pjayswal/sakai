package org.sakai.daointerfaces;

import org.sakai.commons.Course;


public interface ICourseDAO {
	public void create(Course c);
	public void update(Course c);
	public Course get(long id);
	public void delete(Course c);
	public Course load(long id);
}
