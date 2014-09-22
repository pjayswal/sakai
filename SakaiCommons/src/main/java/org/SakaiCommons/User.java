package org.SakaiCommons;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Pattern;

@Entity
public class User {
	
	@Id
	@Pattern(regexp="^[a-z0-9_-]{3,15}$")
	private String username;
	@Pattern(regexp="^[a-z0-9_-]{3,15}$")
	private String password;
	
	@OneToMany(cascade=CascadeType.ALL)
    @JoinTable(name="user_roles",
        joinColumns = {@JoinColumn(name="user_id", referencedColumnName="id")},
        inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")}
    )
	private Set<Role> userRoles = new HashSet<Role>();
	
	
	private boolean enabled;

	@OneToOne
	private Person person;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = true;
	}
	

	
	public void setPerson(Person person) {
		this.person = person;
	}

	private void addRole(Role role){
		this.userRoles.add(role);
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<Role> userRoles) {
		this.userRoles = userRoles;
	}

	public Person getPerson() {
		return person;
	}
	
	
}
