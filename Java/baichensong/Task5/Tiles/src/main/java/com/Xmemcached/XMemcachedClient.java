//package com.Xmemcached;
//
//import net.rubyeye.xmemcached.MemcachedClient;
//
//import org.apache.commons.lang3.StringUtils;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//
//public class XMemcachedClient {
//
//    protected org.slf4j.Logger logger = LoggerFactory
//            .getLogger(this.getClass());
//
//    @Autowired
//    private MemcachedClient memcachedClient;
////    /***
////     * 添加缓存
////     *
////     * @param key
////     * @param value
////     * @param expiry
////     *            超时时间（单位：分钟）
////     * @throws Exception
////     */
//    public void addCache(String key, Object value, int expiry) throws Exception {
//
//        if (StringUtils.isEmpty(key) || value == null) {
//            throw new IllegalArgumentException("参数错误！");
//        }
//        boolean isCache = memcachedClient.add(key, expiry*60, value);
//
//        if (!isCache) {
//            throw new IllegalStateException("缓存存储失败！");
//        }
//    }
//
//    public Object findCache(String key) throws Exception {
//        if (StringUtils.isEmpty(key)) {
//            throw new IllegalArgumentException("参数错误！");
//        }
//        return memcachedClient.get(key);
//    }
//
//    public void deleteCache(String key) throws Exception {
//        if (StringUtils.isEmpty(key)) {
//            throw new IllegalArgumentException("参数错误！");
//        }
//        memcachedClient.delete(key);
//    }
//}
