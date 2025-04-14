package com.example.backend.security;


import com.example.backend.entity.users;
import io.jsonwebtoken.*;

import org.springframework.stereotype.Component;


import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class jwt {
    private static final String secretKey = "MySuperSecretKey11a1b2c3d4f5h6j7k98123456789!";

    public String generateToken(users user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("authorities", user.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getEmail())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60)) // 1 hour expiry
                .signWith(SignatureAlgorithm.HS256, secretKey.getBytes())
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token).getBody().getSubject();
    }

    public String extractRole(String token) {
        return (String) Jwts.parser().setSigningKey(secretKey.getBytes()).parseClaimsJws(token).getBody().get("role");
    }

    public boolean validateToken(String token) {
        return extractUsername(token) != null;
    }



}
