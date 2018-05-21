package com.mybatis_spring.controller;

import com.mybatis_spring.bean.Student;
import com.mybatis_spring.dao.IStudentDao;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;

/**
 * @author Arike
 * Create_at 2017/12/2 10:14
 */
public class mian {
    public static void main(String[] args) throws Exception {
        Logger logger = Logger.getLogger(mian.class);
        ApplicationContext ctx = new ClassPathXmlApplicationContext("com/mybatis_spring/dao/mybaits-spring.xml");
       
        IStudentDao dao = ctx.getBean("studentDao", IStudentDao.class);
        long begain = System.currentTimeMillis();
        for (long i = 0; i < 200000000; i++) {
            Long creat_at = System.currentTimeMillis() / 1000;
            Calendar calendar = Calendar.getInstance();
            calendar.set(2017, 12, 10, 10, 30, 0);
            dao.insertStudent(new Student(creat_at, creat_at, "何人", "4456", "火星", calendar.getTimeInMillis() / 1000, "盲人技校", "Java001", "www.baidu.com", "一二三似物流", "杨以杰", "翻墙过来的"));
        }
        long end = System.currentTimeMillis() - begain;
        long hour = end / (1000 * 60 * 60);
        long minute = (end % (1000 * 60 * 60)) / (1000 * 60);
        long second = ((end % (1000 * 60 * 60)) % (1000 * 60)) / 1000;
        logger.info("总共耗时" + hour + "时" + minute + "分" + second + "秒");
    }
}
