package api.apiuser.api.infra.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Objects;

@Component
public class JWTUtil {

    @Value("${jwt.secretKey}")
    private String secret;

    @Value("${jwt.expiretion}")
    private Long expiration;


    public String generateToken(String email){
        SecretKey key = getKeyBySecurity();
        return Jwts.builder()
                .setSubject(email)
                .setExpiration(new Date(System.currentTimeMillis() + this.expiration))
                .signWith(key)
                .compact();
    }

    private SecretKey getKeyBySecurity(){
        SecretKey key = Keys.hmacShaKeyFor(this.secret.getBytes());
        return key;
    }

    public String getUserName(String token){
        Claims claims = getClaims(token);
        if(Objects.nonNull(claims)){
            return claims.getSubject();
        }
        return null;
    }

    public boolean isValidToken(String token){
        Claims claims = getClaims(token);

        if(Objects.nonNull(claims)){
            String userName = claims.getSubject();
            Date expirationDate = claims.getExpiration();
            Date now = new Date(System.currentTimeMillis());
            if(Objects.nonNull(userName) && Objects.nonNull(expirationDate) && now.before(expirationDate)){
                return true;
            }
        }

        return false;
    }

    private Claims getClaims(String token){
        SecretKey key = getKeyBySecurity();
        try{
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build().parseClaimsJws(token).getBody();
        }catch (Exception e){
            return null;
        }
    }
}
