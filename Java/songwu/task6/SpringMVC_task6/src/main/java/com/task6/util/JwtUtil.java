package com.task6.util;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.log4j.Logger;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


/**
 * Create by SongWu on 2018/7/7
 */
public class JwtUtil {
    Logger logger = Logger.getLogger(JwtUtil.class);

    public static String SECRET = "SongWuKeys";


    //    生成token
    public static String createToken(String username) throws Exception {
        Date date = new Date();
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 1);

        Date expiresDate = nowTime.getTime();
        String str = username + "-" + date;
        byte[] des = DESUtil.encrypt(str.getBytes(), DESUtil.getValue("keys"));

        String userId = new String(des);

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create()
                .withHeader(map)//header
                .withClaim("userId", userId)//payload
                .withExpiresAt(expiresDate)//设置过期时间
                .withIssuedAt(date)//设置签发时间
                .sign(Algorithm.HMAC256(SECRET));

        return token;
    }
//解密token

    public static Map<String, Claim> verifyToken(String token) throws Exception {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt;
        try {
            jwt = verifier.verify(token);
        } catch (Exception e) {
//            throw new RuntimeException("登录凭证已经失效，请重新登录！");
        return  null;
        }
        return jwt.getClaims();


    }


}


