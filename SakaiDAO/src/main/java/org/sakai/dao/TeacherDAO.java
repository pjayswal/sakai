package org.sakai.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.sakai.commons.Teacher;
import org.sakai.daointerfaces.ITeacherDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class TeacherDAO implements ITeacherDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void create(Teacher teacher) {
		sessionFactory.getCurrentSession().persist(teacher);
		sessionFactory.getCurrentSession().flush();

	}

	public void update(Teacher student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);
		sessionFactory.getCurrentSession().flush();
	}

	public Teacher get(long id) {
		return (Teacher) sessionFactory.getCurrentSession().get(Teacher.class,id);
	}

	public void delete(Teacher student) {
		sessionFactory.getCurrentSession().delete(student);
		sessionFactory.getCurrentSession().flush();
	}

	public Teacher load(long id) {
		return (Teacher) sessionFactory.getCurrentSession().load(Teacher.class,id);
	}


	@SuppressWarnings("unchecked")
	public List<Teacher> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("select t from Teacher t");
		return query.list();
	}

}
