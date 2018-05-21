package lujing.security;

import io.jsonwebtoken.Jwts;
import lujing.Constant;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author lujing
 * Create_at 2018/1/6 15:38
 */
public class JwtUtilsTest {
    
    @Test
    public void generateTokenaa() {
        JwtUtils.generateToken(Constant.siginKey, "lujing");
    }
    
    @Test
    public void getSubject() {
        String token = JwtUtils.generateToken(Constant.siginKey, "lujing");
        String xx = Jwts.parser().setSigningKey(Constant.siginKey).parseClaimsJws(token).getBody().getSubject();
    
        System.out.println(xx);
        
    }
}