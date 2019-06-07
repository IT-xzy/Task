package cn.wp.cache;

/** @ClassName: @Description: @Author: 老王 @Date: 2019/5/31 19:38 @Version: 1.0 */
public interface Cached {

  Boolean set(String key, Object value);

  Boolean delete(String key);

  Object get(String key);
}
