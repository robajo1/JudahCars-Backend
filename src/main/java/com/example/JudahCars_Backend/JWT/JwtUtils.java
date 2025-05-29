package com.example.JudahCars_Backend.JWT;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    private final String SECRET_KEY = "017fb4123ce9fce82a1bf195489f870f132465c15ce62f75170134bea5e3e1dd4d0cf95a56ec1b7e72c097fc56d9993a53a67691d7da354169064e8032cf967c69c7edc2b671b283e86dcb57797418ec3827def27c4d43a67cf231ec0930aa92da63e516d9bb0ab8fe8dd265c0edfa34ba0d27302bf8ec0c9d2d72cfeb6660f0"; // Change this to something secure

    public String generateToken(String email) {
        // 24 hours
        long EXPIRATION = 86400000;
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }

    public String extractEmail(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
            return true;
        } catch (JwtException ex) {
            return false;
        }
    }
}