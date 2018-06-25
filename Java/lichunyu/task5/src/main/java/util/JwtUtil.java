package util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;

/**
 * 用来生成token令牌和解码验证token令牌
 * JWT由三部分组成，头部header、载荷payload与签名signature
 */
public class JwtUtil {
    private static final String apiKey ="ApiKey" ; //自定义加密密钥
    /**
     * 生成Token令牌
     * @param id  发布者Id
     * @param issuer 发布者
     * @param subject 发布主题
     * @param ttlMillis 有效期时长
     * @return 返回JWT
     */
    public String getJwt(String id, String issuer, String subject, long ttlMillis){
        //签名算法使用SHA256算法加密
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256; //头部header

        //获取当前时间
        long nowMillis = System.currentTimeMillis();
        Date nowDate = new Date(nowMillis);

        //加密JWT
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(apiKey);
        Key signingKey = new SecretKeySpec(apiKeySecretBytes,signatureAlgorithm.getJcaName());

        //设置JWT声明格式，生产JWT
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId(id) //发布者id
                .setIssuer(issuer)  //发布者
                .setSubject(subject)  //发布主题
                .setIssuedAt(nowDate) //发布时间
                .signWith(signatureAlgorithm,signingKey); //签名算法及签名密钥，将header与payload加密拼接后形成JWT

        if(ttlMillis>=0){//添加有效期
            long expMillis = nowMillis + ttlMillis; //过期时间
            Date exp = new Date(expMillis);
            jwtBuilder.setExpiration(exp);
        }
        return jwtBuilder.compact(); //返回JWT
    }

    /**
     * 解析和验证token信息
     * @param jwt JWT信息
     */
    public void parseJwt(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(DatatypeConverter.parseBase64Binary(apiKey))
                .parseClaimsJws(jwt).getBody();
        System.out.println("ID:"+claims.getId());
        System.out.println("Issuer:"+claims.getIssuer());
        System.out.println("Subject:"+claims.getSubject());
        System.out.println("Expiration:"+claims.getExpiration());
    }
}
