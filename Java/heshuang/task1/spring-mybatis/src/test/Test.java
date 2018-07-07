import com.he.dao.StudentDao;
import com.he.pojo.Student;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class Test {
    static Logger logger = Logger.getLogger(Test.class);
    @org.junit.Test
    public void testAdd() throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        StudentDao studentDao = (StudentDao) context.getBean("StudentDao");
        Student student = new Student();
        student.setCreate_at("1125514262");
        student.setName("小三");
        student.setQq("145800052");
        student.setProfessional("web");
        student.setStart_time("2018-03-25");
        student.setUniversity("西工大");
        student.setOnline_id(552);
        student.setDaily_url("http://www.jnshu.com/school/26079/daily");
        student.setOath("如果我不能在IT特 训营拼尽全力，为自己以后的修行道路上打好基础，就让我变胖10斤。");
        student.setCounselor("李科");
        student.setCity("郑州");
        studentDao.addStudent(student);
        logger.info("id ="+ student.getId());
//        System.out.println("id ="+ student.getId());
    }
    @org.junit.Test
    public void testDelete()throws Exception{
        boolean flag;
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        StudentDao studentDao = (StudentDao) context.getBean("StudentDao");
        Integer i = studentDao.deleteStudent(212);
        if (i !=0){
            flag = true;
        }
        else flag = false;
        logger.info(flag);
//        System.out.println("删除成功！！！");
    }
    @org.junit.Test
    public void testUpdate()throws Exception{
        boolean flag;
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        StudentDao studentDao = (StudentDao) context.getBean("StudentDao");
        Student student = new Student();
        student.setCreate_at("1154258520");
        student.setName("222");
        student.setQq("22222222214");
        student.setId(213);
        Integer i = studentDao.updateStudent(student);
        if (i !=0){
            flag = true;
        }
        else flag = false;
        logger.info(flag);
//        System.out.println(student);
    }
    @org.junit.Test
    public void testFind()throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        StudentDao studentDao = (StudentDao) context.getBean("StudentDao");
        List<Student>students = studentDao.list();
        for(Student student1:students){
            logger.info(student1);
//            System.out.println(student1);
        }
    }
    @org.junit.Test
    public void testFindByOnline_id()throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        StudentDao studentDao = (StudentDao)context.getBean("StudentDao");
        List<Student>students = studentDao.selectStudentByOnline_id(552);
        for (Student student:students){
        logger.info(student);
        }
//        System.out.println(studentDao.selectStudentByid(210));
    }
    @org.junit.Test
    public void findByName()throws IOException{
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        StudentDao studentDao = (StudentDao)context.getBean("StudentDao");
        List<Student>students = studentDao.findByName("张三");
        for (Student student:students){
            logger.info(student);
        }
    }
}
