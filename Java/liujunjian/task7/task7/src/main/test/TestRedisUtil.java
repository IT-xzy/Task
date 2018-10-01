import com.tools.CheckCode;
import com.tools.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/applicationContext.xml")
public class TestRedisUtil {
    @Autowired
    private RedisUtil redisUtil;

    @Test
    public void testSet() {
        redisUtil.setString("phoneCode", CheckCode.generateCheckCode(),10);
        System.out.println(redisUtil.getString("phoneCode"));
    }

    @Test
    public void testGet() {

    }

}
