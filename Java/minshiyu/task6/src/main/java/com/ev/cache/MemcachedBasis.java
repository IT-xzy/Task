package com.ev.cache;

import net.rubyeye.xmemcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemcachedBasis {
    final MemcachedClient memcachedClient;

    /**
     * 失效时间（秒）3600*24 一天
     */
    int Exptime = 3600 * 24;

    /**
     * 基础数据失效时间（秒）3600*24*7 一周
     */
    protected int DataExptime = this.Exptime * 7;

    String Prefix = "SpringDemo:";

    @Autowired
    public MemcachedBasis(MemcachedClient memcachedClient) {
        this.memcachedClient = memcachedClient;
    }
}
