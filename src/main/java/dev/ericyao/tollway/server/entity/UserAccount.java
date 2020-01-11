package dev.ericyao.tollway.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "user_account")
public class UserAccount {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_account_gen")
	@SequenceGenerator(name = "user_account_gen", sequenceName = "user_account_seq", allocationSize = 1)
	@Column(name = "user_id")
	private long userId;
	
	@NotNull
	@Column(name = "username", unique = true)
	private String username;
	
	@Email
	@NotNull
	@Column(unique = true)
	private String email;
	
	private String password;
	private String role;
	private boolean enabled = true;
	
	public UserAccount() {
		
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String userName) {
		this.username = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "UserAccount [userId=" + userId + ", username=" + username + ", email=" + email + ", password="
				+ password + ", role=" + role + ", enabled=" + enabled + "]";
	}
	
	
}
