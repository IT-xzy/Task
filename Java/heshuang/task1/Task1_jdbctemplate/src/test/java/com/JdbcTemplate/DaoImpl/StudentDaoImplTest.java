package com.JdbcTemplate.DaoImpl;

import com.JdbcTemplate.Pojo.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentDaoImplTest {
    @Test
    public void insert() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        StudentDaoImpl studentDaoImpl = (StudentDaoImpl) context.getBean("studentDao");
        Student student = new Student();
        student.setCreate_at("1529117255");
        student.setName("张三");
        student.setQq("145896352");
        student.setProfessional("java");
        student.setStart_time("2018-04-16");
        student.setUniversity("郑州大学");
        student.setOnline_id(556);
        student.setDaily_url("http://www.jnshu.com/school/26079/daily");
        student.setOath("如果我不能在IT特 训营拼尽全力，为自己以后的修行道路上打好基础，就让我变胖10斤。");
        student.setCounselor("张亚强");
        student.setCity("郑州");
        studentDaoImpl.Insert(student);
    }

    @Test
    public void delete() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        StudentDaoImpl studentDaoImpl = (StudentDaoImpl) context.getBean("studentDao");
        studentDaoImpl.Delete(3);
    }

    @Test
    public void findAllStudent() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        StudentDaoImpl studentDaoImpl = (StudentDaoImpl) context.getBean("studentDao");
        studentDaoImpl.findAllStudent();
    }

    @Test
    public void findByName() throws Exception {
        ApplicationContext context =new ClassPathXmlApplicationContext("application.xml");
        StudentDaoImpl s = (StudentDaoImpl)context.getBean("studentDao");
        s.findByName("张三");
    }

    @Test
    public void findByOnlie_id() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        StudentDaoImpl s = (StudentDaoImpl) context.getBean("studentDao");
        s.findByOnlie_id(255);
    }

    @Test
    public void updateStudent() throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        StudentDaoImpl studentDaoImpl = (StudentDaoImpl) context.getBean("studentDao");
        Student student = new Student();
        student.setName("小三");
        student.setCity("香港");
        student.setId(1);
        studentDaoImpl.UpdateStudent(student);
    }
}