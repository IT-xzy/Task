import com.task.cache.SpyMemcachedManager;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spymemcached {
    private ApplicationContext app;
    private SpyMemcachedManager memcachedManager;
    @Before
    public void init() {
        app = new ClassPathXmlApplicationContext("app-context-spymemcached.xml");
        memcachedManager = (SpyMemcachedManager) app.getBean("memcachedManager");
    }
    @Test
    public void test() {
        try {
            System.out.println("set："+memcachedManager.set("SpyMemcached", "iamhandsome", 9000));
            System.out.println("get："+memcachedManager.get("SpyMemcached"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
