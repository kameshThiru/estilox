package com.estilox.application.tokens;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.estilox.application.security.JwtGenerator;
import com.estilox.application.security.JwtUser;

@RestController
@RequestMapping("/token")
public class TokenController {

	private JwtGenerator jwtGenerator;
	
	public TokenController(JwtGenerator jwtGenerator) {
		this.jwtGenerator = jwtGenerator;
	}
	
	@PostMapping(value="/generator")
	public String generateToken(@RequestBody JwtUser jwtUser) {
		return jwtGenerator.generate(jwtUser);
	}
	
}


