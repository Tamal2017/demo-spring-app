package com.example.demospringapp.service;

import com.example.demospringapp.model.MyUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

    private final String jwtSecret = "4261656C6E672364261656C64756E674261656C64756E674261656C64756E67";
    private final int jwtExpirationMs = 60 * 10 * 1000; // 10 min

    public String generateJwtToken(MyUser myUser) {
        Map<String, Object> clams = new HashMap<>();
        return Jwts.builder()
                .claims(clams)
                .subject(myUser.getUsername())
                .issuedAt(new Date()).expiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(generateSigningKey(jwtSecret))
                .compact();
    }

    private SecretKey generateSigningKey(String jwtSecret) {
        byte[] keyBytes = Decoders.BASE64.decode(jwtSecret);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private SecretKey generateSigningKey() {
        return Jwts.SIG.HS256.key().build();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
        final Claims claims = extractAllClaims(token);
        return claimResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(generateSigningKey(jwtSecret))
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public boolean validateToken(String token, UserDetails userDetails) {
        String username = extractUsername(token);
        return username.equals(userDetails.getUsername()) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractExpirationDate(token).before(new Date());
    }

    private Date extractExpirationDate(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}
