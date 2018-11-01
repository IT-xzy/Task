package jnshu.util;
import jnshu.pojo.StudentInfo;
import jnshu.service.impl.StudentInfoImpl;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

import java.util.*;

/**
 * @Author:user
 */
public class Cache {
    //有效ID集合
    static int[] aList;

    static private Jedis redis = new Jedis("localhost", 6379);
    static private Logger logger = LogManager.getLogger(Cache.class);


    /**
     * @param key    要修改的缓存名字
     * @param object 要更新的数据集合(由接口提供的数据)
     */
    public static void updateKey(String key, Object object) {
        try {
            redis.set(key.getBytes(), SerializeUtil.serialize(object));
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
    }


    /**
     * @param key
     * 根据key名字删除缓存
     */
    public static void deleteKey(String key) {
        try {
            if(redis.get(key)!=null)
            redis.del(key);
            else {
                logger.error(new Date() +"//试图删除无效key"+key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * @param keyCount
     * @return
     * 根据页码数遍历获取并返回对象集合
     */
    public static List<StudentInfo> getKeyList(Integer keyCount) {
        try {
            System.out.println("cacheP" + keyCount);
            List<StudentInfo> list = new ArrayList<>();
            for (int i = keyCount; i < (keyCount + 5); i++) {
//                System.out.println("keyCount:"+keyCount+"\tlength"+aList.length);
                if (i < aList.length) {
                    list.add((StudentInfo) SerializeUtil.unserialize(redis.get(new String("student//" + aList[i]).getBytes())));
                }
            }
            list.forEach(x -> System.out.println(x.toString()));
            return list;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }

    /**
     * 从缓存返回单个对象
     *
     * @param key
     * @return
     */
    public static StudentInfo getOneKey(String key){
        byte[]bytes=redis.get(key.getBytes());
        if (bytes==null){
            logger.error("...");
        }
        return (StudentInfo) SerializeUtil.unserialize(bytes);
    }


    /**
     * 初始化缓存区
     * @param studentInfo
     * @throws Exception
     * 暂时放这
     */
    public static void initCache(StudentInfoImpl studentInfo)throws Exception{
        studentInfo.listAll().forEach(i -> redis.set(new String("student//" + i.getId()).getBytes(), SerializeUtil.serialize(i)));
    }


    /**
     * 维护有效key集合
     * @throws Exception
     */
    public static void resetIndex(StudentInfoImpl studentInfo) throws Exception {
        Set list = redis.keys("student//*");
        //防雪崩
        if (list==null){
            Cache.initCache(studentInfo);
        }
        Iterator iterator = list.iterator();
        int[] arr = new int[list.size()];
        int i = 0;
        while (iterator.hasNext()) {
            String[] strings = iterator.next().toString().split("student//", 2);
            System.out.println(i + "\t" + strings[1]);
            int temp = Integer.parseInt(strings[1]);
            arr[i++] = temp;
        }
        System.out.println("listSize:"+arr.length);
        for (int j = 0; j < arr.length - 1; j++) {
            for (int k = 0; k < (arr.length - j) - 1; k++) {
                if (arr[k] > arr[k + 1]) {
                    int temp = arr[k];
                    arr[k] = arr[k + 1];
                    arr[k + 1] = temp;
                }
            }
        }
        aList = arr;
    }
}
