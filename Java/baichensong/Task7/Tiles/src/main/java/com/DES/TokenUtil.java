package com.DES;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.google.common.collect.Maps;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

public final class TokenUtil {
//
//    /**
//     * 生成加密后的token     JWT封装类
//     * @param username 用户名
//     * @param name  姓名
//     * @return 加密后的token
//     */

    public static String getToken( String username,String landtime) throws  IllegalArgumentException,UnsupportedEncodingException {
        //JWT的 header
        Algorithm algorithm = Algorithm.HMAC256("secret");
        Map<String, Object> map = Maps.newHashMap();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
            Date expiresAt = new Date(System.currentTimeMillis() + 24L * 60L * 3600L * 1000L);
           String token = JWT.create()
                    .withHeader(map)                       // Header
                    .withIssuer("bai")                     //签发者
                    .withClaim("username", username) //payload
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



    public static String codeToken( String phone,String code,String landtime) throws  IllegalArgumentException,UnsupportedEncodingException {
        //JWT的 header
        Algorithm algorithm = Algorithm.HMAC256("secret");
        Map<String, Object> maps = Maps.newHashMap();
        maps.put("alg", "HS256");
        maps.put("typ", "JWT");
        Date expiresAt = new Date(System.currentTimeMillis() + 24L * 60L * 3600L * 1000L);
        String tokens = JWT.create()
                .withHeader(maps)                       // Header
                .withIssuer("bai")                        //签发者
                .withClaim("phone",phone)
                .withClaim("code",code) //payload
                .withClaim("landtime",landtime)
                .withExpiresAt(expiresAt)              // 时间戳
                .sign(algorithm);    //sign  secret是用来加密数字签名的密钥。 私有秘钥     使用了HMAC256加密算法。
        return tokens;
    }


//
//    public static void main(String[] args) throws UnsupportedEncodingException{
//       // String username = "root";
//        String token = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2siOiJhY2QzM2Y5MzJhNzI5ODNmIiwiaXNzIjoiYmFpIiwiZXhwIjoxNTMzMzgxMDc4fQ.AiSu_2OoqkeZ29fCOE_a7CcghP0guV0sPRrePItlVVo";
//        TokenUtil tokenUtil= new TokenUtil();
//        DecodedJWT jwt = tokenUtil.deToken(token);
//
//      // System.out.println(deToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ0b2siOiJhY2QzM2Y5MzJhNzI5ODNmIiwiaXNzIjoiYmFpIiwiZXhwIjoxNTMzMzgxMDc4fQ.AiSu_2OoqkeZ29fCOE_a7CcghP0guV0sPRrePItlVVo"));
//        System.out.println("username: " + jwt.getClaim("username").asString());
//    }

public static String[] tool(String token) {
    DecodedJWT jwt = TokenUtil.deToken(token);
    String name, land = null;
        name = jwt.getClaim("username").asString();
        land = jwt.getClaim("landtime").asString();
        System.out.println("username: " + name + "landtime" + land);
        //  des = jwt.getToken();
 return new String[]{name,land};
}

//任务七 短信验证 token
    public static String[] codetool(String token) {
        DecodedJWT jwt = TokenUtil.deToken(token);
        String phone, code,land = null;
        phone = jwt.getClaim("phone").asString();
        code = jwt.getClaim("code").asString();
        land = jwt.getClaim("landtime").asString();
        System.out.println("phone: " + phone + "code"+ code + "landtime" + land);
        //  des = jwt.getToken();
        return new String[]{phone,code,land};
    }
}