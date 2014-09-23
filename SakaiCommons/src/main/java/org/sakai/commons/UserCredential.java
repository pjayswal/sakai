package org.sakai.commons;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.Pattern;

@Entity
public class UserCredential {
	
	@Id
	//@Pattern(regexp="^[a-z0-9_-]{3,15}$")
	private String username;
	//@Pattern(regexp="^[a-z0-9_-]{3,15}$")
	private String password;
	
	@ManyToMany
    @JoinTable(name="user_roles",
        joinColumns = {@JoinColumn(name="user_id", referencedColumnName="username")},
        inverseJoinColumns = {@JoinColumn(name="role_id", referencedColumnName="id")}
    )
	private Set<Role> userRoles = new HashSet<Role>();
	
	
	private boolean enabled;

	
	public UserCredential() {
		// TODO Auto-generated constructor stub
	}
	
	public UserCredential(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = true;
	}
	

	public void addUserRoles(Role role){
		userRoles.add(role);
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

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password
				+ ", userRoles=" + userRoles + ", enabled=" + enabled + "]";
	}
	

	
	
	
}
