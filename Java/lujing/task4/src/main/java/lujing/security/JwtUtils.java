package lujing.security;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lujing.util.CookieUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author lujing
 * Create_at 2018/1/6 13:37
 */
public class JwtUtils {
    /**
     * @param siginKey 签名部分生成的密钥
     * @param subject  需要加密的部分
     * @return 生成的一个TOKEN字符串
     */
    public static String generateToken(String siginKey, String subject) {
        
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        
        JwtBuilder builder = Jwts.builder()
                .setSubject(subject)
                .setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, siginKey)
                ;
        
        return builder.compact();
    }
    
    /**
     * 解密token得到subject
     * @param request
     * @param jwtCookieName
     * @param siginKey
     * @return
     */
    public static String getSubject(HttpServletRequest request, String jwtCookieName, String siginKey) {
        //根据cookie的名字查询出token
       String token = CookieUtils.getCookieValue(request,jwtCookieName);
       if(null == token){
           return null;
       }
       //根据token得到被加密的subject
        String subject = Jwts.parser().setSigningKey(siginKey).parseClaimsJws(token).getBody().getSubject();
        return subject;
    }
    
}
