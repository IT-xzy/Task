package test.com.stu.service.impl; 

import com.stu.controller.RmiService;
import com.stu.service.StudentService;
import com.stu.service.UserService;
import com.stu.service.impl.StudentServiceImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/** 
* StudentServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>���� 30, 2018</pre> 
* @version 1.0 
*/ 
public class StudentServiceImplTest { 

@Before
public void before() throws Exception { 
} 

@After
public void after() throws Exception { 
} 

/** 
* 
* Method: findAllCount() 
* 
*/ 
@Test
public void testFindAllCount() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findAll() 
* 
*/ 
@Test
public void testFindAll() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findByID(int id) 
* 
*/ 
@Test
public void testFindByID() throws Exception { 
//TODO: Test goes here...
//
//    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
//    StudentService studentService = (StudentService) applicationContext.getBean("studentServer");

//    UserService userService = (UserService) applicationContext.getBean("userServiceB");

    StudentService studentService = new RmiService().getStudentService();
    System.out.println(studentService.findByID(99));
//    System.out.println(userService.findById(35));

} 

/** 
* 
* Method: findByStudent(Student student) 
* 
*/ 
@Test
public void testFindByStudent() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: insertOne(Student student) 
* 
*/ 
@Test
public void testInsertOne() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: findByPage(int nowpage, int pagesize) 
* 
*/ 
@Test
public void testFindByPage() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updateOne(Student student) 
* 
*/ 
@Test
public void testUpdateOne() throws Exception { 
//TODO: Test goes here... 
} 

/** 
* 
* Method: updateHeadIcoById(Map<String, Object> map) 
* 
*/ 
@Test
public void testUpdateHeadIcoById() throws Exception { 
//TODO: Test goes here... 
} 


} 
