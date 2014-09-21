package org.SakaiDAO;

import org.SakaiCommons.Assignment;
import org.SakaiDaoInterfaces.IAssignmentDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.MANDATORY)
public class AssignmentDAO implements IAssignmentDAO {
	
	private SessionFactory sessionFactory;
	
	@Autowired
	public AssignmentDAO(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}

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
