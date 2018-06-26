package com.longhang.memcache;

import com.longhang.model.Student;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;


public class Memcache {
    private static Logger logger = Logger.getLogger("Memcaceh.class");
    @Autowired
    private XMemcachedClientBuilder memcachedClientBuilder;
    @Autowired
    private MemcachedClient memcachedClient;

    //    private MemcachedClient createClient() throws Exception{
//        if(memcachedClient==null){//如果spring没有创建成功，再build一次
//            return memcachedClient = memcachedClientBuilder.build();
//        }
//        return null;
//    }

    public Map<String, Student> queryFromCache(List<String> keys) {
        Map<String, Student> students = new HashMap<String, Student>();
        for (String key : keys) {
            try {
                Student student = memcachedClient.get(key);
                //memcachedClient.
                students.put(key, student);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (MemcachedException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            }
        }
        return students;
    }

}
