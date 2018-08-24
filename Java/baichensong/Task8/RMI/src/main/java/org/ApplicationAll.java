package org;


import com.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Random;

/**
 * 实现随机访问服务端 的类  当一台service挂掉时 第二台可以提供服务。
 * @author baich
 */
public class ApplicationAll {

    ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-client.xml");
    StudentService studentService;
    public StudentService service(){
        Random random = new Random();
        int num = random.nextInt(2)+1;
        System.out.println("当前随机数为---------------------"+num);
        if(num == 1){
           try {
              studentService= (StudentService) applicationContext.getBean("client");
               //测试 是否真的能拿到服务器1 的 bean 不能    则让它报错 ------否则页面报错
              int number=studentService.findName();
               System.out.println("服务器1成功启动--------------"+number);
           }catch(Exception e) {
              studentService=(StudentService) applicationContext.getBean("client2");
               System.out.println("服务器1启动失败---------------服务器2启动---------");
            }
            return studentService;

        }else {
            try {
                studentService= (StudentService) applicationContext.getBean("client2");
                //测试 是否真的能拿到服务器2 的 bean 不能    则让它报错 ------否则页面报错
                int number=studentService.findName();
                System.out.println("服务器2成功启动--------------"+number);

            }catch(Exception e) {
                studentService=(StudentService) applicationContext.getBean("client");
                System.out.println("服务器2启动失败---------------服务器1启动---------");
            }
            return studentService;
        }

    }
    public ApplicationContext application(){
        return applicationContext;
    }
}
