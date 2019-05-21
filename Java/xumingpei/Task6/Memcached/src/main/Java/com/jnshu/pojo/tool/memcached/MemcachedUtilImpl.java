package com.jnshu.pojo.tool.memcached;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeoutException;

/**
 * @author pipiretrak
 * @date 2019/4/24 - 9:12
 */
@Component
public class MemcachedUtilImpl implements MemcachedUtil {
    private static Logger logger = Logger.getLogger(MemcachedUtilImpl.class);

    @Autowired
    MemcachedClient memCachedClient;

    @Override
    public Boolean set(String key,int exp,Object value) {
        try {
            Boolean rs =memCachedClient.set(key,exp,value);
            logger.info("存进去了没："+rs);
            return rs;
        }
        catch (MemcachedException e) {
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


    @Override
    public Boolean delete(String key) {
        try {
            boolean rs = memCachedClient.delete(key);
            logger.info("删除了没："+rs);
            return rs;
        }
        catch (MemcachedException e) {
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

    @Override
    public Object get(String key) {
        try {
            return memCachedClient.get(key);
        }
        catch (MemcachedException e) {
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
