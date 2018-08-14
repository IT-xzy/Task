package com.tools;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;

public class JwtUtil {
    @Value("${jwt.key}")
    private String key;

    //生成jwt
    public String generateToken(String username,long expiry) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256; //指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
        //生成jwt的时间
        Long now = System.currentTimeMillis();
        Date generateTime = new Date(now);
        //创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
//        Map<String, Object> claims = new HashMap<>();
//        claims.put("username", username);
//        claims.put("generateTime", generateTime);
        JwtBuilder jwtBuilder = Jwts.builder()//这里其实就是new一个JwtBuilder，设置jwt的body
//                .setClaims(claims)//如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setIssuedAt(generateTime)//签发时间
                .setSubject(username)
                .signWith(signatureAlgorithm, key);
        if (expiry > 0) {
            Date expiryTime = new Date(now + expiry);//过期时间
            jwtBuilder.setExpiration(expiryTime);
        }
        return jwtBuilder.compact();
    }

    public Claims parseToken(String token) {
        return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
    }
}
