package org.sakai.dao;

import org.hibernate.SessionFactory;
import org.sakai.commons.AssignmentSolution;
import org.sakai.daointerfaces.IAssignmentStudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class AssignmentStudentDAO implements IAssignmentStudentDAO{
	@Autowired
	private SessionFactory sessionFactory;
	
	
	public void create(AssignmentSolution as) {
		sessionFactory.getCurrentSession().save(as);
		
	}

	public void update(AssignmentSolution as) {
		sessionFactory.getCurrentSession().saveOrUpdate(as);
		
	}

	public AssignmentSolution get(long id) {
		return (AssignmentSolution) sessionFactory.getCurrentSession().get(AssignmentSolution.class,	id);
	}

	public void delete(AssignmentSolution as) {
		sessionFactory.getCurrentSession().delete(as);
		
	}

	public AssignmentSolution load(long id) {
		return (AssignmentSolution) sessionFactory.getCurrentSession().load(AssignmentSolution.class,id);
	}

}
