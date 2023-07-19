package bank.spring_security.jwt;

import bank.spring_security.security.CustomUserDetails;
import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class JwtProvider {

    @Value("${bank.jwt.salt}")
    private String JWT_SALT;

    @Value("${bank.jwt.expiration}")
    private int JWT_EXPIRATION;

    public String genToken(CustomUserDetails customUserDetails) {
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
    public String getUserNameFromJwt(String token) {
        Claims claims = Jwts.parser().setSigningKey(JWT_SALT)
                .parseClaimsJws(token).getBody();
        return claims.getSubject();

    }

    public boolean isValidToken(String token) {
        try {
            Jwts.parser().setSigningKey(JWT_SALT)
                    .parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
            log.error("Invalid JWT");
        } catch (ExpiredJwtException ex) {
            log.error("Expired JWT");
        } catch (UnsupportedJwtException ex) {
            log.error("Unsupported JWT");
        } catch (IllegalArgumentException ex) {
            log.error("JWT claims String is empty");
        }
        
        return false;

    }


}
