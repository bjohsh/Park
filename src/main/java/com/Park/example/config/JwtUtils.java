package com.Park.example.config;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.DatatypeConverter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import com.Park.example.domain.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class JwtUtils {

	private static final String jwtSecret = "lcomputerstudyexample"; //�썝�븯�뒗 �떆�겕由욱궎濡� �닔�젙
	
	private static final int jwtExpirationMs = 864000;
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//jwt �깮�꽦 硫붿냼�뱶
		public String generateJwtToken(Authentication authentication) {

			User user = (User) authentication.getPrincipal();
			//builder �뙣�꽩�쓣 �씠�슜�븯�뿬 jwt�깮�꽦
			return Jwts.builder()
					.setSubject((user.getUsername()))
					.setIssuedAt(new Date())
					.setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
					.signWith(SignatureAlgorithm.HS512, jwtSecret)
					.compact();
		}
		
		//�넗�겙�쓣 �씠�슜�븯�뿬 �쑀�� �븘�씠�뵒 遺덈윭�삤�뒗 硫붿냼�뱶
		public String getUserNameFromJwtToken(String token) {
			return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
		}
		
		 private static Claims getClaimsFormToken(String token) {
	        return (Claims) Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(jwtSecret))
	        		.parseClaimsJws(token).getBody();
	    }
		 
		 public static String getUserEmailFromToken(String token) {
		        Claims claims = getClaimsFormToken(token);
		        Map<String, Object> map = new HashMap<>(claims);
		        String username = (String) map.get("sub");
		        
		        return username;
		    }

	
	//jwt �쑀�슚�꽦 寃��궗 硫붿냼�뱶
	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}

		return false;
	}
	
	
}