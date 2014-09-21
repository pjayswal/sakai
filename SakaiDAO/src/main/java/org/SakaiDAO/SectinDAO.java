package org.SakaiDAO;

import org.SakaiCommons.Section;
import org.SakaiDaoInterfaces.ISectionDAO;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class SectinDAO implements ISectionDAO {
	private SessionFactory sessionFactory;
	
	@Autowired
	public SectinDAO(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;
	}
	public void create(Section s) {
		sessionFactory.getCurrentSession().persist(s);

	}

	public void update(Section s) {
		sessionFactory.getCurrentSession().saveOrUpdate(s);

	}

	public Section get(long id) {
		return (Section) sessionFactory.getCurrentSession().get(Section.class,	id);
	}

	public void delete(Section s) {
		sessionFactory.getCurrentSession().delete(s);

	}

	public Section load(long id) {
		return (Section) sessionFactory.getCurrentSession().load(Section.class,id);
	}

}
