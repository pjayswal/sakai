package org.sakai.dao;

import org.hibernate.SessionFactory;
import org.sakai.commons.UserCredential;
import org.sakai.daointerfaces.IUserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class UserDAO implements IUserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void create(UserCredential u) {
		sessionFactory.getCurrentSession().save(u);

	}

	public UserCredential get(long id) {
		return (UserCredential) sessionFactory.getCurrentSession().get(UserCredential.class, id);
	}

	public void update(UserCredential u) {
		sessionFactory.getCurrentSession().saveOrUpdate(u);

	}

	public void delete(UserCredential u) {
		sessionFactory.getCurrentSession().delete(u);

	}

	public UserCredential load(long id) {
		return (UserCredential) sessionFactory.getCurrentSession().load(UserCredential.class, id);
	}

}
