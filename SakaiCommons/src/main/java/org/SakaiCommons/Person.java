package org.SakaiCommons;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
public abstract class Person {
	@Id @GeneratedValue
	private long id;
	
	@NotNull
	private String name;
	
	@Size(min=10,max=10)
	@Pattern(regexp="(^$|[0-9]{10})")
	private String phone;
	
	@Email(message="please pass a valid email addess")
	private String email;
	
	@Embedded
	private Address address;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn
	private User user;
	
	public Person() {
	}
	
	public Person(String name, String phone, String email,Address address) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	
}
