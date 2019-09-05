package com.estilox.application.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class JwtUserDetails implements UserDetails{

	/**
	 * @author Kamesh
	 */
	private static final long serialVersionUID = 1L;
	private long id;
	private String userName;
	private String token;
	private List<GrantedAuthority> grantedAuthorities;
	public JwtUserDetails(long id, String userName, String token, List<GrantedAuthority> grantedAuthorities) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.userName = userName;
		this.token = token;
		this.grantedAuthorities = grantedAuthorities;
	}
	public long getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public String getToken() {
		return token;
	}
	public List<GrantedAuthority> getGrantedAuthorities() {
		return grantedAuthorities;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return grantedAuthorities;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return userName;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
