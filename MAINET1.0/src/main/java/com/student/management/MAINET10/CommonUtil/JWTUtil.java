package com.student.management.MAINET10.CommonUtil;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JWTUtil {

    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public String generateJWTToken(String userName){
        return Jwts.builder()
                .setSubject(userName)
                .setIssuedAt(new Date())
                .signWith(key)
                .compact();
    }

    public String validateAndExtractUserName(String token){
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}