package test.com.tiles.action; 

import com.tiles.service.ProfessionService;
import com.tiles.service.ProfessionServiceImpl;
import com.tiles.service.StudentServiceImpl;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
* Action Tester. 
* 
* @author <Authors name> 
* @since <pre>05/24/2018</pre> 
* @version 1.0 
*/ 
public class ActionTest {

    private  static Logger logger = Logger.getLogger(ActionTest.class);

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

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
    ProfessionServiceImpl professionService = (ProfessionServiceImpl) applicationContext.getBean("professionService");
    logger.info(professionService.findAll());


    logger.info(System.currentTimeMillis());
} 


} 
