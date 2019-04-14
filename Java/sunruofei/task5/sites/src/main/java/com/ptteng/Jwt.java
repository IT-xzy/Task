package com.ptteng;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.sql.Date;

/**
 * @ClassName Jwt
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/2/20  17:03
 * @Version 1.0
 **/
public class Jwt {

    private final static String base64Secret = "MDk4ZjZiY2Q0NjIxZDM3M2NhZGU0ZTgzMjYyN2I0ZjY=";
    private final static int expiresSecond = 172800000;
    //解析JWT，解析失败即返回null
    public static Claims parseJWT(String jsonWebToken) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(DatatypeConverter.parseBase64Binary(base64Secret))
                    .parseClaimsJws(jsonWebToken).getBody();

            return claims;
        } catch (Exception ex) {
            return null;
        }
    }


    public static String createJWT(String username) {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        //生成签名密钥
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Secret);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
               //把用户名和当前时间放到载荷中
                .claim("username", username)
                .claim("timeNow", System.currentTimeMillis())
                .signWith(signatureAlgorithm, signingKey);

        //添加Token过期时间
        if (expiresSecond >= 0) {
            long expMillis = nowMillis + expiresSecond;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp).setNotBefore(now);
        }

        //生成JWT
        return builder.compact();
    }

}
