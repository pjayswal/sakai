package org.sakai.dao;



import org.hibernate.SessionFactory;
import org.sakai.commons.Role;
import org.sakai.daointerfaces.IRoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class RoleDAO implements IRoleDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void create(Role r) {
		sessionFactory.getCurrentSession().save(r);
		
	}

	public void update(Role r) {
		sessionFactory.getCurrentSession().saveOrUpdate(r);
		
	}

	public Role get(long id) {
		return (Role) sessionFactory.getCurrentSession().get(Role.class,	id);
	}

	public void delete(Role p) {
		sessionFactory.getCurrentSession().delete(p);
		
	}

	public Role load(long id) {
		return (Role) sessionFactory.getCurrentSession().get(Role.class,	id);
	}

}
