package org.SakaiServiceClients;

import org.SakaiCommons.Person;

public interface ILoginService {
	public Person getUser(String username, String password);
}
