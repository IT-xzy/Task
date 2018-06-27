package utils;

import net.rubyeye.xmemcached.exception.MemcachedException;
import org.junit.Test;
import pojo.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class XmemcachedManagerTest {
    private XmemcachedManager xmemcachedManager = new XmemcachedManager();
    @Test
    public void setAndGet() throws InterruptedException, MemcachedException, TimeoutException {
        xmemcachedManager.set("key3","value3");
        xmemcachedManager.set("key4","value4");
        Object obj = xmemcachedManager.get("key3");
        List<String> list = new ArrayList<>();
        list.add("key3");
        list.add("key4");
        Map<String,Object> map =xmemcachedManager.get(list);
        System.out.println("set:"+obj+":"+map);
    }
    @Test
    public void replace() throws InterruptedException, MemcachedException, TimeoutException {
        xmemcachedManager.replace("key3","value5");
        Object obj = xmemcachedManager.get("key3");
        System.out.println("replace:"+obj);
    }
    @Test
    public void delete() throws InterruptedException, MemcachedException, TimeoutException {
        xmemcachedManager.delete("key3");
        Object obj = xmemcachedManager.get("key3");
        System.out.println("delete:"+obj);
    }

    @Test
    public void setObject() throws InterruptedException, MemcachedException, TimeoutException {
        User user = new User();
        user.setPassword("123456");
        user.setName("cache");
        xmemcachedManager.set("user",user);
        User user1 = (User) xmemcachedManager.get("user");
        System.out.println("setObj:"+user1);
    }
}