package org.sakai.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.sakai.commons.AssignmentSolution;
import org.sakai.commons.Student;
import org.sakai.daointerfaces.IStudentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class StudentDAO implements IStudentDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	public void create(Student student) {
		sessionFactory.getCurrentSession().save(student);

	}

	public void update(Student student) {
		sessionFactory.getCurrentSession().saveOrUpdate(student);

	}

	public Student get(long id) {
		return (Student) sessionFactory.getCurrentSession().get(Student.class,id);
	}

	public void delete(Student student) {
		sessionFactory.getCurrentSession().delete(student);

	}

	public Student load(long id) {
		return (Student) sessionFactory.getCurrentSession().load(Student.class,id);
	}
	
	public List<AssignmentSolution> getAssignmentGradeList(long id){
		Query query = sessionFactory.getCurrentSession().createQuery("FROM AssignmentStudent a WHERE a.student.id=:id");
		query.setParameter("id", id);
		
		@SuppressWarnings("unchecked")
		List<AssignmentSolution> gradeList = query.list();
		return gradeList;
	}


	@SuppressWarnings("unchecked")
	public List<Student> getAll() {
		Query query = sessionFactory.getCurrentSession().createQuery("select s from Student s");
		return query.list();
		
	}
}
