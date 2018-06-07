package utils;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Map;

/**
 * 用来生成token令牌和解码验证token令牌
 * JWT由三部分组成，头部header、载荷payload与签名signature
 */
public class JwtUtil {
    private static final String API_KEY ="ApiKey" ; //自定义加密密钥
    private byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(API_KEY); //转换成Base64编码
    /**
     * 生成Token令牌
     * @param  claims JWT
     * @return 返回JWT
     */
    public String createJwt(Map<String,Object> claims){
        //签名算法使用SHA256算法加密
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256; //头部header

        //加密JWT
        Key signingKey = new SecretKeySpec(apiKeySecretBytes,signatureAlgorithm.getJcaName());

        //设置JWT声明格式，生成JWT
        JwtBuilder jwtBuilder = Jwts.builder()
                .setClaims(claims)
                .signWith(signatureAlgorithm,signingKey); //签名算法及签名密钥，将header与payload加密拼接后形成JWT

        return jwtBuilder.compact(); //返回JWT
    }

    /**
     * 解析和验证token信息
     * @param jwt JWT信息
     */
    public Map<String,Object> verifyJwt(String jwt){
        return Jwts.parser()
                .setSigningKey(apiKeySecretBytes)
                .parseClaimsJws(jwt).getBody();
    }
}
