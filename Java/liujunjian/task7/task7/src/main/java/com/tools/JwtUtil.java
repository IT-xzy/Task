package com.tools;

import io.jsonwebtoken.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    private String key;
    private long expiry;

    public void setKey(String key) {
        this.key = key;
    }

    public void setExpiry(long expiry) {
        this.expiry = expiry;
    }

    //生成jwt
    public String generateToken(String username) {
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

    public Map<String, Object> parseToken(String token) {
        Map<String, Object> result = new HashMap<>();
        if (token != null) {
            // 解析token
            try {
                Map<String, Object> body = Jwts.parser()
                        .setSigningKey(key)
                        .parseClaimsJws(token)
                        .getBody();
                String username = ((Claims) body).getSubject();
                Date generateTime = ((Claims) body).getIssuedAt();

                if (username == null || username.isEmpty()) {
                    result.put("ERR_MSG", "您还没有登录，请登录：");
                    return result;
                }
                //账号在别处登录
//                if (userRepository.findByUsername(username).getLastLoginTime().after(generateTime)) {
//                    result.put("ERR_MSG", "账号在别的地方登陆");
//                    return result;
//                }
                result.put("username", username);
                result.put("generateTime", generateTime);
                return result;
            } catch (SignatureException | MalformedJwtException e) {
                // TODO: handle exception
                // don't trust the JWT!
                // jwt 解析错误
                result.put("ERR_MSG", "系统错误，请尝试重新登录：");
                return result;
            } catch (ExpiredJwtException e) {
                // TODO: handle exception
                // jwt 已经过期，在设置jwt的时候如果设置了过期时间，这里会自动判断jwt是否已经过期，如果过期则会抛出这个异常，我们可以抓住这个异常并作相关处理。
                result.put("ERR_MSG", "登录信息已过期，请登录：");
                return result;
            }
        } else {
            result.put("ERR_MSG", "没有您的身份信息，请登录：");
            return result;
        }
    }
}
