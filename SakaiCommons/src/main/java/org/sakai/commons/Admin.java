package org.sakai.commons;

import javax.persistence.Entity;

@Entity
public class Admin extends Person {
	public Admin(String name, String phone, String email,Address address) {
		super(name, phone, email, address);
	}
}
