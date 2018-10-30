package memcached;

import com.danga.MemCached.MemCachedClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemCacheInvoke {

    public static void main(String[] args)
    {
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        //创建一个memcached客户端，所有对memcached中数据操作的方法都在这个类里面
        MemCachedClient memCachedClient= (MemCachedClient) applicationContext.getBean("memCachedClient");
        memCachedClient.set("name", "zhangsan");
        String name = memCachedClient.get("name").toString();
        System.out.println(">>> " +name);
    }
}
