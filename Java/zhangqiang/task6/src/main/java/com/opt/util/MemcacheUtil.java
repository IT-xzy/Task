package com.opt.util;

import com.whalin.MemCached.MemCachedClient;
import org.apache.log4j.Logger;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

/**
 * Memcache缓存工具类
 *
 * @Title: MemcacheUtil
 * @Description: TODO
 * @author By.Z
 * @date 2018-06-16 15：15
 */
    public class MemcacheUtil {

    private static Logger logger = Logger.getLogger(MemcacheUtil.class);
    private static MemCachedClient cachedClient;

    /* 实例化 MemCachedClient, */
    static {
        if (cachedClient == null) {
            System.out.println("初始化中...");
            cachedClient = new MemCachedClient("memCachedPool");
        }
    }

    // 空的构造函数
    private MemcacheUtil() {
    }

    // set方法 由于形参不同,方法重载

    /**
     * @Description: 无过期时间, 向缓存添加新的键值对,如果键已经存在,那么值将被替换
     * @Param: [key, value] 键, 值
     * @return: boolean
     * @Author: Mr.Wang
     * @Date: 2018/5/18
     */
    public static boolean set(String key, Object value) {
        return setExp(key, value, null);
    }

    /**
     * @Description: 有过期时间, 向缓存添加新的键值对,如果键已经存在,那么值将被替换
     * @Param: [key, value, expire] 键, 值, 过期时间
     * @return: boolean
     * @Author: Mr.Wang
     * @Date: 2018/5/18
     */
    public static boolean set(String key, Object value, Date expire) {
        return setExp(key, value, expire);
    }


    /**
     * @Description: set实际执行方法 向缓存添加新的键值对。如果键已经存在，则之前的值将被替换。
     * @Param: [key, value, expire] 键, 值, 过期时间
     * @return: boolean
     * @Author: Mr.Wang
     * @Date: 2018/5/18
     */
    private static boolean setExp(String key, Object value, Date expire) {
        boolean flag = false;
        try {
            flag = cachedClient.set(key, value, expire);
        } catch (Exception e) {
            logger.error("Memcached get方法报错，key值：" + key + "\r\n" + exceptionWrite(e));
        }
        return flag;
    }
   /* set end */




   /* add 重载方法*/

    /**
     * @Description: 不带过期时间 仅当缓存中不存在键时，add 命令才会向缓存中添加一个键值对。
     * @Param: [key, value] 键, 值
     * @return: boolean
     * @Author: Mr.Wang
     * @Date: 2018/5/18
     */
    public static boolean add(String key, Object value) {
        return addExp(key, value, null);
    }

    /**
     * @Description: 带过期时间 仅当缓存中不存在键时，add 命令才会向缓存中添加一个键值对。
     * @Param: [key, value, date] 键, 值, 过期时间
     * @return: boolean
     * @Author: Mr.Wang
     * @Date: 2018/5/18
     */
    public static boolean add(String key, Object value, Date date) {
        return addExp(key, value, date);
    }

    /**
     * @Description: add实际执行方法 仅当缓存中不存在键时，add 命令才会向缓存中添加一个键值对。
     * @Param: [key, value, expire] 键, 值, 过期时间
     * @return: boolean
     * @Author: Mr.Wang
     * @Date: 2018/5/18
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
   /* add end*/




   /* replace 重载 */

    /**
     * @Description: 无过期时间 仅当键已经存在时，replace 命令才会替换缓存中的键。
     * @Param: [key, value] 键, 值
     * @return: boolean
     * @Author: Mr.Wang
     * @Date: 2018/5/18
     */
    public static boolean replace(String key, Object value) {
        return replaceExp(key, value, null);
    }

    /**
     * @Description: 有过期时间 仅当键存在时, replace 命令才会替换缓存中的键
     * @Param: [key, value, expire] 键, 值, 过期时间
     * @return: boolean
     * @Author: Mr.Wang
     * @Date: 2018/5/18
     */
    public static boolean replace(String key, Object value, Date expire) {
        return replaceExp(key, value, expire);
    }

    /**
     * @Description: replace 实际执行方法, 仅当键已经存在时，replace 命令才会替换缓存中的键。
     * @Param: [key, value, expire] 键, 值, 过期时间
     * @return: boolean
     * @Author: Mr.Wang
     * @Date: 2018/5/18
     */
    private static boolean replaceExp(String key, Object value, Date expire) {
        boolean flag = false;
        try {
            flag = cachedClient.replace(key, value, expire);
        } catch (Exception e) {
            logger.error("Memcached replace方法报错，key值：" + key + "\r\n" + exceptionWrite(e));
        }
        return flag;
    }
   /* replace end */



   /* get */

    /**
     * @Description: 用于检索之前添加的键值 获取其相对的值
     * @Param: [key] 键
     * @return: java.lang.Object
     * @Author: Mr.Wang
     * @Date: 2018/5/18
     */
    public static Object get(String key) {
        Object object = null;
        try {
            System.out.println("get key : " + key);
            object = cachedClient.get(key);
        } catch (Exception e) {
            logger.error("Memcached get方法报错，key值：" + key + "\r\n" + exceptionWrite(e));
        }
        return object;
    }
   /* get end*/




   /* delete */
    /**
     * @Description: 删除 memcached 中的任何现有值。
     * @Param: [key] 键
     * @Param: @SuppressWarnings("deprecation") 抑制相对于弃用的警告
     * @return: boolean
     * @Author: Mr.Wang
     * @Date: 2018/5/18
     */
    // @SuppressWarnings("deprecation") 这里不使用废弃的方法
    public static boolean delete(String key){
        boolean flag = false;
        try {
            flag = cachedClient.delete(key);
        } catch (Exception e){
            logger.error("Memcached delete方法报错，key值：" + key + "\r\n" + exceptionWrite(e));
        }
        return false;
    }
   /* delete end*/



   /* flash */
    /**
     * @Description: 清理缓存中的所有键/值对
     * @Param: []
     * @return: boolean
     * @Author: Mr.Wang
     * @Date: 2018/5/18
     */
    public static boolean flashAll(){
        boolean flag = false;
        try {
            flag = cachedClient.flushAll();
        } catch (Exception e){
            logger.error("Memcached flashAll方法报错\r\n" + exceptionWrite(e));
        }
        return flag;
    }
   /* flash end*/

    /**
     * @Description: 返回堆栈信息
     * @Param: [e] 异常信息
     * @return: java.lang.String
     * @Author: Mr.Wang
     * @Date: 2018/5/18
     */
    private static String exceptionWrite(Exception e) {
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        pw.flush();
        return sw.toString();
    }

}