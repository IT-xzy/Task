package org.jnshuDB.client;

import org.jnshuDB.dao.StudentDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {
    ClassPathXmlApplicationContext applicationContext;
    public static void main(String[] args){
        ClassPathXmlApplicationContext applicationContext;
        applicationContext = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        final StudentDao bean = applicationContext.getBean(StudentDao.class);
        System.out.println(bean.findByS_id(3683));
    }
}
