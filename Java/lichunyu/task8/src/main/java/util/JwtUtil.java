package util;

import io.jsonwebtoken.Claims;
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
    private static final String SIGNING_KEY ="signingKeyValue" ; //自定义加密密钥SIGNING_KEY
    private byte[] signingSecretBytes = DatatypeConverter.parseBase64Binary(SIGNING_KEY); //转换成Base64编码
    /**
     * 生成Token令牌
     * @param  payload 消息体
     * @return 返回JWT
     */
    public String createJwt(Map<String,Object> payload){
        //签名算法使用SHA256算法加密
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //加密JWT
        Key signingKey = new SecretKeySpec(signingSecretBytes,signatureAlgorithm.getJcaName());
        //设置JWT声明格式，生成JWT
        JwtBuilder jwtBuilder = Jwts.builder()
                .setHeaderParam("typ","jwt")
                .setHeaderParam("alg","HS256")
                .setClaims(payload)
                .signWith(signatureAlgorithm,signingKey); //签名算法及签名密钥，将header与payload加密拼接后形成JWT

        return jwtBuilder.compact(); //返回JWT
    }
    /**
     * 解析和验证token信息
     * @param jwt JWT信息
     */
    public Claims verifyJwt(String jwt){
        return Jwts.parser()
                .setSigningKey(signingSecretBytes)
                .parseClaimsJws(jwt).getBody();
    }
}
