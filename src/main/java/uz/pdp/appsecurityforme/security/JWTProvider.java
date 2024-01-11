package uz.pdp.appsecurityforme.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JWTProvider {

    @Value("${app.jwt.access.key}")
    private String accessToken;

    @Value("${app.jwt.access.expiration}")
    private long accessExpiration;

    @Value("${app.jwt.refresh.key}")
    private String refreshToken;

    @Value("${app.jwt.refresh.expiration}")
    private long refreshExpiration;

    public String createAccessToken(String id){
        return Jwts.builder()
                .setSubject(id)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + accessExpiration))
                .signWith(getSingingKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public String createRefreshToken(String id){
        return Jwts.builder()
                .setSubject(id)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + refreshExpiration))
                .signWith(getSigningKeyForRefresh(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key getSigningKeyForRefresh() {
        byte[] keyBytes = Decoders.BASE64.decode(refreshToken);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    private Key getSingingKey() {
        byte[] keyBytes = Decoders.BASE64.decode(accessToken);
        return Keys.hmacShaKeyFor(keyBytes);
    }


    public String extractUserId(String token) {
        try {
            Jws<Claims> claimsJws = extractClaimsForAccessToken(token);
            return claimsJws.getBody().getSubject();
        } catch (JwtException | IllegalArgumentException e) {
            return null;
        }
    }

    public String extractUserIdFromRefreshToken(String token){
        try {
            Jws<Claims> claimsJws = extractClaimsForRefreshToken(token);
            return claimsJws.getBody().getSubject();
        } catch (JwtException | IllegalArgumentException e) {
            return null;
        }
    }

    private Jws<Claims> extractClaimsForRefreshToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKeyForRefresh())
                .build().parseClaimsJws(token);
    }


    private Jws<Claims> extractClaimsForAccessToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSingingKey())
                .build().parseClaimsJws(token);
    }

    public boolean isExpired(String token){
        try {
            extractClaimsForAccessToken(token);
            return false;
        } catch (ExpiredJwtException e) {
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    public boolean validRefreshToken(String refreshToken){
        try {
            extractClaimsForRefreshToken(refreshToken);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


}
