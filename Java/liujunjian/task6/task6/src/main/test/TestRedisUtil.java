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
    public void testGet() {
        System.out.println(redisUtil.getProfession("java"));
        System.out.println(redisUtil.getProfessions());
    }

    @Test
    public void testDelete() {
        if (redisUtil.deleteObject("java")) {
            System.out.println("yes");
        }
        System.out.println(redisUtil.getProfession("java"));
    }
}
