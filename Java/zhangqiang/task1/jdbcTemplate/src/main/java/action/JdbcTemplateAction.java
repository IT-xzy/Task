package action;

import dao.impl.StudentDaoImpl;
import model.Student;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import service.RandomStudent;

import java.util.ArrayList;
import java.util.List;
/*
* JdbcTEmplate 测试类
*
* */

public class JdbcTemplateAction {

    static Logger logger = Logger.getLogger(JdbcTemplate.class.getName());

    private ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationcontext.xml");
    private StudentDaoImpl stu = (StudentDaoImpl) applicationContext.getAutowireCapableBeanFactory().getBean("studentDaoImpl");

    private RandomStudent randomStudent = new RandomStudent();

    private Student student = null;

    @Test
    public void selectTest(){

        student = stu.selectById(44);

        if(student!=null&&student.getId()!=0){
            logger.info(student);
        }else {
            logger.info("未找到数据！");
        }

    }

    @Test
    public void findByStuTest(){

        Student student = new Student();
        student.setName("辰");
        student.setSchool("大学");

        List<Student> list = stu.findByStudent(student);

        if (list.size()>0){
            for(Student stu : list){
                logger.info("\n" +
                        " 姓名 :" + stu.getName() + "\n" +
                        " 毕业院校 :" + stu.getSchool() + "\n" +
                        " 修真学号 :" + stu.getStuNum() + "\n" +
                        " 修真类型 :" + stu.getType() + "\n" +
                        " qq :" + stu.getQq() + "\n" +
                        " 宣言 :" + stu.getPro() + "\n" +
                        " 日志链接 :" + stu.getDailyLink() + "\n" +
                        " 师兄 :" + stu.getBrother() + "\n" +
                        " 入学时间 :" + stu.getStartTime() + "\n"
                );
            }
        }else {
            logger.info("未找到相关数据！");
        }

    }


    @Test
    public void insertTest(){

        boolean flag = false;
        Student student = new RandomStudent().getStudent();
        int ins = stu.insert(student);
        if(ins!=0){
            flag = true;
            logger.info("添加数据成功，flag为：" + flag + ",新数据id为：" + ins );
            logger.info("新数据：" + stu.selectById( ins ));
        }else {
            logger.info("添加失败！");
        }

    }

    @Test
    public void insertListTest(){

        List<Student> list = new ArrayList<Student>();

        for(int i=0;i<5;i++){
            list.add(randomStudent.getStudent());
        }
        logger.info(stu.insertLiset(list));
    }

    @Test
    public void updateTest(){

        Student student = new RandomStudent().getStudent();
        student.setId(5);
        logger.info( stu.selectById(student.getId()));
        logger.info( stu.update(student));
        logger.info( stu.selectById(student.getId()));

    }

    @Test
    public void updateListTest(){

        List<Student> students = new ArrayList<>();
        Student student;
        for(int i=0;i<10;i++){

            student = randomStudent.getStudent();

            students.add(student);
        }

        logger.info(stu.insertLiset(students));
    }

    @Test
    public void deleteTest(){

        stu.delect(45);

    }









}
