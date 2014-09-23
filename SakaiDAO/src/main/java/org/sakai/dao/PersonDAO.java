package org.sakai.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.sakai.commons.AssignmentStudent;
import org.sakai.commons.Person;
import org.sakai.daointerfaces.IPersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class PersonDAO implements IPersonDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void create(Person p) {
		sessionFactory.getCurrentSession().saveOrUpdate(p.getUser());
		sessionFactory.getCurrentSession().persist(p);

	}

	public void update(Person p) {
		sessionFactory.getCurrentSession().saveOrUpdate(p);

	}

	public Person get(long id) {
		return (Person) sessionFactory.getCurrentSession().get(Person.class,id);
	}

	public void delete(Person p) {
		sessionFactory.getCurrentSession().delete(p);

	}

	public Person load(long id) {
		return (Person) sessionFactory.getCurrentSession().load(Person.class,id);
	}
	
	public List<AssignmentStudent> getAssignmentGradeList(long id){
		Query query = sessionFactory.getCurrentSession().createQuery("FROM AssignmentStudent a WHERE a.student.id=:id");
		query.setParameter("id", id);
		
		@SuppressWarnings("unchecked")
		List<AssignmentStudent> gradeList = query.list();
		return gradeList;
	}
	public Person getPerson(String username) {
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Person p WHERE p.user.username=:uname");
		query.setParameter("uname", username);
		@SuppressWarnings("unchecked")
		List<Person> persons = query.list();
		return persons.get(0);
	}
}
