//
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import net.rubyeye.xmemcached.MemcachedClient;
//
///**
// * @author peiyu
// */
//public class XMemcachedSpring extends BaseTest {
//    private ApplicationContext app;
//    private MemcachedClient memcachedClient;
//    @Before
//    public void init() {
//        app = new ClassPathXmlApplicationContext("/app-context-xmemcached.xml");
//        memcachedClient = (MemcachedClient) app.getBean("memcachedClient");
//    }
//    @Test
//    public void test() {
//        try {
//            // 设置/获取
//            memcachedClient.set("zlex", 36000, "set/get");
//            System.out.println(memcachedClient.get("zlex"));
//            // 替换
//            memcachedClient.replace("zlex", 36000, "replace");
//            System.out.println(memcachedClient.get("zlex"));
//            // 移除
//            memcachedClient.delete("zlex");
//            System.out.println(memcachedClient.get("zlex"));
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
