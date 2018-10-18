package com.task5.until;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWT {
    private String key;
    @Autowired
    private DES des;

    public void setKey(String key) {
        this.key = key;
    }
    //生成jwt
    public String generateToken(String username, long expiry) {
        io.jsonwebtoken.SignatureAlgorithm signatureAlgorithm = io.jsonwebtoken.SignatureAlgorithm.HS256;
        //指定签名的时候使用的签名算法，也就是header那部分，jjwt已经将这部分内容封装好了。
        //生成jwt的时间
        Long now = System.currentTimeMillis();
        Date generateTime = new Date(now);
        //创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", des.encrypt(username));
        claims.put("generateTime", des.encrypt(generateTime.toString()));
         JwtBuilder jwtBuilder = Jwts.builder()//这里其实就是new一个JwtBuilder，设置jwt的body
                .setClaims(claims)//如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，
                 // 一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setIssuedAt(generateTime)//签发时间
                .signWith(signatureAlgorithm, key);
        if (expiry > 0) {
            Date expiryTime = new Date(now + expiry);//过期时间
            jwtBuilder.setExpiration(expiryTime);
        }
        return jwtBuilder.compact();
    }

    public Map<String, Object> parseToken(String token) {
        Map<String, Object> result = new HashMap<>();
        if (token != null) {
            // 解析token
            try {
                Map<String, Object> body = Jwts.parser()
                        .setSigningKey(key)
                        .parseClaimsJws(token)
                        .getBody();
                String username = (String) body.get("username");
                String generateTime = (String) body.get("generateTime");

                if (username == null || username.isEmpty()) {
                    result.put("ERR_MSG", "您还没有登录，请登录：");
                    return result;
                }
                result.put("username", des.decrypt(username));
                result.put("generateTime", des.decrypt(generateTime));
                return result;
            } catch (SignatureException | MalformedJwtException e) {
                // jwt 解析错误
                result.put("ERR_MSG", "系统错误，请尝试重新登录：");
                return result;
            } catch (ExpiredJwtException e) {
                // jwt 已经过期，在设置jwt的时候如果设置了过期时间，这里会自动判断jwt是否已经过期，
                // 如果过期则会抛出这个异常，我们可以抓住这个异常并作相关处理。
                result.put("ERR_MSG", "登录信息已过期，请登录：");
                return result;
            }
        } else {
            result.put("ERR_MSG", "没有您的身份信息，请登录：");
            return result;
        }
    }
}
