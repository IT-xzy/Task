package com.jnshu.task7.utils;

import io.jsonwebtoken.*;

import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    public static String encode(String key,Map<String,Object> param,String salt){
        if(salt!=null){
            key+=salt;
        }
        JwtBuilder jwtBuilder = Jwts.builder().signWith(SignatureAlgorithm.HS256,key);

        jwtBuilder = jwtBuilder.setClaims(param);

        String token = jwtBuilder.compact();
        return token;

    }


    public  static Map<String,Object> decode(String token , String key, String salt){
        Claims claims=null;
        if (salt!=null){
            key+=salt;
        }
        try {
            claims= Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        } catch ( JwtException e) {
            return null;
        }
        return  claims;
    }

    public static void main(String[] args) {
        String key = "jnshu";
        String salt = "username";
        Map map = new HashMap(16);
        map.put("name","username");
        String token = encode(key,map,salt);
        System.out.println(token);
    }

}
