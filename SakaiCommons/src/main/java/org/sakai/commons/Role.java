package org.sakai.commons;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Role {
     
    @Id
    @GeneratedValue
    private long id;
     
    private String role;
     
    public Role() {
		// TODO Auto-generated constructor stub
	}
    public Role(String role) {
		super();
		this.role = role;
	}

	public long getId() {
        return id;
    }
 
    public void setId(Integer id) {
        this.id = id;
    }
 
    public String getRole() {
        return role;
    }
 
    public void setRole(String role) {
        this.role = role;
    }
     
}
