package com.rso.microservice.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@Service
public class JwtService {

	String secret = "asdfSFS34wfsdfsdfSDSD32dfsddDDerQSNCK34SOWEK5354fdgdf4";

	Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(secret), SignatureAlgorithm.HS256.getJcaName());

	public String createNewJwtToken(String email) {
		return Jwts.builder()
				.claim("email", email)
				.setSubject("user")
				.setId(UUID.randomUUID().toString())
				.setIssuedAt(new Date())
				.setExpiration(Date.from(Instant.now().plus(30, ChronoUnit.HOURS)))
				.signWith(SignatureAlgorithm.HS256, hmacKey)
				.compact();
	}

	public String parseJwtToken(String jwt) {
		Jws<Claims> claims = Jwts.parser()
				.setSigningKey(hmacKey)
				.parseClaimsJws(jwt);

		return (String) claims.getBody().get("email");
	}

}
