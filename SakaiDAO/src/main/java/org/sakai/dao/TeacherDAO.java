package org.sakai.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.sakai.commons.AssignmentStudent;
import org.sakai.commons.Teacher;
import org.sakai.commons.Teacher;
import org.sakai.daointerfaces.ITeacherDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class TeacherDAO implements ITeacherDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void create(Teacher teacher) {
		sessionFactory.getCurrentSession().persist(teacher);

	}

	public void update(Teacher student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);

	}

	public Teacher get(long id) {
		return (Teacher) sessionFactory.getCurrentSession().get(Teacher.class,id);
	}

	public void delete(Teacher student) {
		sessionFactory.getCurrentSession().delete(student);

	}

	public Teacher load(long id) {
		return (Teacher) sessionFactory.getCurrentSession().load(Teacher.class,id);
	}


	public List<Teacher> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("select t from Teacher t");
		return query.list();
	}

}