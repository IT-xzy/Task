package utils.memcached;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeoutException;

@Component
public class AllStudentCache {
    @Autowired
    protected static MemcachedClient memcachedClient;
    protected int Exptime = 3600;
    static {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        memcachedClient = (MemcachedClient) applicationContext.getBean("memcachedClient");
    }
    private Logger logger = Logger.getLogger(AllStudentCache.class);

    //添加缓存
    public void set(String key,Object value){
        try {
            memcachedClient.set(key,Exptime,value);
            logger.error("添加成功！");
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            logger.error("添加缓存失败！");
            e.printStackTrace();
        }
    }
    //获得缓存内容
    public Integer get(String str){
        try {
            return memcachedClient.get(str);
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            logger.error("获得内容失败！");
            e.printStackTrace();
        }
        return null;
    }
    //删除缓存
    public void delete(String str){
        try {
            memcachedClient.delete(str);
            logger.error("删除成功！");
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            logger.error("删除失败！");
            e.printStackTrace();
        }
    }
    //更新缓存内容
    public void replace(String str,Object value){
        try {
            memcachedClient.replace(str,Exptime,value);
            logger.error("更新成功！");
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            logger.error("更新失败！");
            e.printStackTrace();
        }
    }
}
