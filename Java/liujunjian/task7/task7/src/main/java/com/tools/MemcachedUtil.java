package com.tools;

import com.dao.PttDao;
import com.dao.UserDao;
import com.pojo.Profession;
import net.rubyeye.xmemcached.MemcachedClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MemcachedUtil {
    @Autowired
    private MemcachedClient memcachedClient;
    @Autowired
    private PttDao pttDao;
    private Logger logger = Logger.getLogger(MemcachedUtil.class.getName());

    public List<Profession> getProfessions() {
        try {
            //从memcached里面查询
            List<Profession> professions = memcachedClient.get("professions");
            if (professions != null) {
                logger.info("从memcached取出数据：" + professions);
                return professions;
            }
            //memcached没有的话从数据库查询
            professions = pttDao.findProfessions();
            if (professions != null) {
                //查询就结果放入memcached
                memcachedClient.set("professions", 0, professions);
                logger.info("数据放入memcached：" + professions);
                return professions;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public Boolean deleteObject(String objectName) {
        try {
            if (memcachedClient.delete(objectName)) {
                logger.info("从memcached删除" + objectName);
                return true;
            } else return false;
        } catch (Exception e) {
            return false;
        }
    }
}
