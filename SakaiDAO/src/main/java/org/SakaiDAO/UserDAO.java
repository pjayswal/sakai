package org.SakaiDAO;

import org.SakaiCommons.User;
import org.SakaiDaoInterfaces.IUserDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class UserDAO implements IUserDAO {

	private SessionFactory sessionFactory;
	
	@Autowired
	public UserDAO(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	public void create(User u) {
		sessionFactory.getCurrentSession().persist(u);

	}

	public User get(long id) {
		return (User) sessionFactory.getCurrentSession().get(User.class, id);
	}

	public void update(User u) {
		sessionFactory.getCurrentSession().saveOrUpdate(u);

	}

	public void delete(User u) {
		sessionFactory.getCurrentSession().delete(u);

	}

	public User load(long id) {
		return (User) sessionFactory.getCurrentSession().load(User.class, id);
	}

}
