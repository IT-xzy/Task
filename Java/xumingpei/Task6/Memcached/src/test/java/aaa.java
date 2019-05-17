import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeoutException;

/**
 * @author pipiretrak
 * @date 2019/5/11 - 11:12
 */
@Component
public class aaa {



        public void ooo() throws InterruptedException, MemcachedException, TimeoutException {
            ApplicationContext applicationContext  = new ClassPathXmlApplicationContext("xmemcache.xml");
            MemcachedClient memCachedClient = (MemcachedClient) applicationContext.getBean("memcachedClient");
            memCachedClient.set("aaa", 0,"1111");
            String x = (String) memCachedClient.get("aaa");
            System.out.println(x);

        }


    public static void main(String[] args) throws InterruptedException, MemcachedException, TimeoutException {
        aaa a= new aaa();
        a.ooo();
    }

}
