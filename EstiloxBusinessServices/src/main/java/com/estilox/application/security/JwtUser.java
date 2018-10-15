package com.estilox.application.security;

import java.io.Serializable;

public class JwtUser implements Serializable{
	/**
	 * @author Kamesh
	 */
	private static final long serialVersionUID = 1L;
	private String userName;
	private long id;
	private String role;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
