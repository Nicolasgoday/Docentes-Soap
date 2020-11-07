package com.docentes.util;

import java.util.List;

import javax.xml.bind.DatatypeConverter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

public class Autentificador {
	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer ";
	private final String SECRET = "YmY5ZmJkZWM0MjA2YTY5YTE4YzgzZjFlMzZmNTIzYmJjNzBmZDdkNjJlMGRhOGE2MjZiZTYxZjFlMDFhMzc2Y2E3NDUyNjkyNDM5MTQ2MGQ2ZTNlMjJlZTUwMzgyNzA2MWE2Yjg5OTgyOGQ2NjNhZWU0ZTkxYjdjOTg4ZWI2ZWQ=";

	
	public boolean autentificar(String rolRequerido, String bearer)  {
		if (validarToken(bearer) && this.existeJWTToken(bearer) && this.esRol(rolRequerido, bearer))
			return true;
		
		return false;
	}
	
	public boolean validarToken(String bearer) {		
		return bearer.startsWith(PREFIX);			
	}
	
	
	public boolean existeJWTToken(String bearer) {
		if (bearer == null || !bearer.contains(PREFIX))
			return false;
		return true;
	}
	public boolean esRol(String rolRequerido, String bearer) {
		String jwtToken = bearer.replace(PREFIX, "");
		
		Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET)).parseClaimsJws(jwtToken).getBody();
							
		if (claims.get("authorities") != null) {
			System.out.print(claims.getSubject());
			return true;
		}
		
		return false;
	}
		
}
