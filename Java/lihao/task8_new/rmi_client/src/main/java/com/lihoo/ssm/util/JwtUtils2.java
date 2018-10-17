package com.lihoo.ssm.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

/**
 * #Title: JwtUtils2
 * #ProjectName task5_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/9-10:41
 */


public class JwtUtils2 {

    private static String lihooxuejava;

    /**
     * jwt
     *
     */
    private final static String JWT_ID = "jwt";
    private final static String JWT_SECRET = "hong1mu2zhi3ruan4jian5";
    private final static int JWT_TTL = 60*60*1000;  //millisecond
    private final static int JWT_REFRESH_INTERVAL = 55*60*1000;  //millisecond
    private final static int JWT_REFRESH_TTL = 12*60*60*1000;  //millisecond

    /**
     * 由字符串生成加密key
     * @return
     */
    private static SecretKey generalKey(){
        String stringKey = JWT_ID + JWT_SECRET;
        byte[] encodedKey = Base64.decodeBase64(stringKey);
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }

    /**
     * 创建jwt
     * @param id
     * @param subject
     * @param ttlMillis
     * @return
     * @throws Exception
     */
    public static String createJWT(String id, String subject, long ttlMillis) throws Exception {

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey key = generalKey();
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .signWith(signatureAlgorithm, key);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }

    /**
     * 解密jwt
     * @param jwt
     * @return
     * @throws Exception
     */
    public static Claims parseJWT(String jwt) throws Exception{
        SecretKey key = generalKey();
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwt).getBody();
        return claims;
    }

    /**
     * 生成subject信息
     * @param user
     * @return
     */
//    public static String generalSubject(t_user user){
//        JSONObject jo = new JSONObject();
//        jo.put("userId", user.getId());
//        jo.put("mobile", user.getMobile());
//        return jo.toJSONString();
//    }

}
