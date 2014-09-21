package org.SakaiDAO;

import org.SakaiCommons.AssignmentStudent;
import org.SakaiDaoInterfaces.IAssignmentStudentDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class AssignmentStudentDAO implements IAssignmentStudentDAO{
	private SessionFactory sessionFactory;
	
	@Autowired
	public AssignmentStudentDAO(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	
	public void create(AssignmentStudent as) {
		sessionFactory.getCurrentSession().persist(as);
		
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
