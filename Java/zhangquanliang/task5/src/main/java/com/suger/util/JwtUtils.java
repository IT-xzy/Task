package com.suger.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

/**
 * @author suger
 * @date 2018/11/26 20:04
 */
public class JwtUtils {

    public String secretkey = "ABCDEFGHIJKLMNOPQRSTWXYZabcdefghijklmnopqrstwxyz0123456789-_.";

    public JwtUtils(){}

    public JwtUtils(String key){
        this.secretkey = key;
    }

    /**
     * 创建 token
     * @param name 用户名
     * @param maxAge  最大有效时间
     * @return
     * @throws IllegalArgumentException
     * @throws UnsupportedEncodingException
     */
    public  String getToken(String name,long maxAge) throws IllegalArgumentException, UnsupportedEncodingException {

        String token = null ;

        //指定签名的时候使用的签名算法 和秘钥
        Algorithm algorithm = Algorithm.HMAC256(secretkey);


        //签发时间,当前系统时间
        Date nowTime = new Date();

        //设置过期时间
        Date expiresAt = new Date(System.currentTimeMillis()+ maxAge);
        token = JWT.create()
                // 签发者
                .withIssuer("jnshu")
                // 用户名
                // .withClaim
                .withClaim("username", name)
                // 过期时间
                .withExpiresAt(expiresAt)
                //设置签发时间
                .withIssuedAt(nowTime)
                // 使用了HMAC256加密算法。
                .sign(algorithm);

        return token;

    }

    public Map<String, Claim> verifyToken(String token) throws Exception{
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretkey)).build();
        DecodedJWT jwt = null;
        try {
            jwt = verifier.verify(token);
        } catch (Exception e) {
            throw new RuntimeException("凭证过期！请重新登录!");
        }

        return jwt.getClaims();
    }

    public DecodedJWT decodedToken(String token) throws Exception,JWTVerificationException ,TokenExpiredException {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(secretkey)).build();
        DecodedJWT jwt ;
        try {
            jwt = verifier.verify(token);
        } catch (TokenExpiredException e) {
            e.fillInStackTrace();
            throw new RuntimeException("凭证过期！请重新登录!");
        }
        return jwt;
    }

    public static void main(String[] args) throws Exception {

        JwtUtils jwtUtils = new JwtUtils();
        // 1小时后 过期
        long maxTime = 60*60L*1000L;

        // 生成token
        String token = jwtUtils.getToken("zql",maxTime);

        // 打印token
        System.out.println("token: " + token);

        // 解密token
        DecodedJWT jwt = jwtUtils.decodedToken(token);

        System.out.println("签发者: " + jwt.getIssuer());
        System.out.println("name: " + jwt.getClaim("username").asString());
        System.out.println("过期时间： " + jwt.getExpiresAt());
        System.out.println("签发时间：   " + jwt.getIssuedAt());


    }




    /*public static String SECRET = "www.jnshu.com";
    private static final String EXP = "exp";
    private static final String PAYLOAD = "payload";
    //加密，传入一个对象和有效期
    public static <T> String sign(T object, long maxAge) {
        try {
            final JWTSigner signer = new JWTSigner(SECRET);
            final Map<String, Object> claims = new HashMap<>();
            ObjectMapper mapper = new ObjectMapper();
            String jsonString = mapper.writeValueAsString(object);
            claims.put(PAYLOAD, jsonString);
            claims.put(EXP, System.currentTimeMillis() + maxAge);
            return signer.sign(claims);
        } catch(Exception e) {
            return null;
        }
    }

    //解密，传入一个加密后的token字符串和解密后的类型
    public static<T> T unsign(String jwt, Class<T> classT) {
        final JWTVerifier verifier = new JWTVerifier(SECRET);
        try {
            final Map<String,Object> claims= verifier.verify(jwt);
            if (claims.containsKey(EXP) && claims.containsKey(PAYLOAD)) {
                long exp = (Long)claims.get(EXP);
                long currentTimeMillis = System.currentTimeMillis();
                if (exp > currentTimeMillis) {
                    String json = (String)claims.get(PAYLOAD);
                    ObjectMapper objectMapper = new ObjectMapper();
                    return objectMapper.readValue(json, classT);
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }*/

}
