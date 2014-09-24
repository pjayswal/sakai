package org.sakai.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.sakai.commons.Assignment;
import org.sakai.commons.AssignmentStudent;
import org.sakai.daointerfaces.IAssignmentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation=Propagation.MANDATORY)
public class AssignmentDAO implements IAssignmentDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	public void create(Assignment a) {
		//sessionFactory.getCurrentSession().persist(a);
		sessionFactory.getCurrentSession().save(a);

	}

	public void update(Assignment a) {
		sessionFactory.getCurrentSession().saveOrUpdate(a);

	}

	public Assignment get(long id) {
		return (Assignment) sessionFactory.getCurrentSession().get(Assignment.class,	id);
	}

	public void delete(Assignment a) {
		sessionFactory.getCurrentSession().delete(a);

	}

	public Assignment load(long id) {
		return (Assignment) sessionFactory.getCurrentSession().load(Assignment.class, id);
	}

	public List<AssignmentStudent> listAssignmentStudent(long student_id, long section_id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
						"select asm FROM Assignment a join "
						+ "a.assignmentStudents asm WHERE a.section.id=? and asm.student.id=?");
		query.setParameter(0, section_id);
		query.setParameter(1, student_id);
		
		@SuppressWarnings("unchecked")
		List<AssignmentStudent> assignmentStudents = query.list();
		return assignmentStudents; 
		
	}

	public AssignmentStudent getAssignmentStudent(long student_id,
			long assignment_id) {
		Query query = sessionFactory.getCurrentSession().createQuery(
				"select asm FROM Assignment a join"
				+ "a.assignmentStudents asm WHERE a.id=? and asm.student.id=?");
		query.setParameter(0, assignment_id);
		query.setParameter(1, student_id);
		@SuppressWarnings("unchecked")
		List<AssignmentStudent> assignmentStudents = query.list();
		if(assignmentStudents.size()>0);
		return assignmentStudents.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<Assignment> getAssignmentList(long sectionId){
		Query query = sessionFactory.getCurrentSession().createQuery("FROM Assignment a where a.section.id="+sectionId);
		return  query.list();
	}
}
