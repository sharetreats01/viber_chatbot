package com.sharetreats01.viber_chatbot.interaction.util;

import com.sharetreats01.viber_chatbot.interaction.dto.JwtAttributes;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private Long expiration;

    public String generateToken(JwtAttributes attributes) {
        long currentTimeMillis = System.currentTimeMillis();
        return "Bearer " + Jwts.builder()
                .setSubject("Share Treats Viber Chatbot Jwt Token")
                .setAudience("Share Treats")
                .setAudience("Share Treats User")
                .setIssuedAt(new Date(currentTimeMillis))
                .claim("id", attributes.getId())
                .claim("name", attributes.getName())
                .claim("country", attributes.getCountry())
                .claim("language", attributes.getLanguage())
                .setExpiration(new Date(currentTimeMillis + this.expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }
}
