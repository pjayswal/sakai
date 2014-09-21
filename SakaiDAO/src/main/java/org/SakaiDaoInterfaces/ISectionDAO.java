package org.SakaiDaoInterfaces;


import org.SakaiCommons.Section;

public interface ISectionDAO {
	public void create(Section s);
	public void update(Section s);
	public Section get(long id);
	public void delete(Section s);
	public Section load(long id);
}
