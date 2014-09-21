package org.SakaiDaoInterfaces;

import org.SakaiCommons.Person;

public interface IPersonDAO {
	public void create(Person p);
	public void update(Person p);
	public Person get(long id);
	public void delete(Person p);
	public Person load(long id);

}
