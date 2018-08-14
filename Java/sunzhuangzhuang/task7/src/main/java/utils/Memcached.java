//package utils;//package utils;
//
//import net.rubyeye.xmemcached.MemcachedClient;
//import net.rubyeye.xmemcached.exception.MemcachedException;
//import org.apache.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.stereotype.Component;
//
//import java.util.concurrent.TimeoutException;
//
//@Component
//public class Memcached {
//    @Autowired
//    protected static MemcachedClient memcachedClient;
//    protected int Exptime = 3600;
//    static {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
//        memcachedClient = applicationContext.getBean(MemcachedClient.class);
//    }
//    private Logger logger = Logger.getLogger(Memcached.class);
//
//    //添加缓存 如果set的key已经存在，该命令可以更新该key所对应的原来的数据，也就是实现更新的作用。
//    public void set(String key,Object value){
//        try {
//            memcachedClient.set(key,Exptime,value);
//            logger.error("添加成功！");
//        } catch (TimeoutException | InterruptedException | MemcachedException e) {
//            logger.error("添加缓存失败！");
//            e.printStackTrace();
//        }
//    }
//
//    //添加缓存 如果 add 的 key 已经存在，则不会更新数据(过期的 key 会更新)，之前的值将仍然保持相同，并且您将获得响应 NOT_STORED。
//    public void add(String key,Object value){
//        try {
//            memcachedClient.add(key,Exptime,value);
//            logger.error("添加成功！");
//        } catch (TimeoutException | InterruptedException | MemcachedException e) {
//            logger.error("添加缓存失败！");
//            e.printStackTrace();
//        }
//    }
//
//    //获得缓存内容
//    public Object get(String str){
//        try {
//            return memcachedClient.get(str);
//        } catch (TimeoutException | InterruptedException | MemcachedException e) {
//            logger.error("获得内容失败！");
//            e.printStackTrace();
//        }
//        return null;
//    }
//    //删除缓存
//    public void delete(String str){
//        try {
//            memcachedClient.delete(str);
//            logger.error("删除成功！");
//        } catch (TimeoutException | InterruptedException | MemcachedException e) {
//            logger.error("删除失败！");
//            e.printStackTrace();
//        }
//    }
//    //更新缓存内容 如果 key 不存在，则替换失败，并且您将获得响应 NOT_STORED。
//    public void replace(String str,Object value){
//        try {
//            memcachedClient.replace(str,Exptime,value);
//            logger.error("更新成功！");
//        } catch (TimeoutException | InterruptedException | MemcachedException e) {
//            logger.error("更新失败！");
//            e.printStackTrace();
//        }
//    }
//}
