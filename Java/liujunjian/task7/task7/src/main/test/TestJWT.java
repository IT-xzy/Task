import com.tools.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/springTools.xml")
public class TestJWT {
    @Autowired
    JwtUtil jwtUtil;

    @Test
    public void testGenerateToken() {
        String token = jwtUtil.generateToken("晋良金");
        System.out.println(token);
        Map<String, Object> result = jwtUtil.parseToken(token);
        String username = (String) result.get("username");
        Date generateTime = (Date) result.get("generateTime");
        System.out.println(username);
        System.out.println(generateTime);
    }

//    @Test
//    public void testParseToken() {
//        Map<String, Object> result = jwtUtil.parseToken(null);
//        Collection<Object> collection = result.values();
//        Iterator it = collection.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }
//    }
}
