package com.jnshu.serviceImpl;

        import com.jnshu.service.StudentService;
        import org.junit.Before;
        import org.junit.runner.RunWith;
        import org.junit.Test;
        import org.springframework.context.ApplicationContext;
        import org.springframework.context.support.ClassPathXmlApplicationContext;

        import static org.junit.Assert.*;

public class ServiceImplTest {

    private StudentService studentService;
    @Before
    public  void before() {
        ApplicationContext ac = new ClassPathXmlApplicationContext(new String("applicationContext.xml"));
        studentService= (StudentService)ac.getBean("userServiceI");
    }
    @Test
    public void allStudent() {
        System.out.println(studentService.allStudent());

    }
}
