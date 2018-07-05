package com.jasper.test;

import com.jasper.bean.Person;
import com.jasper.dao.PersonDao;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestDemo {
    private static final Log log= LogFactory.getLog(TestDemo.class);
@Test
  public void getPersonTest(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        PersonDao personDao = (PersonDao) ctx.getBean("PersonDao");
        Person person = personDao.getPerson(1);
        System.out.println(person);
  }

    }

