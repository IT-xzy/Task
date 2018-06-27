import org.junit.Test;
import utils.JwtUtil;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试JWT工具类
 */
public class JwtUtilTest {
    @Test
    public void jwtTest(){
        String id = "1234";
        String issuer = "justMe";
        String subject = "demo";
        long maxAge = 600000L; //有效期时长
        Map<String,Object> jwtClaims = new HashMap<>();
        jwtClaims.put("id",1);
        jwtClaims.put("issuer",issuer);
        jwtClaims.put("subject",subject);
        jwtClaims.put("expiration",System.currentTimeMillis()+maxAge);

        JwtUtil jwtUtil = new JwtUtil();
        String  jwt = jwtUtil.createJwt(jwtClaims);
        System.out.println("JWT:"+jwt+",长度："+jwt.length());
        Map<String,Object> primaryClaims = jwtUtil.verifyJwt(jwt);
        System.out.println(primaryClaims.get("subject"));
        System.out.println(primaryClaims.get("expiration"));
    }

    @Test
    public void standardTest(){
        String name = "AabcABC123";
        String n ="123";
        int t =123;
        String str ="abc";
        String num = "123456a";
        String reg = "^[a-zA-Z][a-zA-Z0-9_]*$";
        String Int = "^[0-9]*$";
        System.out.println(String.valueOf(t).matches(Int));
        System.out.println(n.matches(Int));
        System.out.println(name.matches(reg));
        System.out.println(n.matches(reg));
        System.out.println(str.matches(reg));
        System.out.println(num.matches(reg));
    }
}
