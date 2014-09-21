package org.SakaiDAO;

import java.util.List;

import org.SakaiCommons.AssignmentStudent;
import org.SakaiCommons.Person;
import org.SakaiCommons.Student;
import org.SakaiDaoInterfaces.IPersonDAO;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.MANDATORY)
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
	
	public List<AssignmentStudent> getAssignmentGradeList(long id){
		Query query = sessionFactory.getCurrentSession().createQuery("FROM AssignmentStudent a WHERE a.student.id=:id");
		query.setParameter("id", id);
		
		@SuppressWarnings("unchecked")
		List<AssignmentStudent> gradeList = query.list();
		return gradeList;
	}
}
