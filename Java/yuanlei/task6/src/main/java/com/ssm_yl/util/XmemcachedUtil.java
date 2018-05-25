//package com.ssm_yl.util;
//
//import net.rubyeye.xmemcached.MemcachedClient;
//import net.rubyeye.xmemcached.exception.MemcachedException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.TimeoutException;
//
//@Component
//public class XmemcachedUtil {
//    @Autowired
//    MemcachedClient memcachedClient;
//     private Logger logger = LoggerFactory.getLogger(XmemcachedUtil.class);
//    public <T> T get(String key){
//        T result = null;
//        try {
//            result= memcachedClient.get(key);
//            logger.info("获取缓存:",result);
//        } catch (TimeoutException | MemcachedException | InterruptedException e) {
//            e.printStackTrace();
//        }
//          return result;
//    }
//
//    public  void set(String key,int var1,Object var2){
//        try {
//             memcachedClient.set(key,var1,var2);
//             logger.info("设置缓存",key);
//        } catch (TimeoutException | InterruptedException | MemcachedException e) {
//            e.printStackTrace();
//        }
//    }
//}
