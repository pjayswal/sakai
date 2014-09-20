package org.SakaiCommons;

public abstract class Person {
	private int id;
	private String name;
	private String phone;
	private String email;
	private Address address;
	
	public Person() {
	}
	
	public Person(String name, String phone, String email,Address address) {
		super();
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
	}

	
	public int getId() {
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
	
}
