package com.wyq.taskSeven.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.wyq.taskSeven.des.DES;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtToken {

    // 过期时间5分钟 毫秒
    private static final long EXPIRE_TIME = 5*60*1000;

    public static String createToken(Integer id, String name) {
        try {
            String desId = DES.encode(id.toString());
//            System.out.println(desId);
//            String desSignInTime = DES.encode(String.valueOf(signInTime));
//            System.out.println(desSignInTime);
            String secret = id + "secret" + name;
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("alg", "HS256");
            map.put("typ", "JWT");
            return JWT.create()
                    .withHeader(map)//header
                    .withClaim("id", desId) //payload
                    .withClaim("name", name)
//                    .withClaim("sign_in_time", desSignInTime)
                    .withExpiresAt(date)
                    .sign(Algorithm.HMAC256(secret));//加密
        }catch (UnsupportedEncodingException e){
            return null;
        }
    }

    public static boolean verifyToken(String token) throws Exception {
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256("secret")).build();
            DecodedJWT jwt = verifier.verify(token);
            return true;
        }catch (JWTVerificationException e) {
//        Map<String, Claim> claims = jwt.getClaims();
//        System.out.println(claims.get("name").asString());
            e.printStackTrace();
            return false;
        }
    }

    public static String getId(String token){
        try{
            DecodedJWT jwt = JWT.decode(token);
            return DES.decode(jwt.getClaim("id").asString());
        }catch (JWTDecodeException e){
            return null;
        }
    }

    public static String getName(String token){
        try{
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("name").asString();
        }catch (JWTDecodeException e){
            return null;
        }
    }
}
