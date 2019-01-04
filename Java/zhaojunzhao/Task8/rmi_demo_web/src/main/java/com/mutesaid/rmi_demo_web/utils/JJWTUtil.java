package com.mutesaid.rmi_demo_web.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * JWT工具类，生成token，解析token
 *
 * @author TwT
 */
@Component
@Slf4j
public class JJWTUtil {
    private static final String JWT_KEY = "www.jnshu.com";

    public static String sign(Long uid) {
        // Token默认过期时间10分钟
        Date expiration = new Date(System.currentTimeMillis() + 6000 * 1000);
        return Jwts.builder()
                .claim("uid", uid)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, JWT_KEY.getBytes())
                .compact();
    }

    public static Claims verify(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(JWT_KEY.getBytes())
                    .parseClaimsJws(token)
                    .getBody();

        } catch (Exception e) {
            return null;
        }
    }

    public static Long getUID(String token) {
        Claims claims = verify(token);
        Integer uid = (Integer) claims.get("uid");
        return uid.longValue();
    }


}
