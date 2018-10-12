import com.lihoo.ssm.model.UserBean;
import com.lihoo.ssm.util.MemcachedUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 * #Title: MemcachedUtilTest
 * #ProjectName task6_index1
 * #Description: TODO
 * #author lihoo
 * #date 2018/9/13-10:57
 */


public class MemcachedUtilTest {
    private static Logger logger = LogManager.getLogger(MemcachedUtilTest.class);


    @Test
    public void testMemcached() {
        MemcachedUtil.put("my_name", "yokohama", 60);
        String name = (String) MemcachedUtil.get("my_name");
        logger.info(name);
        Assert.assertEquals("yokohama", name);

        for (int i = 0; i < 100; ++i) {
            UserBean userBean = new UserBean("yokohama" + i, "456123**" + i);
            logger.info(userBean);
            MemcachedUtil.put("user" + i, userBean, 60);
            Object obj = MemcachedUtil.get("user" + i);
            logger.info(obj);
            Assert.assertEquals(userBean, obj);
        }
    }
}
