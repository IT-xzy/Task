package wyq.webapp.util;

import com.whalin.MemCached.MemCachedClient;
import org.springframework.stereotype.Component;
import wyq.webapp.pojo.Engineer;

import java.util.Date;
import java.io.PrintWriter;
import java.io.StringWriter;


@Component
public class MemcachedUtil {

    private static MemCachedClient cachedClient;
    static {
        if(cachedClient == null){
            cachedClient = new MemCachedClient("memcachedpool");
        }
    }

    private MemcachedUtil(){
    }

    public static boolean set(String key, Object value) {
        return setExp(key, value, null);
    }

    public static boolean set(String key, Object value, Date expire) {
        return setExp(key, value, expire);
    }

    private static boolean setExp(String key, Object value, Date expire) {
        boolean flag = false;
        try {
            flag = cachedClient.set(key, value, expire);
        } catch (Exception e) {
            System.out.println("Memcached set方法报错，key值：" + key + "\r\n" + exceptionWrite(e));
        }
        return flag;
    }

    public static boolean add(String key, Object value) {
        return addExp(key, value, null);
    }

    public static boolean add(String key, Object value, Date expire) {
        return addExp(key, value, expire);
    }

    private static boolean addExp(String key, Object value, Date expire) {
        boolean flag = false;
        try {
            flag = cachedClient.add(key, value, expire);
        } catch (Exception e) {
            System.out.println("Memcached add方法报错，key值：" + key + "\r\n" + exceptionWrite(e));
        }
        return flag;
    }

    public static boolean replace(String key, Object value) {
        return replaceExp(key, value, null);
    }

    public static boolean replace(String key, Object value, Date expire) {
        return replaceExp(key, value, expire);
    }

    private static boolean replaceExp(String key, Object value, Date expire) {
        boolean flag = false;
        try {
            flag = cachedClient.replace(key, value, expire);
        } catch (Exception e) {
            System.out.println("Memcached replace方法报错，key值：" + key + "\r\n" + exceptionWrite(e));
        }
        return flag;
    }

    public static Object get(String key) {
        Object obj = null;
        try {
            obj = cachedClient.get(key);
        } catch (Exception e) {
            System.out.println("Memcached get方法报错，key值：" + key + "\r\n" + exceptionWrite(e));
        }
        return obj;
    }

    public static boolean delete(String key) {
        return deleteExp(key, null);
    }

    public static boolean delete(String key, Date expire) {
        return deleteExp(key, expire);
    }

    @SuppressWarnings("deprecation")
    private static boolean deleteExp(String key, Date expire) {
        boolean flag = false;
        try {
            flag = cachedClient.delete(key, expire);
        } catch (Exception e) {
            System.out.println("Memcached delete方法报错，key值：" + key + "\r\n" + exceptionWrite(e));
        }
        return flag;
    }

    public static boolean flashAll() {
        boolean flag = false;
        try {
            flag = cachedClient.flushAll();
        } catch (Exception e) {
            System.out.println("Memcached flashAll方法报错\r\n" + exceptionWrite(e));
        }
        return flag;
    }

    private static String exceptionWrite(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        pw.flush();
        return sw.toString();

    }

//    public static void main(String[] args){
//        MemCachedClient memCachedClient = new MemCachedClient();
//        Engineer engineer = new Engineer();
//        engineer.setId(123);
//        engineer.setCreateTime(123);
//        System.out.println(engineer);
//        memCachedClient.add("obj",engineer);
//        Object obj = memCachedClient.get("obj");
//        System.out.println(obj);
//        memCachedClient.add("test1","gayfeng");
//        String result = memCachedClient.get("test1");
//
//    }
}
