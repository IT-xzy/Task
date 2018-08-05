package utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;

public class Token {

    public static SecretKey generalkey(){
        String stringkey = "Hello";
        byte[] encodedkey = Base64.decodeBase64(stringkey);
        SecretKey key = new SecretKeySpec(encodedkey,0,encodedkey.length,"AES");
        return key;
    }
    public static String createJWT(String id,String subject,long ttlMillis) throws Exception{
        //签名算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //获取当前时间
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        SecretKey key = generalkey();
        JwtBuilder builder = Jwts.builder()
                .setId(id)
                .setIssuedAt(now)
                .setSubject(subject)
                .signWith(signatureAlgorithm,key);
        if (ttlMillis>=0){
            long expMillis = nowMillis+ttlMillis; //过期时间
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }
    //解密jwt
    public static Claims parseJWT(String jwt)throws Exception{
        SecretKey key = generalkey();
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(jwt).getBody();
        return claims;
    }
}
