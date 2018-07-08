package com.tools;

import com.dao.CustomerDao;
import com.dao.PttDao;
import com.pojo.Profession;
import net.rubyeye.xmemcached.MemcachedClient;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class MemcachedUtil {
    @Autowired
    private MemcachedClient memcachedClient;
    @Autowired
    private CustomerDao customerDao;
    @Autowired
    private PttDao pttDao;
    Logger logger = Logger.getLogger(MemcachedUtil.class.getName());
//    public Customer getCustomer(String customerName) {
//        try {
//            //从缓存里面查询
//            Customer customer = memcachedClient.get(customerName);
//            if (customer != null) {
//                return customer;
//            }
//            //缓存没有的话从数据库查询
//            customer = customerDao.findCustomer(customerName);
//            if (customer != null) {
//                //查询就结果放入缓存
//                memcachedClient.set(customer.getUsername(), 0, customer);
//                return customer;
//            }
//            return null;
//        } catch (Exception e) {
//            return null;
//        }
//    }

    public Profession getProfession(String professionName) {
        try {
            //从memcached里面查询
            Profession profession = memcachedClient.get(professionName);
            if (profession != null) {
                logger.info("从memcached取出数据：" + profession.getProfession());
                return profession;
            }
            //memcached没有的话从数据库查询
            profession = pttDao.findProfessionByName(professionName);
            if (profession != null) {
                //查询就结果放入memcached
                memcachedClient.set(profession.getProfession(), 0, profession);
                logger.info("数据放入memcached：" + profession.getProfession());
                return profession;
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }

    public List<Profession> getProfessions() {
        try {
            //从memcached里面查询
            List<Profession> professions = memcachedClient.get("professions");
            if (professions != null) {
                logger.info("从memcached取出数据：" + professions);
                return professions;
            }
            //memcached没有的话从数据库查询
            professions = pttDao.findProfessionNumber();
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

//    public Boolean setCustomer(Customer customer, int time) {
//        try {
//            int i = customerDao.insertCustomer(customer);
//            if (i > 0) {
//                memcachedClient.set(customer.getUsername(), time, customer);
//                return true;
//            } else {
//                return false;
//            }
//        } catch (Exception e) {
//            return false;
//        }
//    }
}
