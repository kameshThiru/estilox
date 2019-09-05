package com.estilox.application.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import com.estilox.application.model.JwtAuthenticationToken;

public class JwtAuthenticationTokenFilter extends AbstractAuthenticationProcessingFilter{

	public JwtAuthenticationTokenFilter() {
		super("/service/**");
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse arg1)
			throws AuthenticationException, IOException, ServletException {
		String header = httpServletRequest.getHeader("Authorization");
		String tokenPrefix = "Token_User_Service_Authenticate_Valid_User";
		if(header == null || !header.startsWith(tokenPrefix)) {
			throw new RuntimeException("JWT Token is missing.");
		}
		String authenticationToken = header.substring(tokenPrefix.length()+1);
		JwtAuthenticationToken jwtAuthenticationToken = new JwtAuthenticationToken(authenticationToken);
		return getAuthenticationManager().authenticate(jwtAuthenticationToken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authResult) throws IOException, ServletException {
		super.successfulAuthentication(request, response, chain, authResult);
		chain.doFilter(request, response);
	}

}
