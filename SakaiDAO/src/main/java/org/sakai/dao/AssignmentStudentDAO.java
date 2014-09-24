package org.sakai.dao;

import org.hibernate.SessionFactory;
import org.sakai.commons.AssignmentStudent;
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
	
	
	public void create(AssignmentStudent as) {
		sessionFactory.getCurrentSession().save(as);
		
	}

	public void update(AssignmentStudent as) {
		sessionFactory.getCurrentSession().saveOrUpdate(as);
		
	}

	public AssignmentStudent get(long id) {
		return (AssignmentStudent) sessionFactory.getCurrentSession().get(AssignmentStudent.class,	id);
	}

	public void delete(AssignmentStudent as) {
		sessionFactory.getCurrentSession().delete(as);
		
	}

	public AssignmentStudent load(long id) {
		return (AssignmentStudent) sessionFactory.getCurrentSession().load(AssignmentStudent.class,id);
	}

}
