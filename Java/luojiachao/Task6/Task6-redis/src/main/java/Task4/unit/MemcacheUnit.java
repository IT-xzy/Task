package Task4.unit;

import net.rubyeye.xmemcached.MemcachedClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemcacheUnit {

//    private static ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
//    private static MemcachedClient memcachedClient = (MemcachedClient) app.getBean("memcachedClient");
    @Autowired
    private  MemcachedClient memcachedClient;
//
//    public MemcachedClient getMemcachedClient() {
//        return memcachedClient;
//    }
//
//    public void setMemcachedClient(MemcachedClient memcachedClient) {
//        this.memcachedClient = memcachedClient;
//    }

    /***
     * 添加缓存
     *
     * @param key
     * @param value
     * @param expiry
     *            超时时间（单位：分钟）
     * @throws Exception
     */
    public void set(String key, Object value, int expiry) throws Exception {
//        System.out.println("key==="+key+"==="+"value===="+value+expiry);
        //Date date = new Date();
        //date.setTime(date.getTime() + expiry * 60 * 1000);
        memcachedClient.set(key, expiry, value);
    }


    public Object get(String key) throws Exception {
        try {
            System.out.println("获取key");
            return memcachedClient.get(key);
        } catch (Exception e) {
            System.out.println("无效key");
            return null;
        }
    }


//        if (StringUtils.isEmpty(key)) {
//            throw new IllegalArgumentException("参数错误！");
//        }
//            return memcachedClient.get(key);


        public void delete (String key) throws Exception {
//        if (StringUtils.isEmpty(key)) {
//            throw new IllegalArgumentException("参数错误！");
//        }
            memcachedClient.delete(key);
        }
    }
