package org.SakaiDaoInterfaces;

import org.SakaiCommons.User;


public interface IUserDAO {
	public void create(User u);
	public User get(long id);
	public void update(User u);
	public void delete(User u);
	public User load(long id);
	
}
