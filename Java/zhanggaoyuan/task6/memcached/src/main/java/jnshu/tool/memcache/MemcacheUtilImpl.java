package jnshu.tool.memcache;

import com.alibaba.fastjson.JSON;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeoutException;


@Component
public class MemcacheUtilImpl implements MemcacheUtil{

    private static Logger logger = Logger.getLogger (String.valueOf (MemcacheUtilImpl.class));

//
//    ApplicationContext build = new ClassPathXmlApplicationContext("xmemcache.xml");
//
//    MemcachedClient memcachedClient = (MemcachedClient) build.getBean("memcachedClient");
    @Autowired
    MemcachedClient memcachedClient;
    /**
     *
     * @param key key值
     * @param exp   缓存过期时间，0永不过期
     * @param value 就是值啦
     * @return  一个Boolean值
     */
    @Override
    public  Boolean saveMemcache( String key,int exp, Object value) {


//        先是调用XMemcacheClient.set(final String key, final int exp, final Object value)方法，
// key形参对应字符串“key”，exp形参对应整数0（表达缓存永不过期）
        try {
          Boolean rs= memcachedClient.set(key, exp, value);
            Object v = memcachedClient.get(key);
            logger.info ("存进去的是："+ JSON.toJSONString (v));
            return rs;

        } catch (MemcachedException e) {
            System.err.println("MemcachedClient operation fail");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        } catch (TimeoutException e) {
            System.err.println("MemcachedClient operation timeout");
            e.printStackTrace();
            return false;
        } catch ( InterruptedException e ) {
            e.printStackTrace ();
            return false;
        }
    }

    /**
     * 删除key对应的缓存
     * @param key
     * @return Boolean值
     */

    @Override
    public Boolean delMemcache(String key) {
        try {
         Boolean rs=memcachedClient.delete(key);
            logger.info ("删除"+key+":"+rs);
            return rs;
        } catch (MemcachedException e) {
            System.err.println("MemcachedClient operation fail");
            System.out.println(e.getMessage());
            e.printStackTrace();
            return false;
        } catch (TimeoutException e) {
            System.err.println("MemcachedClient operation timeout");
            e.printStackTrace();
            return false;
        } catch (InterruptedException e) {
            e.printStackTrace ();
            return false;
        }
    }

    /**
     * 取缓存里的值
     * @param key
     * @return  返回一个object类型的值
     */
    @Override
    public Object getMemcache(String key) {

        try {
            return memcachedClient.get(key);
        } catch (MemcachedException e) {
            System.err.println("MemcachedClient operation fail");
            e.printStackTrace();
            return null;
        } catch (TimeoutException e) {
            System.err.println("MemcachedClient operation timeout");
            e.printStackTrace();
            return null;
        } catch (InterruptedException e) {e.printStackTrace ();
            return null;
        }

    }

}

