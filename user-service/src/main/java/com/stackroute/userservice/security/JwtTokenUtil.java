package com.stackroute.userservice.security;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil implements Serializable {

    private static final long serialVersionUID=-13l;

    static  final String CLAM_KEY_USERNAME="sub";
    static  final String CLAM_KEY_AUDIANCE="audiance";
    static  final String CLAM_KEY_CREATED="created";

    @Value("${jwt.secret}")
    private String secrete;

    @Value("${jwt.expiration}")
    private long expiration;

    public String getUsernameFromToken(String token) {
        String username= null;
        try{
            final Claims claims= getClaimsFromToken(token);
            username=claims.getSubject();

        }catch (Exception e)
        {

        }
        return username;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims= null;
        try
        {
            claims= Jwts.parser().setSigningKey(secrete).parseClaimsJws(token).getBody();
        }
        catch (Exception e)
        {
            return null;
        }
        return claims;
    }

    public boolean validateToken(String token, UserDetails userDetails) {

        JwtUser user= (JwtUser)userDetails;
        final String username = getUsernameFromToken(token);
        return (username.equals(user.getUsername())&& !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        final Date expiration= getExpirationDatefromToken(token);
        return expiration.before(new Date());
    }

    private Date getExpirationDatefromToken(String token) {
        Date expiration=null;
        try {
            final Claims claims = getClaimsFromToken(token);
            if (claims != null) {
                expiration = claims.getExpiration();
            } else {
                expiration = null;
            }

        }
        catch (Exception e)
        {

        }
        return expiration;
    }

    public String generateToken(JwtUser userDetails) {
        Map<String, Object> claims= new HashMap<String , Object>();
        claims.put(CLAM_KEY_USERNAME, userDetails.getUsername());
        claims.put(CLAM_KEY_CREATED, new Date());
        return generateToken(claims);
    }

    public String generateToken (Map<String, Object> claims)
    {
        return Jwts.builder().setClaims(claims).setExpiration(getExpirationDate()).signWith(SignatureAlgorithm.HS512, secrete).compact();
    }

    private Date getExpirationDate() {
        return new Date(System.currentTimeMillis()+ expiration * 1000);
    }
}
