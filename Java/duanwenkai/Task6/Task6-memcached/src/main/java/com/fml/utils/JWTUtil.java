package com.fml.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fml.pojo.User;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTUtil {
    /**
     *  公用密钥，保存在服务器端，客户端是不会知道密钥的，以防被攻击
     */
    public static String SECRET = "FreeMaNong";


    /**
     * 生成token
     * @param
     * @return
     * @throws Exception
     */
    public static String createToken(User entity) throws Exception{
        //签发时间
        Date date = new Date();

        //过期时间 30分钟过期
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE,30);
        Date expireDate = nowTime.getTime();

        Map<String, Object> map = new HashMap<>();
        map.put("typ","JWT");
        map.put("alg","KS256");

        String token = JWT.create()
                .withHeader(map)
                .withClaim("id",Long.toString(entity.getUserId()))//用户ID
                .withExpiresAt(expireDate)//过期时间
                .withIssuedAt(date)//签发时间
                .sign(Algorithm.HMAC256(SECRET));//加密
        return token;
    }


    /**
     * 解密token
     * @param token
     * @return
     * @throws Exception
     */
    public static Map<String,Claim> verifyToken(String token) throws Exception{
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt;
        try {
            jwt = verifier.verify(token);
        }catch (Exception e){
            throw new RuntimeException("登录凭证已经失效，请重新登录！");
        }
        return jwt.getClaims();
    }
}
