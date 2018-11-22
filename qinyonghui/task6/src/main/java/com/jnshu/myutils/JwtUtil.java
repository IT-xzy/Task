package com.jnshu.myutils;


import com.google.gson.Gson;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {
    /**
     * 解密
     * @param jsonWebToken
     * @param base64Security
     * @return
     */
    public static Claims parseJWT(String jsonWebToken, String base64Security) {
        try {
            Claims claims = Jwts.parser()
                    .setSigningKey(base64Security.getBytes())
                    .parseClaimsJws(jsonWebToken).getBody();
            return claims;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * 前三个参数为自己用户token的一些信息比如id，权限，名称等。不要将隐私信息放入（大家都可以获取到）
     * @param map
     * @param base64Security
     * @return
     */
    public static String createJWT(Map<String, Object> map, String base64Security) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //添加构成JWT的参数
        JwtBuilder builder = Jwts.builder().setHeaderParam("typ", "JWT")
                .setPayload(new Gson().toJson(map))
                .signWith(signatureAlgorithm,base64Security.getBytes());
        //估计是第三段密钥//生成JWT
        return builder.compact();
    }

   public static void main(String[] args) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("province", "898765");
        map.put("city", "898765");
        map.put("appkey", "HMu1H/cmyKDOiHv41Y9lLROuOlOo+PPG8F4/RotRmNc=");
        map.put("timestamp", new Date().getTime());

        //密钥
        String keyt = "79e7c69681b8270162386e6daa53d1dc";
        String token=JwtUtil.createJWT(map, keyt);
        System.out.println("JWT加密的结果："+ token);
        System.out.println("JWT解密的结果："+ parseJWT(token, keyt));
    }
}
