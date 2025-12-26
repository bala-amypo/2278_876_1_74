package com.example.demo.security;

import io.jsonwebtoken.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    private String secret;
    private int expiration;

    public JwtUtil(String secret, int expiration) {
        this.secret = secret;
        this.expiration = expiration;
    }

    // Used by tests
    public String generateToken(com.example.demo.model.User user) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("userId", user.getId());
        claims.put("email", user.getEmail());
        claims.put("role", user.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getEmail())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public String getEmailFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();

        return claims.get("email", String.class);
    }
}
