import com.auth0.jwt.interfaces.Claim;
import com.fml.utils.JWTUtil;
import org.junit.Test;

import java.util.Map;

public class TestJwt {
    /*@Test
    public void TestGetToken(){
        try {
            String token = JWTUtil.createToken();
            System.out.println(token);

            Map<String,Claim> map = JWTUtil.verifyToken(token);
            System.out.println(map.get("id").asString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    @Test
    public void TestVerifyToken(){
        try {
            Map<String,Claim> map = JWTUtil.verifyToken("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MSwiZXhwIjoxNTIxOTc4MjYwfQ.qI6jtUe3tTLjxF3Wv9_HUtkEdCcFfoqPClGmVsEwaT4");
            System.out.println(map.get("id").asString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
