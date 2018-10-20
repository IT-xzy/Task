package com.suger;

import com.suger.dao.UserDao;
import com.suger.pojo.User;
import com.suger.util.DataUtils;
import org.apache.log4j.Logger;

/**
 * @author suger
 * @date 2018-09-21
 */
public class Main {

    static Logger log = Logger.getLogger(Main.class);
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        // count 调用方法次数
        int count =1;
        for (int i =0;i<count;i++) {
            User user = new User();
            user.setUserName(DataUtils.getName());
            user.setProfession(DataUtils.getProfession());
            user.setUpdateAt(DataUtils.getTime());
            user.setUserId(3897510L);
            log.info("插入ID:"+userDao.insert());
            log.info("更新："+userDao.update(user));
            log.info("删除："+userDao.delete(11006503L));
            log.warn("根据姓名查询："+userDao.getUserByName("于星"));
            log.warn("查询："+userDao.getUserByonlineId(13019));
            log.info("查询全部："+userDao.findAll());
        }

    }
}
