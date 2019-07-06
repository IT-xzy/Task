package jnshu.cache;


import com.danga.MemCached.MemCachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component("MemCache")
public class MemcachImpl implements Cached{
    @Autowired
    MemCachedClient memCachedClient;
    @Override
    public Boolean set(String key, Object value) {
        Boolean state = memCachedClient.set(key,value);
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