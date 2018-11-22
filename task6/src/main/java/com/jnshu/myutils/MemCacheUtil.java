package com.jnshu.myutils;

import com.danga.MemCached.MemCachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemCacheUtil {
   // Logger logger = Logger.getLogger(MemCacheUtil.class.getName());
   @Autowired
    MemCachedClient memcacheClient;

    public <T> Boolean add(String key, Class<T> obj) {
        byte[] serializableValue = ProtoStuffSerializerUtil.serialize(obj);
        return memcacheClient.add(key,serializableValue);
    }

    public <T>  boolean set(String key, T obj){
        byte[] serializableValue = ProtoStuffSerializerUtil.serialize(obj);
        return  memcacheClient.set(key,serializableValue);
    }
    public  <T> T get(String key, Class<T> targetClass) {
        Object obj =memcacheClient.get(key);
        if( obj==null){
            return null;
        }else{
            return ProtoStuffSerializerUtil.deserialize((byte[])obj,targetClass);
        }
    }

    public <T> Boolean delete(String key) {
        return memcacheClient.delete(key);
    }

    public <T> Boolean replace(String key, Class<T> obj) {
        byte[] serializableValue = ProtoStuffSerializerUtil.serialize(obj);
        return memcacheClient.replace(key,serializableValue);
    }

    public Boolean flush() {
        return memcacheClient.flushAll();
    }
}
