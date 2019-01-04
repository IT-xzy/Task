package jnshu.tool.memcache;

public interface MemcacheUtil {

      Boolean saveMemcache( String key,int exp, Object value);

     Boolean delMemcache(String key);

     Object getMemcache(String key);
}
