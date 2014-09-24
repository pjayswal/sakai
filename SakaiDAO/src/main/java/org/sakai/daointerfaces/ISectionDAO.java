package org.sakai.daointerfaces;


import java.util.List;

import org.sakai.commons.Section;

public interface ISectionDAO {
	public void create(Section s);
	public void update(Section s);
	public Section get(long id);
	public void delete(Section s);
	public Section load(long id);
	public List<Section> getAll(long courseId);
}
