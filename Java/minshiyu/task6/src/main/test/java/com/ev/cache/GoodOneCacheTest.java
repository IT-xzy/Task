package com.ev.cache;

import com.ev.entity.GoodOne;
import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeoutException;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class GoodOneCacheTest {

    @Autowired
    MemcachedClient memcachedClient;

    @Test
    public void testCache() throws Exception {
        boolean var1=memcachedClient.set("var1", 0, "this is var 1.");
        System.out.println((char[]) memcachedClient.get("var1"));
    }

}