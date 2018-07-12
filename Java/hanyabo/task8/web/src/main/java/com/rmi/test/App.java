package com.rmi.test;


import com.task.entity.Student;

import com.task.service.HelloService;
import com.task.service.StudentService;
import com.task.service.UserService;
import com.task.util.BeanFactoryUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class App {

    public static void main(String[] args) {
        App clientMain = new App();
        clientMain.run();
    }

    public void run(){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");

        HelloService service = new BeanFactoryUtil().getHelloService();
        UserService userServiceImpl = new BeanFactoryUtil().getUserService();
        StudentService studentServiceImpl = new BeanFactoryUtil().getStudentService();

        for (int i = 0;i<2;i++){
//            service.test();

            System.out.println(userServiceImpl.checkUsername("hanyabo"));
            System.out.println(userServiceImpl.checkUsername("liang"));

            System.out.println(userServiceImpl.checkPhone("18566206578"));
            System.out.println(userServiceImpl.checkPhone("13939088299"));

            System.out.println(userServiceImpl.checkEmail("7443366871@qq.com"));
            System.out.println(userServiceImpl.checkEmail("7443366877@qq.com"));

            System.out.println(userServiceImpl.checkLogin("hanyabo"));

            System.out.println(studentServiceImpl.total());

//            List<Student> list = new ArrayList<>();
//
//            list = studentServiceImpl.findById(i+1);
//            if(null != list)
//                for(Student student:list){

            List<Student> list = studentServiceImpl.findByName("寿乙戊");

            System.out.println(list);

//            Student student = studentServiceImpl.findById2(i+1);
//                    System.out.println(student);
//                }



            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
