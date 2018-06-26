package utils;

import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RedisCacheManagerTest {
    private RedisCacheManager redisCacheManager = new RedisCacheManager();
    @Test
    public void test1(){
        redisCacheManager.set("key1","value1");
        System.out.println(redisCacheManager.get("key1"));
        redisCacheManager.replace("key5","v2");
        System.out.println(redisCacheManager.get("key5"));
        redisCacheManager.delete("key1");
        System.out.println(redisCacheManager.get("key1"));
    }

    @Test
    public void test2(){
        Map<String,Object> map = new HashMap<>();
        map.put("k2","v2");
        map.put("k3","v3");
        redisCacheManager.set(map);
        List<String> list = new ArrayList<>();
        list.add("k2");
        list.add("k3");
        System.out.println(redisCacheManager.get(list));
    }
}