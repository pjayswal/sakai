package org.SakaiDAO;

import org.SakaiCommons.Person;
import org.SakaiDaoInterfaces.IPersonDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class PersonDAO implements IPersonDAO {
	private SessionFactory sessionFactory;
	
	@Autowired
	public PersonDAO(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	public void create(Person p) {
		sessionFactory.getCurrentSession().persist(p);

	}

	public void update(Person p) {
		sessionFactory.getCurrentSession().saveOrUpdate(p);

	}

	public Person get(long id) {
		return (Person) sessionFactory.getCurrentSession().get(Person.class,	id);
	}

	public void delete(Person p) {
		sessionFactory.getCurrentSession().delete(p);

	}

	public Person load(long id) {
		return (Person) sessionFactory.getCurrentSession().load(Person.class,id);
	}

}
