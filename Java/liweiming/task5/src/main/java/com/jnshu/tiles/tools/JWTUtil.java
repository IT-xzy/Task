package com.jnshu.tiles.tools;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.jnshu.tiles.entity.User;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: Tiles
 * @description: JWT工具
 * @author: Mr.Lee
 * @create: 2018-07-07 09:47
 **/
public class JWTUtil {

    public static String SECRET = "XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";

    /**
    * @Description: 生成token
    * @Param: [user]
    * @return: java.lang.String
    * @Author: Mr.Lee
    * @Date: 2018\7\7 0007
    */
    public static String createToken(User user)throws Exception{
        //签发时间
        Date date = new Date();

        //过期时间
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE,30);
        Date expireDate = nowTime.getTime();


        Map<String ,Object> map = new HashMap<>();
        map.put("type","JWT");
        map.put("alg","KS256");


        String token = JWT.create()
                .withHeader(map)
                .withClaim("id",Integer.toString(user.getId()))
                .withExpiresAt(expireDate)
                .withIssuedAt(date)
                .sign(Algorithm.HMAC256(SECRET));
        return token;
    }

    /** 
    * @Description: 解密token
    * @Param: [token] 
    * @return: java.util.Map<java.lang.String,com.auth0.jwt.interfaces.Claim> 
    * @Author: Mr.Lee
    * @Date: 2018\7\7 0007 
    */ 
    public static Map<String ,Claim> verifyToken(String token)throws Exception{
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).build();
        DecodedJWT jwt;

        try {
            jwt=verifier.verify(token);
        }catch (Exception e){
            throw new RuntimeException("登录凭证已失效，请重新登录！");
        }
        return jwt.getClaims();
    }
}
