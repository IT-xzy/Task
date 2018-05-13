package com.Utils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author: 曹樾
 * @program: task5-module
 * @description: Jwt工具类
 * @create: 2018/5/8 下午2:37
 */

public class JwtUtil {
    /**
     * 生成token
     * @param siginKey 签名部分生成的秘钥
     * @param subject 需要加密的部分
     * @return 生成的token字符串
     */
    public static String generateToken(String siginKey, String subject) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        JwtBuilder builder = Jwts.builder();
        builder.setSubject(subject);
        builder.setIssuedAt(now);
        builder.signWith(SignatureAlgorithm.HS256, siginKey);
        return builder.compact();
    }
    
    /**
     * 解密token拿到subject
     * @param request
     * @param jwtCookieName
     * @param siginKey
     * @return
     */
    public static String getSubject(HttpServletRequest request, String jwtCookieName, String siginKey) {
        //根据cookie的名字查询出token
        String token = CookieUtil.getCookieValue(request,jwtCookieName);
        if(null == token){
            return null;
        }
        //根据token得到被加密的subject
        String subject = Jwts.parser().setSigningKey(siginKey).parseClaimsJws(token).getBody().getSubject();
        return subject;
    }
}
