package memcached;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeoutException;

@Component
public class CacheManager {
    @Autowired
     XMemcachedClientBuilder memcachedClientBuilder;
    @Autowired
     MemcachedClient memcachedClient;
//    如果spring初始化创建失败就再创建一次
    private MemcachedClient getMemcachedClient() throws Exception{
      if (memcachedClient ==null) {
          return memcachedClient = memcachedClientBuilder.build();
      }
      return null;
    }

    private static final int expire = 60*60*3; //设置缓存过期时间3小时
    private static final Long opTimeout = 5000L; //设置最长等待时间5秒


    private Logger log = LoggerFactory.getLogger(CacheManager.class);

    public <T> T get(String key) {
        T t=null;
        try {
            t = memcachedClient.get(key, opTimeout);
            log.info("读取缓存 key:"+key);
        }
        //超时异常引发的中断异常及memcached自身引起的异常，需要处理
        catch (TimeoutException | InterruptedException | MemcachedException e) {
            e.printStackTrace();
        }
        return t;
    }

    public void add(String key, Object value) {
        try {
            if (memcachedClient.set(key,expire,value)) {
                log.info("增加缓存  key:" + key + "过期时间:" + expire + "value:" + value);
            }
        }
        catch (TimeoutException | InterruptedException | MemcachedException e) {
            e.printStackTrace();
        }
    }

    public void delete(String key){
        try {
            memcachedClient.delete(key,opTimeout);
            log.info("删除缓存 key:"+key);
        } catch (TimeoutException | InterruptedException | MemcachedException e) {
            e.printStackTrace();
        }
    }
}
