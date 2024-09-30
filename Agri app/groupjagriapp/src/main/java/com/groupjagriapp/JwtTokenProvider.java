package com.groupjagriapp.security;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;
import java.util.Date;
@Component
public class JwtTokenProvider {
private String secret = "your_secret_key";
private long expiration = 86400000; // 1 day
public String generateToken(String username) {
    return Jwts.builder()
    .setSubject(username)
    .setIssuedAt(new Date())
    .setExpiration(new Date(System.currentTimeMillis() + expiration))
    .signWith(SignatureAlgorithm.HS512, secret)
    .compact();
    }
    public boolean validateToken(String token) {
    try {
    Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
    return true;
    } catch (JwtException | IllegalArgumentException e) {
    return false;
    }
    }
    public String getUsernameFromToken(String token) {
    return
    Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }
    }