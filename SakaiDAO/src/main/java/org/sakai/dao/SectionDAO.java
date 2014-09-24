package org.sakai.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.sakai.commons.Course;
import org.sakai.commons.Section;
import org.sakai.daointerfaces.ISectionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public class SectionDAO implements ISectionDAO {
	@Autowired
	private SessionFactory sessionFactory;

	public void create(Section s) {
		sessionFactory.getCurrentSession().persist(s);

	}

	public void update(Section s) {
		sessionFactory.getCurrentSession().saveOrUpdate(s);

	}

	public Section get(long id) {
		return (Section) sessionFactory.getCurrentSession().get(Section.class,
				id);
	}

	public void delete(Section s) {
		sessionFactory.getCurrentSession().delete(s);

	}

	public Section load(long id) {
		return (Section) sessionFactory.getCurrentSession().load(Section.class,
				id);
	}

	@SuppressWarnings("unchecked")
	public List<Section> getAll(long courseId) {

		Query query = sessionFactory.getCurrentSession().createQuery(
				"select s from Section s where s.course.id=? ");
		query.setParameter(0, courseId);
		return query.list();

	}

}
