package cn.wyq.mybatis;

import cn.wyq.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import java.io.InputStream;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {

    @Before
    public void setUp() throws Exception {
        System.out.println("Start");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Over!");
    }

    @Autowired
    private StudentMapper studentMapper;
    @Test
    public void testAdd() {
        Student student=new Student();
        student.setName("jason");
        student.setSiblingId(369);
        student.setSiblingName("任我行");
        studentMapper.add(student);
    }

    @Test
    public void testDelete(){
        int id = 402;
        studentMapper.delete(id);
    }

    @Test
    public void testUpdate(){
        Student student = new Student();
        student.setName("jack");
        student.setId(50);
        studentMapper.update(student);
    }

    @Test
    public void testGet(){
        int id = 5034603;
        Student student=studentMapper.get(id);
        System.out.println(student);
    }

    @Test
    public void testList() {
        List<Student> cs=studentMapper.listAll();
        for(Student s:cs){
            System.out.println(s.getName());
        }
    }
}