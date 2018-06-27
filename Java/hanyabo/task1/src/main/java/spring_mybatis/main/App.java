package spring_mybatis.main;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring_mybatis.service.StudentService;
import util.RandomStuUtil;

public class App {

    public static  void main(String args[]){
        Logger logger = Logger.getLogger(App.class);
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService studentService = applicationContext.getBean(StudentService.class);
        logger.info("start adding 1000 data into database");
        try {
            for (int i=0;i<1000;i++){
                studentService.addStudent(RandomStuUtil.getRandomStu());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        logger.info("end adding 1000 data into database");
    }
}
