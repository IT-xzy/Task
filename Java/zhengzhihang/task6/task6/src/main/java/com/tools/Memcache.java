package com.tools;
import com.danga.MemCached.MemCachedClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import java.util.Date;


@Repository
public class Memcache {

    private static MemCachedClient memCachedClient;
    static {
        ApplicationContext ap=new ClassPathXmlApplicationContext("spring-memcache.xml");
        memCachedClient= (MemCachedClient) ap.getBean("memCachedClient");
    }

    //覆盖Key值
    public static boolean setKey(String key,  Object object ,long expire){
        return memCachedClient.set(key,object,new Date(expire));
    }

    //增加Key值
    public static boolean addKey(String key,Object object,long expire){
        return memCachedClient.add(key,object,new Date(expire));
    }

    //delete
     public static boolean deleteKet(String key){
        return memCachedClient.delete(key);
    }

    //get
    public static Object getKey(String key){
        return memCachedClient.get(key);
    }

//    //gets 查找该键是否存在
//    public static

    //flush
    public static boolean flush(){
        return memCachedClient.flushAll();
    }


    public static void main(String[] args) {
       Memcache.flush();
    }


}
