package com.jnshu.pojo.tool;

import com.jnshu.pojo.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author pipiretrak
 * @date 2019/4/14 - 10:29
 */
public class JwtUtil {
    public static String createJWT(long ttlMillis, String userName,String userPassword){

        //指定签名的时候使用的签名算法，也就是header那部分，jwt已经将这部分内容封装好了。
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        //生成JWT的时间
        long nowMillis = System.currentTimeMillis();
        java.util.Date now  = new java.util.Date(nowMillis);

        //创建payload的私有声明（根据特定的业务需要添加，如果要拿这个做验证，一般是需要和jwt的接收方提前沟通好验证方式的）
        //本例子为使用用户名和密码进行验证
        Map<String,Object> claims = new HashMap<>();
        claims.put("name",userName);
        claims.put("password",userPassword);


        //生成签名的时候使用的秘钥secret,这个方法本地封装了的，一般可以从本地配置文件中读取，切记这个秘钥不能外露哦。它就是你服务端的私钥，在任何场景都不应该流露出去。一旦客户端得知这个secret, 那就意味着客户端是可以自我签发jwt了。
       /* byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(base64Secret);
        Key key = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());*/

        String key =  "XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";
        //生成签发人
        String subject = userName;

        //下面就是在为payload添加各种标准声明和私有声明了
        //这里其实就是new一个JwtBuilder，设置jwt的body
        JwtBuilder builder = Jwts.builder()
                //如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setClaims(claims)
                //设置jti(JwtUtil ID)：是JWT的唯一标识，根据业务需要，这个可以设置为一个不重复的值，主要用来作为一次性token,从而回避重放攻击。
                .setId(UUID.randomUUID().toString())
                //iat: jwt的签发时间
                .setIssuedAt(now)
                //代表这个JWT的主体，即它的所有人，这个是一个json格式的字符串，可以存放什么userid，roldid之类的，作为什么用户的唯一标志。
                .setSubject(subject)
                //设置签名使用的签名算法和签名使用的秘钥
                .signWith(signatureAlgorithm,key);
        if (ttlMillis >= 0){

            long expMillis = nowMillis+ttlMillis;
            java.util.Date exp = new Date(expMillis);
            //设置过期时间
            builder.setExpiration(exp);
        }

        //生成JWT
        return  builder.compact();
    }

    /**
     * Token的解密
     * @return
     */
    public static Claims parseJWT(String  token){
        //签名秘钥，和生成的签名的秘钥一模一样
        String key = "XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";

        Claims claims = Jwts.parser()
                //设置签名的秘钥
                .setSigningKey(key)
                //设置需要解析的jwt
                .parseClaimsJws(token).getBody();
        return claims;
    }

    /**
     * 校验token中密码是否相同
     * @param token
     * @param user
     * @return
     */
    public static Boolean isVerify(String token, User user){
        //签名秘钥，和生成的签名的秘钥一模一样
        String key = "XX#$%()(#*!()!KL<><MQLMNQNQJQK sdfkjsdrow32234545fdf>?N<:{LWPW";

        //得到DefaultJwtParser
        Claims claims = Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(token).getBody();
        if(claims.get("password").equals(user.getPassword())){
            return true;
        }
        return false;
    }
}
