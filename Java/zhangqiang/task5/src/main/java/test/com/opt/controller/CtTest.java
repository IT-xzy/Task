package test.com.opt.controller; 

import com.opt.dao.mapper.OptUserMapper;
import com.opt.model.OptUser;
import com.opt.service.impl.StudentServiceImpl;
import com.opt.service.impl.UserServiceImpl;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
* Ct Tester. 
* 
* @author <Authors name> 
* @since <pre>06/04/2018</pre> 
* @version 1.0 
*/ 
public class CtTest {

    private final Logger logger = Logger.getLogger(CtTest.class);

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
//    OptUserMapper optUserMapper = (OptUserMapper) applicationContext.getBean("userMapper");
    UserServiceImpl userService = (UserServiceImpl) applicationContext.getBean("userService");
    StudentServiceImpl studentService = (StudentServiceImpl) applicationContext.getBean("studentService");


    @Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: test() 
* 
*/ 
@Test
public void testTest() throws Exception { 
//TODO: Test goes here...
//    OptUser optUser = new OptUser();
//    optUser.setUsername("第一个");
//    optUserMapper.insert(optUser);
//    logger.info(userService.findByName("ceshi"));
    logger.info(studentService.findByID(1).toString());




} 


} 
