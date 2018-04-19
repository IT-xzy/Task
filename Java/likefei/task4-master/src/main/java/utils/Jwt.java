package utils;

import io.jsonwebtoken.*;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;


public class Jwt {
    static String authJm = "biumingwaai";
    static String authJm1 = EncryUtil.encrypt(authJm);

    public static String createJWT(String payload) {
        String payload1 = EncryUtil.encrypt(payload);
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(authJm1);
        SecretKey signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        JwtBuilder builder = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                .setPayload(payload1)
                .signWith(signatureAlgorithm, signingKey);
        // 返回了String的jwt=编码后的header+"."+编码后的body+"."+编码后的签名
        //Payload和claims只能同时存在一个
        //base64UrlEncodedBody = this.payload != null ? TextCodec.BASE64URL.encode(this.payload) : this.base64UrlEncode(this.claims
        //将其中一个的值赋给body
        return builder.compact();
    }
    public static String parseJWT(String jwt)  {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(authJm1);
        SecretKey signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
        if (jwt.split("\\.").length == 3) {
            String head = jwt.split("\\.")[0];//jwt头部
            String payload = jwt.split("\\.")[1];//jwt负荷(des加密后）
            String sign = jwt.split("\\.")[2];//签名
            String body=(String)(Jwts.parser(). setSigningKey(signingKey).parse(jwt).getBody());
            String body1 = EncryUtil.decrypt(body);//des解密body
            String sign_new = createJWT(body1).split("\\.")[2];
                if (sign_new.equals(sign)) {
                   return "恭喜你猜对啦";
                }
               return "QAQ签名不一致";
        }
        return "QAQ你不是JWT";
    }
}

