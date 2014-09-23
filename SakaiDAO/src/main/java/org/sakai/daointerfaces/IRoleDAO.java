package org.sakai.daointerfaces;

import org.sakai.commons.Role;


public interface IRoleDAO {
	public void create(Role r);
	public void update(Role r);
	public Role get(long id);
	public void delete(Role p);
	public Role load(long id);
	
}
