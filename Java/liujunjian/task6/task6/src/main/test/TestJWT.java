import com.tools.JwtUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/springTools.xml")
public class TestJWT {
    @Autowired
    JwtUtil jwtUtil;

    @Test
    public void testGenerateToken() {
        String token = jwtUtil.generateToken("晋良金", 60000);
        System.out.println(token);
    }

    @Test
    public void testParseToken() {
        Map<String, Object> result = jwtUtil.parseToken(null);
        Collection<Object> collection = result.values();
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }
}
