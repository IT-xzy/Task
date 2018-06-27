package com.jnshu.Token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.collect.Maps;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

public class TokenUtil {
    //
//    /**
//     * 生成加密后的token     JWT封装类
//     * @param username 用户名
//     * @param name  姓名
//     * @return 加密后的token
//     */

    public static String getToken( String name,String landtime) throws  IllegalArgumentException,UnsupportedEncodingException {
        //JWT的 header
        Algorithm algorithm = Algorithm.HMAC256("secret");
        Map<String, Object> map = Maps.newHashMap();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        Date expiresAt = new Date(System.currentTimeMillis() + 24L * 60L * 3600L * 1000L);
        String token = JWT.create()
                .withHeader(map)                       // Header
                .withIssuer("yang")                     //签发者
                .withClaim("name", name) //payload
                .withClaim("landtime",landtime)
                .withExpiresAt(expiresAt)              // 时间戳
                .sign(algorithm);    //sign  secret是用来加密数字签名的密钥。 私有秘钥     使用了HMAC256加密算法。
        return token;
    }

    public static DecodedJWT deToken(String token){
        DecodedJWT decodedJWT = null;
        try{
            Algorithm algorithm = Algorithm.HMAC256("secret");
            JWTVerifier Verifier = JWT.require(algorithm).build();
            decodedJWT = Verifier.verify(token);
        }catch(IllegalArgumentException e){
            e.printStackTrace();
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();
        }catch(JWTVerificationException e) {
            e.printStackTrace();
        }
        return decodedJWT;
    }



    public static String[] tool(String token) {
        DecodedJWT jwt = TokenUtil.deToken(token);
        String name, land = null;
        name = jwt.getClaim("username").asString();
        land = jwt.getClaim("landtime").asString();
        System.out.println("username: " + name + "landtime" + land);
        //  des = jwt.getToken();
        return new String[]{name,land};
    }
}
