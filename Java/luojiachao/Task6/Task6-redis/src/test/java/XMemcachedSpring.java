import net.rubyeye.xmemcached.MemcachedClient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XMemcachedSpring {
    private ApplicationContext app;
    private MemcachedClient memcachedClient;
    @Before
    public void init() {
        app = new ClassPathXmlApplicationContext("applicationContext.xml");
        memcachedClient = (MemcachedClient) app.getBean("memcachedClient");
    }
    @Test
    public void test() {
        try {
            String i;

            // 设置/获取
            memcachedClient.set("zlex", 36000, "set/get");
            i=memcachedClient.get("zlex");
            System.out.println(i);
            // 替换
            memcachedClient.replace("zlex", 36000, "replace");
            i=memcachedClient.get("zlex");
            System.out.println(i);

            // 移除
            memcachedClient.delete("zlex");
            i=memcachedClient.get("zlex");
            System.out.println(i);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
