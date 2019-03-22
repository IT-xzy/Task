package com.jnshu.task6.utils;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class JwtUtil {
    public static String encode(String key, Map<String, Object> param, String salt) {
        //增加盐值
        if (salt != null) {
            key += salt;
        }
        //采用hs256的方法来进行编码
        JwtBuilder jwtBuilder = Jwts.builder().signWith(SignatureAlgorithm.HS256, key);
        //设置参数
        jwtBuilder = jwtBuilder.setClaims(param);

        String token = jwtBuilder.compact();
        return token;

    }


    public static Map<String, Object> decode(String token, String key, String salt) {
        Claims claims = null;
        if (salt != null) {
            key += salt;
        }
        try {
            claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            return null;
        }
        return claims;
    }

//   public String sign(Map<String, Object> payload, Date expiration, String key){
//       return Jwts.builder()
//               .setClaims(payload)
//               .setExpiration(expiration)
//               .signWith(SignatureAlgorithm.HS256, key.getBytes())
//               .compact();
//   }
//
//    public Map verify(String token, String key){
//        try{
//            return Jwts.parser()
//                    .setSigningKey(key.getBytes())
//                    .parseClaimsJws(token)
//                    .getBody();
//        }catch (Exception e){
//            return null;
//        }
//    }



//    public static void main(String[] args) {
//        String key = "jnshu";
//        String salt = "123";
//        Map map = new HashMap();
//        map.put("user","zzz");
//        map.put("pwd","qwerdf");
//        String token = JwtUtil.encode(key,map,salt);
//        System.out.println("token is = " + token);
//        Map decode = JwtUtil.decode(token,key,salt);
//        System.out.println("decode is = " + decode);
//    }
}
