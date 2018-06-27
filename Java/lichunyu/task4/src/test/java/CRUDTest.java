import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.Student;
import service.StudentService;
import service.impl.StudentServiceImpl;
import org.junit.Test;

import java.net.SocketTimeoutException;

/**
 * 测试CRUD
 */
public class CRUDTest {
    ApplicationContext context = new ClassPathXmlApplicationContext("spring-mybatis.xml");
    StudentService studentService = context.getBean(StudentServiceImpl.class);

    @Test
    public void getCareerCount() throws Exception {
        int count = studentService.getCareerTypeCount("web");
        System.out.println(count);
    }
}
//
//    @Test
//    public void insertTest() throws Exception {
//        for(int i=0;i<5;i++) {
//            Student student = new Student();
//            student.setName("黄章");
//            Integer studentNum = (int)(Math.random() * 300) + 20180000;
//            student.setStudentNum(studentNum);
//            student.setEntranceDate("20110816");
////            student.setGraduatedDate("20170408");
//            student.setIsWork("N");
//            student.setCareer("CEO");
//            student.setDuty("负责魅族科技业务管理");
////            student.setIsExcellent("Y");
//            student.setCreatedDate(System.currentTimeMillis());
//            studentService.insertStudent(student);
//        }
//    }
//
//    @Test
//    public void getOnlineTest() throws Exception {
//        int count = studentService.getLearningStudentCount();
//        System.out.println(count);
//    }
//
//    @Test
//    public void getWorkManTest() throws Exception {
//        int count =studentService.getGraduatedStudentCount();
//        System.out.println(count);
//    }
//
//    @Test
//    public void getExcellentTest() throws Exception {
//        Student student= studentService.getExcellentStudent(20180002);
//        System.out.println(student.toString());
//    }
//
//
//}
