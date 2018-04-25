package com.fml.cache;

import com.fml.mapper.StudentMapper;
import net.rubyeye.xmemcached.Counter;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeoutException;

@Component
public class StudentCache extends MemcachedBasis {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentCache .class);

    @Autowired
    StudentMapper studentMapper;


    /**
     * 设置缓存
     * @param value 缓存数据
     * @return
     */
    public Boolean set(String key, Object value) {
        Boolean result = false;
        try {
            result = memcachedClient.set(key, super.Exptime, value);
        } catch (Exception e) {
            LOGGER.error("设置学员缓存失败！", e);
        }
        return result;
    }


    /**
     * 获取缓存
     * @param key 缓存Key
     * @return
     */
    public Object get(String key) {
        Object object = new Object();
        try {
            object = memcachedClient.get(key);
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            LOGGER.error("读取学员缓存失败！",e);
            e.printStackTrace();
        }
        return object;
    }



    /**
     * 删除缓存
     * @param key 缓存key
     * @return
     */
    public boolean delete(String key) {
        try {
            return memcachedClient.delete(key);
        } catch (Exception e) {
            LOGGER.error("删除学员缓存失败！", e);
        }
        return false;
    }
}
