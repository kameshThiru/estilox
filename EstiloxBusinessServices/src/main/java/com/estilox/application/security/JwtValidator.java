package com.estilox.application.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

@Component
public class JwtValidator {
	
	@Value("${jwt.token.key}")
	private String secret;

	public JwtUser validate(String token) {
		JwtUser jwtUser = null;
		try {
			Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
			jwtUser = new JwtUser();
			jwtUser.setEmailId(claims.getSubject());
			jwtUser.setId(Long.parseLong((String)claims.get("userId")));
			jwtUser.setRole("user");
			
		} catch (Exception e) {
			System.out.println(e);
		}
		return jwtUser;
	}
}
