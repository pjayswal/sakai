package org.sakai.dao;

import org.hibernate.SessionFactory;
import org.sakai.commons.Course;
import org.sakai.daointerfaces.ICourseDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class CourseDAO implements ICourseDAO {
	
	
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void create(Course c) {
		sessionFactory.getCurrentSession().persist(c);

	}

	public void update(Course c) {
		sessionFactory.getCurrentSession().saveOrUpdate(c);

	}

	public Course get(long id) {
		return (Course) sessionFactory.getCurrentSession().get(Course.class,	id);
	}

	public void delete(Course c) {
		sessionFactory.getCurrentSession().delete(c);

	}

	public Course load(long id) {
		return (Course) sessionFactory.getCurrentSession().load(Course.class,id);
	}

}
