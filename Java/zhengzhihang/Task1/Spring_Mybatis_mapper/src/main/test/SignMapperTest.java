import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class SignMapperTest {

    private static Logger logger = Logger.getLogger(Test.class);
    public SignMapper sm;
    int i;
    Sign s;
    @Before
    public void Before(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("ApplicationConfig.xml");
        sm= (SignMapper) ac.getBean("Sql");
    }
    @Test
    public void findUserById() {
        s=sm.findUserById(1);
        logger.error(s);
    }
    @Test
    public void findUserByName() {
        s=sm.findUserByName("li");
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