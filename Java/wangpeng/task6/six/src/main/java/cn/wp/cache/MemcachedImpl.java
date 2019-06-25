package cn.wp.cache;

import com.danga.MemCached.MemCachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/** @ClassName: @Description: @Author: 老王 @Date: 2019/5/31 19:39 @Version: 1.0 */
@Service("MemCached")
public class MemcachedImpl implements Cached {
  @Autowired MemCachedClient memCachedClient;

  @Override
  public Boolean set(String key, Object value) {
    Boolean state = memCachedClient.set(key, value);
    return state;
  }

  @Override
  public Boolean delete(String key) {
    Boolean state = memCachedClient.delete(key);
    return state;
  }

  @Override
  public Object get(String key) {
    return memCachedClient.get(key);
  }
}
