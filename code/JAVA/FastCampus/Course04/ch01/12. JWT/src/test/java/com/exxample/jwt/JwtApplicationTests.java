package com.exxample.jwt;

import com.exxample.jwt.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashMap;

@SpringBootTest
class JwtApplicationTests {

	@Autowired
	private JwtService jwtService;

	@Test
	void contextLoads() {
	}

	@Test
	void tokenCreate(){
		var claims = new HashMap<String, Object>();
		claims.put("user_id", 923);

		var expiredAt = LocalDateTime.now().plusSeconds(30);
		//var expiredAt = LocalDateTime.now().plusMinutes(10);
		var jwtToken = jwtService.create(claims, expiredAt);
		System.out.println(jwtToken);
	}
	@Test
	void tokenValidation(){
		var token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo5MjMsImV4cCI6MTcxNTk0NDkxM30.wkGD7Qul26xgzIu0qSvCp6pEBOTtBDud_BdSYwC94kg";
		jwtService.validation(token);
	}

}
