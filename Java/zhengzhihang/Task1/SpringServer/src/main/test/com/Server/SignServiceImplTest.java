package com.Server;

import com.Dao.Sign;
import com.Dao.SignMapper;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
//为了要使用test的注释类，首先需要添加两个jar包，junit和Spring-test.
//然后需要加载两个注释
//RunWith（）制定类为junit测试运行器
//ContestConfiguration指定Spring配置文件路径
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationConfig.xml")

public class SignServiceImplTest {
    private static Logger logger = Logger.getLogger(Test.class);
    @Resource(name = "ServiceImpl")
    public SignServiceImpl ssi;
    public Sign sg=null;
    public int i;
    public boolean b;
//    @Before
//    public void before(){
//        ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationConfig.xml");
//        ssi= (SignServiceImpl) ac.getBean("Impl");
//    }
    @Test
    public void checkUserById() {
        sg=ssi.checkUserById(1);
        logger.info(sg);
    }

    @Test
    public void checkUserByName() {
        sg=ssi.checkUserByName("c");
        logger.info(sg);
    }

    @Test
    public void puttUser() {
        sg=new Sign();
        sg.setCity("hic");
        sg.setName("hos");
        i=ssi.puttUser(sg);
//        if (i!=0){
//            System.out.println("ture");
//        }else {
//            System.out.println("flase");
//        }
//        System.out.println(i);
        System.out.println("现在的id是"+sg.getId());

    }

    @Test
    public void cutUserById() {
        ssi.cutUserById(8);
    }

    @Test
    public void replayUserById() {
        Sign sg5=new Sign();
        sg5.setId(7);
        sg5.setName("update1");
        sg5.setCity("upcity1");
        ssi.replayUserById(sg5);
    }

    @Test
    public void cutUserByName() {
        ssi.cutUserByName("update1");
    }
}