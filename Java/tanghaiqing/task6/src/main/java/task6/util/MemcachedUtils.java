package task6.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool;
import org.apache.log4j.Logger;


/**
 * @author peiyu
 */
public final class MemcachedUtils {

    /**
     * cachedClient.
     */
    private static Logger logger =Logger.getLogger(MemcachedUtils.class);
    private static SockIOPool sockIOPool;
    static {
        if (sockIOPool==null){
            //使用的服务器，由于是在本地测试，只有一个服务器地址。默认端口是11211
            //格式为 服务器IP:端口号
            String [] addr={"127.0.0.1:11211"};
            /**
             * 设置权重，与设定的服务器一一对应
             */
            Integer[] weight={3};
            //建立通信的连接池
            sockIOPool=SockIOPool.getInstance();
            //设置连接池可用cache服务器列表，服务器构成形式：ip地址+端口号
            sockIOPool.setServers(addr);
            //设置连接池可用cache服务器的权重，和server数组的位置一一对应
            sockIOPool.setWeights(weight);
            //设置初始连接数
            sockIOPool.setInitConn(5);
            //设置最小连接数
            sockIOPool.setMinConn(5);
            //设置最大连接数
            sockIOPool.setMaxConn(200);
            //设置可用连接的最长等待时间
            sockIOPool.setMaxIdle(1000*30*30);
            //设置连接池维护线程的睡眠时间，设置为0，维护线程不启动
            sockIOPool.setMaintSleep(30);
            //设置Nagle算法，设置为false，因为通讯数据量比较大要求相应及时
            sockIOPool.setNagle(false);
            //设置socket读取等待超时时间
            sockIOPool.setSocketTO(30);
            //设置连接等待超时值
            sockIOPool.setSocketConnectTO(0);
            //设置完参数后，启动pool
            sockIOPool.initialize();
        }
    }
    //@Resource(name = "memcachedPool")
    //private SockIOPool sockIOPool;
    private static MemCachedClient cachedClient;
    static {
        if (cachedClient == null) {
            cachedClient = new MemCachedClient();

        }
    }
    /**
     * 构造函数.
     */
    private MemcachedUtils() {
    }
    /**
     * 向缓存添加新的键值对。如果键已经存在，则之前的值将被替换.
     * @param key 键
     * @param value 值
     * @return boolean
     */
    public static boolean set(String key, Object value) {
        return setExp(key, value, null);
    }
    /**
     * 向缓存添加新的键值对。如果键已经存在，则之前的值将被替换.
     * @param key 键
     * @param value 值
     * @param expire 过期时间 New Date(1000*10)：十秒后过期
     * @return boolean
     */
    public static boolean set(String key, Object value, Date expire) {
        return setExp(key, value, expire);
    }
    /**
     * 向缓存添加新的键值对。如果键已经存在，则之前的值将被替换.
     * @param key 键
     * @param value 值
     * @param expire 过期时间 New Date(1000*10)：十秒后过期
     * @return boolean
     */
    private static boolean setExp(String key, Object value, Date expire) {
        boolean flag = false;
        try {
            flag = cachedClient.set(key, value, expire);
        } catch (Exception e) {
           logger.error("Memcached set方法报错，key值：" + key + "\r\n" + exceptionWrite(e));
        }
        return flag;
    }
    /**
     * 仅当缓存中不存在键时，add 命令才会向缓存中添加一个键值对.
     * @param key 键
     * @param value 值
     * @return boolean
     */
    public static boolean add(String key, Object value) {
        return addExp(key, value, null);
    }
    /**
     * 仅当缓存中不存在键时，add 命令才会向缓存中添加一个键值对.
     * @param key 键
     * @param value 值
     * @param expire 过期时间 New Date(1000*10)：十秒后过期
     * @return boolean
     */
    public static boolean add(String key, Object value, Date expire) {
        return addExp(key, value, expire);
    }
    /**
     * 仅当缓存中不存在键时，add 命令才会向缓存中添加一个键值对.
     * @param key 键
     * @param value 值
     * @param expire 过期时间 New Date(1000*10)：十秒后过期
     * @return boolean
     */
    private static boolean addExp(String key, Object value, Date expire) {
        boolean flag = false;
        try {
            flag = cachedClient.add(key, value, expire);
        } catch (Exception e) {
            logger.error("Memcached add方法报错，key值：" + key + "\r\n" + exceptionWrite(e));
        }
        return flag;
    }
    /**
     * 仅当键已经存在时，replace 命令才会替换缓存中的键.
     * @param key 键
     * @param value 值
     * @return boolean
     */
    public static boolean replace(String key, Object value) {
        return replaceExp(key, value, null);
    }
    /**
     * 仅当键已经存在时，replace 命令才会替换缓存中的键.
     * @param key 键
     * @param value 值
     * @param expire 过期时间 New Date(1000*10)：十秒后过期
     * @return boolean
     */
    public static boolean replace(String key, Object value, Date expire) {
        return replaceExp(key, value, expire);
    }
    /**
     * 仅当键已经存在时，replace 命令才会替换缓存中的键.
     * @param key 键
     * @param value 值
     * @param expire 过期时间 New Date(1000*10)：十秒后过期
     * @return boolean
     */
    private static boolean replaceExp(String key, Object value, Date expire) {
        boolean flag = false;
        try {
            flag = cachedClient.replace(key, value, expire);
        } catch (Exception e) {
            logger.info("Memcached replace方法报错，key值：" + key + "\r\n" + exceptionWrite(e));
        }
        return flag;
    }
    /**
     * get 命令用于检索与之前添加的键值对相关的值.
     * @param key 键
     * @return boolean
     */
    public static Object get(String key) {
        Object obj = null;
        try {
            obj = cachedClient.get(key);
        } catch (Exception e) {
            logger.info("Memcached get方法报错，key值：" + key + "\r\n" + exceptionWrite(e));
        }
        return obj;
    }
    /**
     * 删除 memcached 中的任何现有值.
     * @param key 键
     * @return boolean
     */
    public static boolean delete(String key) {
        return deleteExp(key, null);
    }
    /**
     * 删除 memcached 中的任何现有值.
     * @param key 键
     * @param expire 过期时间 New Date(1000*10)：十秒后过期
     * @return boolean
     */
    public static boolean delete(String key, Date expire) {
        return deleteExp(key, expire);
    }
    /**
     * 删除 memcached 中的任何现有值.
     * @param key 键
     * @param expire 过期时间 New Date(1000*10)：十秒后过期
     * @return boolean
     */
    @SuppressWarnings("deprecation")
    private static boolean deleteExp(String key, Date expire) {
        boolean flag = false;
        try {
            flag = cachedClient.delete(key, expire);
        } catch (Exception e) {
            logger.info("Memcached delete方法报错，key值：" + key + "\r\n" + exceptionWrite(e));
        }
        return flag;
    }
    /**
     * 清理缓存中的所有键/值对.
     * @return boolean
     */
    public static boolean flashAll() {
        boolean flag = false;
        try {
            flag = cachedClient.flushAll();
        } catch (Exception e) {
            logger.info("Memcached flashAll方法报错\r\n" + exceptionWrite(e));
        }
        return flag;
    }
    /**
     * 返回异常栈信息，String类型.
     * @param e Exception
     * @return boolean
     */
    private static String exceptionWrite(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        pw.flush();
        return sw.toString();
    }

    public static void main(String[] args) {
        System.out.println(MemcachedUtils.set("111", "haiqing",new Date(1000*100)));
        System.out.println(MemcachedUtils.get("111"));
        //ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring-memcached.xml");
        //applicationContext.getBean("memcachedPool");
        //System.out.println(sockIOPool);
    }
}
