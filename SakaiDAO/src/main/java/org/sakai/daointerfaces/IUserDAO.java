package org.sakai.daointerfaces;

import org.sakai.commons.UserCredential;


public interface IUserDAO {
	public void create(UserCredential u);
	public UserCredential get(long id);
	public void update(UserCredential u);
	public void delete(UserCredential u);
	public UserCredential load(long id);
	
}
