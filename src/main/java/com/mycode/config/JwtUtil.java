package com.mycode.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service("jwtTokenUtil")
public class JwtUtil {
	
	//*Nota: Rescatar SECRET de un archivo de configuración mas seguro..
	private static final String SECRET = "MyCodeSecret";
	//private static final int EXPIRATION_TIME = 864000000; // 10 dias
	//private static final String TOKEN_PREFIX = "Bearer";
	//private static final String HEADER_STRING = "Authorization";
	
	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}
	
	public Date extractExpiration(String token) {
		return extractClaim(token, Claims::getExpiration);
	}
	
	private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
		final Claims claims = extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
	}
	
	private Boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	public String generateToken(UserDetails userDetails) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(claims, userDetails.getUsername());
	}
	
	private String createToken(Map<String, Object> claims,String subject) {
		
		return Jwts.builder().setClaims(claims).setSubject(subject).
				setIssuedAt(new Date(System.currentTimeMillis())).
				setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10 )).
				signWith(SignatureAlgorithm.HS256, SECRET).compact();				
	
	}
	
	public Boolean validateToken(String token, UserDetails userDetails) {
		final String username = extractUsername(token);
		return ( username.equals(userDetails.getUsername()) && !isTokenExpired(token) );
	}
	
	
	
	
	
	
}
