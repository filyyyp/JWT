package com.JWT.JWT.security;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Date;

/**
 * JWTCreator.
 */
@Service
public class JWT {

    public String createToken() throws UnsupportedEncodingException {

        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, 2019);
        calendar.set(Calendar.MONTH, 2);
        calendar.set(Calendar.DAY_OF_MONTH, 20);


        String jwt = Jwts.builder()
                .setSubject("users/TzMUocMF4p")
//                .setExpiration(new Date(250000000))
                .setExpiration(calendar.getTime())
                .claim("name", "Filip")
                .claim("roles", "admin,user")
                .signWith(
                        SignatureAlgorithm.HS256,
                        "secreta".getBytes("UTF-8")
                )
                .compact();

        return jwt;
    }

    public String checkToken(String token)  {
        try {
            Jws<Claims> claims = Jwts.parser()
                    .setSigningKey("secreta".getBytes("UTF-8"))
                    .parseClaimsJws(token);
        }
        catch (SignatureException signatureException) {
            return "Zly podpis";
        }
        catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        return "spravny podpis";
    }
}
