package com.estilox.application.security;

import java.io.Serializable;

public class JwtUser implements Serializable{
	/**
	 * @author Kamesh
	 */
	private static final long serialVersionUID = 1L;
	private String emailId;
	private String password;
	private long id;
	private String role;
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
