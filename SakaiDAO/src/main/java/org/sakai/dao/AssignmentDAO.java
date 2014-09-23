package org.sakai.dao;

import org.hibernate.SessionFactory;
import org.sakai.commons.Assignment;
import org.sakai.daointerfaces.IAssignmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class AssignmentDAO implements IAssignmentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void create(Assignment a) {
		sessionFactory.getCurrentSession().persist(a);

	}

	public void update(Assignment a) {
		sessionFactory.getCurrentSession().saveOrUpdate(a);

	}

	public Assignment get(long id) {
		return (Assignment) sessionFactory.getCurrentSession().get(Assignment.class,	id);
	}

	public void delete(Assignment a) {
		sessionFactory.getCurrentSession().delete(a);

	}

	public Assignment load(long id) {
		return (Assignment) sessionFactory.getCurrentSession().load(Assignment.class, id);
	}

}
