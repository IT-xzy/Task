package com.task4.util;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.log4j.Logger;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;


/**
 * Create by SongWu on 2018/7/8l
 */
public class JwtUtil2 {

    private static Logger logger = Logger.getLogger(JwtUtil.class);
    private static String  SECRET = "SongWuKeys";


    // 生成签名密钥
    private static byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(SECRET);
    private static Key signingKey = new SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.getJcaName());

    public static String getToken( String username) {

        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);

        String str = username + "-" + now;
        byte[] des = DESUtil.encrypt(str.getBytes(), DESUtil.getValue("keys"));
        String userId = new String(des);

        JwtBuilder builder = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .claim("userId", userId)
//                .setIssuer(webToken.getName())
                .signWith(SignatureAlgorithm.HS256, signingKey);
        // 添加Token过期时间
        long TTLMillis = 60*1000;
        if (TTLMillis >= 0) {
            long expMillis = nowMillis + TTLMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp).setNotBefore(now);

        }
        return builder.compact();
    }

    /**
     * @param jsonWebToken
     * @return
     * @desc 解析token值
     */

    public static Claims parseWebToken(  String jsonWebToken) {

        try {
            Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET))
                    .parseClaimsJws(jsonWebToken).getBody();

            return claims;
        } catch (Exception ex) {
            logger.info("解析的token值"+ex);
          return null;
        }
    }



    /**
     * 获取webtoken的失效时间
     *
     * @param jsonWebToken
     * @return
     * @date 2017年7月10日 上午11:52:52
     */
    public static Long getWebTokenTime(String jsonWebToken) {
        try {
            Claims claims = Jwts.parser().setSigningKey(DatatypeConverter.parseBase64Binary(SECRET))
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims.getExpiration().getTime();
        } catch (Exception ex) {
            logger.error("解析token值：" + ex);
        }
        return null;
    }
}
