package task1.service;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import task1.dao.TnDao;
import task1.domain.Trainees;

import javax.annotation.Resource;
import javax.annotation.Resources;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @Author: Zhou Hao
 * @Date: 2018/5/19 15:50
 * @Description:
 * @Modify:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")

public class TnServiceTest {

    @Autowired
    TnDao tnDao;

//    @BeforeClass
//    public static void up() {
//        ApplicationContext context = new
//                ClassPathXmlApplicationContext("applicationContext.xml");
//    }

    @Test
    public void findById() {
        Trainees tn = tnDao.findById(2033);
        System.out.println(tn);
    }

    @Test
    public void findByName() {
        List<Trainees> list = tnDao.findByName("周浩");

    }

    @Test
    public void insert() {
        Trainees tn = new Trainees("zhou", "ta", "www");
        tnDao.addTrainees(tn);
        System.out.println(tn.getId());

    }


}