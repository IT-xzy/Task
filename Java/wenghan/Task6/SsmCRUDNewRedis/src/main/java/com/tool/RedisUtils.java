package com.tool;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.*;

public class RedisUtils
{
    private static final String IP = "127.0.0.1"; // ip
    private static final int PORT = 6379;         // 端口
    private static final String AUTH="";          // 密码(原始默认是没有密码)
    private static int   MAX_ACTIVE = 1024;       // 最大连接数
    private static int   MAX_IDLE = 200;          // 设置最大空闲数
    private static int   MAX_WAIT = 10000;        // 最大连接时间
    private static int   TIMEOUT = 10000;         // 超时时间
    private static boolean BORROW = true;         // 在borrow一个事例时是否提前进行validate操作
    private static JedisPool pool;

    //初始化线程池
    static
    {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(MAX_ACTIVE);
        config.setMaxIdle(MAX_IDLE);
        config.setMaxWaitMillis(MAX_WAIT);
        config.setTestOnBorrow(BORROW);
        pool = new JedisPool(config, IP, PORT, TIMEOUT);
    }


    //获得连接
    private static synchronized  Jedis getJedis()
    {
        try
        {
            if(pool != null)
            {
                return pool.getResource();
            }
            else
            {
                return null;
            }
        }
        catch (Exception e) {
            return null;
        }

    }

    //插入对象
    public static boolean addObject(String key,Object obj)
    {
        Jedis jedis = null;
        try
        {
            jedis = getJedis();
            String code = jedis.set(key.getBytes(),serialize(obj));
            if(code.equals("OK"))
            {
                return true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            getColse(jedis);
        }
        return false;
    }

    //获得数据
    public static Object getObject(String key,Object object){
        Jedis jedis = null;
        try{
            jedis=getJedis();
            byte[] byt=jedis.get(key.getBytes());
            Object obj1=unserizlize(byt);
            if(obj1!=null){
                return obj1;
            }
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }finally {
            getColse(jedis);
        }
        return null;
    }


    //删除
    public static boolean delKey(String key)
    {
        Jedis jedis = null;
        try
        {
            jedis = getJedis();
            Long code = jedis.del(key);
            if(code > 1)
            {
                return true;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally {
            getColse(jedis);
        }
        return false;
    }

    //关闭连接
    public static void getColse(Jedis jedis)
    {
        if(jedis != null)
        {
            jedis.close();
        }
    }

    //序列化
    public static byte [] serialize(Object obj){
        ObjectOutputStream obi=null;
        ByteArrayOutputStream bai=null;
        try {
            bai=new ByteArrayOutputStream();
            obi=new ObjectOutputStream(bai);
            obi.writeObject(obj);
            byte[] byt=bai.toByteArray();
            return byt;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //反序列化
    public static Object unserizlize(byte[] byt){
        ObjectInputStream oii=null;
        ByteArrayInputStream bis=null;
        bis=new ByteArrayInputStream(byt);
        try {
            oii=new ObjectInputStream(bis);
            Object obj=oii.readObject();
            return obj;
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }
}
