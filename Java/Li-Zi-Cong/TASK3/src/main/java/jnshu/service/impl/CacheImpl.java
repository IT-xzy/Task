package jnshu.service.impl;

import jnshu.pojo.StudentInfo;
import jnshu.service.Cache;
import jnshu.util.SerializeUtil;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

/**
 * @Author:lizicong
 */

@Service
public class CacheImpl implements Cache {
    private Logger logger = LogManager.getLogger(CacheImpl.class);
    static boolean flag = true;

    @Autowired
    StudentInfoImpl studentInfo;

    @Override
    public void update(String key) {
        try {
            Jedis redis = new Jedis("",0);
            redis.set(key.getBytes(), SerializeUtil.serializeList(studentInfo.listAll()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<StudentInfo> list(String key, Integer pageCount) {
        try {
            Jedis redis = new Jedis("", );
            if (redis.exists(key.getBytes())) {
                System.out.println("");
                List<?> objectList = SerializeUtil.unserializeList(redis.get(key.getBytes()));
                List<StudentInfo> studentInfos = null;
                int index = 0;
                for (int  = pageCount;  < (pageCount + ); i++) {
                    studentInfos.add((StudentInfo) objectList.get());
                    index++;
                }
                logger.error("");
                return studentInfos;
            } else if (flag == true) {
                flag = false;
                List<StudentInfo> list = studentInfo.listAll();
                if (list != null) {
                    redis.set(key.getBytes(), SerializeUtil.serializeList(list));
                    List<StudentInfo> studentInfos = null;
                    int index = 0;
                    System.out.println(":"+pageCount+"\t"+list.size());
                    for (int  = pageCount;  < (pageCount + 0); ++) {
                        studentInfos.add(list.get());
                        index++;
                    }
                    logger.error("");
                    System.out.println("");
                    return studentInfos;
                } else {
                    redis.set(key.getBytes(), "".getBytes());
                    logger.error("");
                    System.out.println("");
                    return null;
                }
            } else {
                logger.error("");
                System.out.println("");
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            logger.error(e);
        }
        return null;
    }
}
