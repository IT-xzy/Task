package com.mutesaid.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

/**
 * JWT工具类，生成token，解析token
 *
 * @author TwT
 */
@Component
public class JJWTUtil {
    public static String sign(Map<String, Object> payload, String key) {
        // Token默认过期时间10分钟
        Date expiration = new Date(System.currentTimeMillis() + 6000 * 1000);
        return Jwts.builder()
                .setClaims(payload)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, key.getBytes())
                .compact();
    }

    public static Map verify(String token, String key) {
        try {
            return Jwts.parser()
                    .setSigningKey(key.getBytes())
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            return null;
        }
    }

}
