package com.tool;

import com.alibaba.fastjson.JSONObject;
import com.pojo.User;
import redis.clients.jedis.Jedis;
import java.io.*;

public class MyRedisTool {

    private static Jedis jedis = new Jedis("localhost");

    //获得连接
    private static Jedis getJedis(){
        System.out.println(jedis.ping());
        return jedis;
    }

    //添加对象
    static boolean addObject(String key, Object obj)
    {
        Jedis jedis;
        jedis = getJedis();
        //添加对象，将传入的对象先通过序列化方法转为二进制，key也需要转为字节
        String code = jedis.set(key.getBytes(),serialize(obj));
        //获得对象
        byte[] byt=jedis.get(key.getBytes());
        Object obj1=unserizlize(byt);
        return code.equals("OK");
    }

    //获得数据
    public static Object getObject(String key,Object object){
        Jedis jedis = null;
        try{
            jedis=getJedis();
            String value=jedis.get(key);
            User o=(User)JSONObject.parseObject(value,object.getClass());
            return o;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //删除键值对
    public static boolean delKey(String key)
    {
        Jedis jedis;
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
            return false;
        }
        return false;
    }

    //序列化
    private static byte [] serialize(Object obj){
        ObjectOutputStream obi;
        ByteArrayOutputStream bai;
        try {
            bai=new ByteArrayOutputStream();
            obi=new ObjectOutputStream(bai);
            obi.writeObject(obj);
            return bai.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //反序列化
    private static Object unserizlize(byte[] byt){
        ObjectInputStream oii;
        ByteArrayInputStream bis;
        bis=new ByteArrayInputStream(byt);
        try {
            oii=new ObjectInputStream(bis);
            return oii.readObject();
        } catch (Exception e) {

            e.printStackTrace();
        }
        return null;
    }
}
