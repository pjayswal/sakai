package org.sakai.serviceclients;

import org.sakai.commons.Person;

public interface ILoginService {
	public Person getUser(String username, String password);
}
