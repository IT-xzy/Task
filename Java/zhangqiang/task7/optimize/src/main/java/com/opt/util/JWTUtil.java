package com.opt.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {


    public String SECRET = "ABCDEFGHIJKLMNOPQRSTWXYZabcdefghijklmnopqrstwxyz0123456789-_.";

    public JWTUtil(){}

    public JWTUtil(String key){
        this.SECRET = key;
    }

    public String createToken(String username,int expDate) throws Exception {

        //签发时间
        Date istDate = new Date();
        //设置过期时间
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, expDate);
        Date expiresDate = nowTime.getTime();

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");

        String token = JWT.create()
                .withHeader(map)
                .withIssuer("张强")
                .withClaim("name", username)
                .withExpiresAt(expiresDate)//设置过期时间   过期时间要>签发时间
                .withIssuedAt(istDate)//设置签发时间
                .sign(Algorithm.HMAC256(SECRET));//使用key加密
        return token;
    }

    public Map<String, Claim> verifyToken(String token) throws Exception{
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt = null;
        try {
            jwt = verifier.verify(token);
        } catch (Exception e) {
            throw new RuntimeException("凭证过期！请重新登录!");
        }

        return jwt.getClaims();
    }

    public DecodedJWT decodedToken(String token) throws Exception,JWTVerificationException ,TokenExpiredException{
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt ;
        try {
            jwt = verifier.verify(token);
        } catch (TokenExpiredException e) {
            e.fillInStackTrace();
            throw new RuntimeException("凭证过期！请重新登录!");

        }
        return jwt;
    }

}
