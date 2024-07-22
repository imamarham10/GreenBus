package com.greenbus.GreenBus.service.impl;

import com.greenbus.GreenBus.data.model.entities.User;
import com.greenbus.GreenBus.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtServiceImpl implements JwtService {

    public String generateAccessToken(User user){
        return Jwts.builder().subject(user.getUsername()).issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 3 * 60 *60 * 1000))
                .signWith(getSignInKey())
                .compact();
    }

    @Override
    public String generateRefreshToken(User user) {
        return Jwts.builder().subject(user.getUsername()).issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 6 * 60 * 60 * 1000)).signWith(getSignInKey())
                .compact();
    }

    private SecretKey getSignInKey(){
        String SECRET_KEY = "6f04aac775c96e1fe128fb77ca897a6fa7a012b0254503f825f56f355be78a6f";
        byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parser().verifyWith(getSignInKey()).build().parseSignedClaims(token).getPayload();
    }

    	public <T> T extractClaim(String token, Function<Claims, T> resolver) {
		Claims claims = extractAllClaims(token);
		return resolver.apply(claims);
	}

	public String extractUsername(String token) {
		return extractClaim(token, Claims::getSubject);
	}

    public boolean isValid(String token, UserDetails user){
        String username = extractUsername(token);
        return (username.equals(user.getUsername())) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token){
        return extractExpiration(token).before(new Date());
    }

    //	private Date extractExpiration(String token) {
//		return extractClaim(token, Claims::getExpiration);
//	}

    private Date extractExpiration(String token) {
        Claims claims = extractAllClaims(token);
        return claims.getExpiration();
    }
}
