package com.ethanzyc.allinone;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ethan
 * @date 2019/7/26 15:05
 */
public class JWTTest {

    public static final String CLAIM_KEY_USERNAME = "usernamee";
    public static final String secret = "fffzzzsss";

    @Test
    public void generateToken() {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

        String jws = Jwts.builder().setSubject("Joe").signWith(key).compact();
        System.out.println(jws);

    }

    @Test
    public void decodeJwt() {
        Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
        String jws = Jwts.builder().setSubject("Joe").signWith(key).compact();
//        String jws = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKb2UifQ.z5cntnI3sesdW_fF-PNmcgE50DRcrDejlhB8OpWxzsg";
        Claims body = Jwts.parser().setSigningKey(key).parseClaimsJws(jws).getBody();
        String subject = body.getSubject();
        System.out.println(subject);
    }

}
