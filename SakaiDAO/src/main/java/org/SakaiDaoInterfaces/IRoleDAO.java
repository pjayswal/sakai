package org.SakaiDaoInterfaces;

import org.SakaiCommons.Role;


public interface IRoleDAO {
	public void create(Role r);
	public void update(Role r);
	public Role get(long id);
	public void delete(Role p);
	public Role load(long id);
	
}
