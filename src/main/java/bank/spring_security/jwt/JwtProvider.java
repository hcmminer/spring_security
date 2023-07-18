package bank.spring_security.jwt;

import bank.spring_security.security.CustomUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public class JwtProvider {

    @Value("${bank.jwt.salt}")
    private String JWT_SALT;

    @Value("${bank.jwt.expiration]")
    private int JWT_EXPIRATION;

    public String genToken(CustomUserDetails customUserDetails){
        Date now = new Date();
        Date dateExpired = new Date(now.getTime() + JWT_EXPIRATION);

        return Jwts.builder()
                .setSubject(customUserDetails.getUsername())
                .setIssuedAt(now)
                .setExpiration(dateExpired)
                .signWith(SignatureAlgorithm.HS512, JWT_SALT)
                .compact();

    }
    // lay ten dang nhap tu token
    public String getUserNameFromJwt (String token){
        Claims claims = Jwts.parser().setSigningKey(JWT_SALT)
                .parseClaimsJws(token).getBody();
        return claims.getSubject();

    }




}
