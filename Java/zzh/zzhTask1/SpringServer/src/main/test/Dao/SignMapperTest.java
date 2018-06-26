package Dao;

import com.Dao.Sign;
import com.Dao.SignMapper;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
//为了要使用test的注释类，首先需要添加两个jar包，junit和Spring-test.
//然后需要加载两个注释
//RunWith（）制定类为junit测试运行器
//ContestConfiguration指定Spring配置文件路径

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:ApplicationConfig.xml")
public class SignMapperTest {
    private static Logger logger = Logger.getLogger(Test.class);
    @Resource(name = "Sql")
    public SignMapper sm;
    int i;
    Sign s;
    @Test
    public void findUserById() {
        s=sm.findUserById(1);
        logger.error(s);
    }
    @Test
    public void findUserByName() {
        s=sm.findUserByName("再测试");
        System.out.println(s);
    }
    @Test
    public void insertUser() {
        s=new Sign();
        s.setCity("getid");
        s.setName("tgid");
        i=0;
        try {
            i = sm.insertUser(s);
        }
        catch (Exception e) {
            e.fillInStackTrace(); }
        System.out.println(i);
        System.out.println(s.getId());
    }
    @Test
    public void deleteUserById() {
        i=sm.deleteUserById(22);
        System.out.println(i);
    }
    @Test
    public void updateUserById() {
        s=new Sign();
        s.setName("8");
        s.setCity("444");
        s.setId(11);
        i=sm.updateUserById(s);
    }
    @Test
    public void deleteUserByName() {
        i=sm.deleteUserByName("xx");
        System.out.println(i);
    }

    @Test
    public void log(){
        logger.debug("this is a debug");
        logger.info("this is a info");
        logger.warn("this is a warn");
        logger.error("this is a error");
    }
}