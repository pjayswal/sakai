package org.sakai.daointerfaces;


import org.sakai.commons.Section;

public interface ISectionDAO {
	public void create(Section s);
	public void update(Section s);
	public Section get(long id);
	public void delete(Section s);
	public Section load(long id);
}
