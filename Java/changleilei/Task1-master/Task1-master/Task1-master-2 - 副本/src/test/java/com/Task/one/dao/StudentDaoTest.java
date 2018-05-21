package com.Task.one.dao;

import com.Task.one.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class StudentDaoTest {
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession session;

    private static Logger logger = Logger.getLogger("StudentDaoTest.class");

    @Before
    public void setUp() throws Exception {
        String resource = "mybatis-config.xml";
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
        session = sqlSessionFactory.openSession();
    }

    @Test
    public void insertStudentByAnnotation() throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        StudentDao studentDao = session.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("李云龙");
        student.setSex("男");
        student.setQQ("46564456");
        student.setGraduate("野外训练营");
        student.setNumber("001");
        student.setAutoGraph("干他娘的意大利炮！");
        student.setCreateTime(df.format(new Date()));
        studentDao.insertStudentByAnnotation(student);
        logger.debug("注释型插入");
    }

    @Test
    public void selectByNameByAnnotation() throws Exception {
        StudentDao studentDao = session.getMapper(StudentDao.class);
        List<Student> student = studentDao.selectManyByNameByAnnotation("李云龙");
        Iterator<Student> studentIterator = student.iterator();
        while (studentIterator.hasNext()) {
            Student u = studentIterator.next();
            System.out.println(
                  "用户序号：" + u.getId() + "\n"
                        + "学生姓名：" + u.getName() + "\n"
                        + "学生性别：" + u.getSex() + "\n"
                        + "联系方式：" + u.getQQ() + "\n"
                        + "毕业院校：" + u.getGraduate() + "\n"
                        + "学生学号：" + u.getNumber() + "\n"
                        + "个性签名：" + u.getAutoGraph() + "\n"
                        + "创建时间：" + u.getCreateTime() + "\n"
                        + "更新时间：" + u.getUpdateTime() + "\n");
        }
        logger.debug("注释型查询");
    }

    @Test
    public void updateStudentByNameByAnnotation() throws Exception {
        StudentDao studentdao = session.getMapper(StudentDao.class);
        Student student = studentdao.selectByNameByAnnotation("李云龙");
        if (student == null) {
            logger.debug("不存在该记录，注释型更改失败！");
        } else {
            student.setNumber("654321");
            studentdao.updateStudentByNameByAnnotation(student);
            logger.debug("注释型更改");
        }
    }

    @Test
    public void deleteStudentByNameByAnnotation() throws Exception {
        StudentDao studentdao = session.getMapper(StudentDao.class);
        studentdao.deleteStudentByNameByAnnotation("李云龙");
        logger.debug("注释型删除");
    }

    @Test
    public void deleteStudentByIdByAnnotation() throws Exception {
        StudentDao studentdao = session.getMapper(StudentDao.class);
        studentdao.deleteStudentByIdByAnnotation(1);
        logger.debug("注释型批量删除");
    }

    //统计同一列的重复数
    @Test
    public void countAllByAnnotation() throws Exception {
        StudentDao studentdao = session.getMapper(StudentDao.class);
        System.out.println("记录条数：" + studentdao.countAllByAnnotation());
    }

    @Test
    public void countAllByNameByAnnotation() throws Exception {
        StudentDao studentdao = session.getMapper(StudentDao.class);
        System.out.println("记录条数：" + studentdao.countAllByNameByAnnotation("李云龙"));
    }
    
    
    @After
    public void teaDown() throws Exception {
        session.commit();
        session.close();
    }
}