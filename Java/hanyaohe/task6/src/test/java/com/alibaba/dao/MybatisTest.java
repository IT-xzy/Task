package com.alibaba.dao;


import com.alibaba.model.Student;

import com.alibaba.service.impl.StudentServiceImpl;
import com.alibaba.utils.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class MybatisTest {
    @Resource
    private StudentDao studentDao;
    @Resource
    private StudentServiceImpl studentService;
    @Resource
    private RedisUtil redisUtil;

    @Test
    public void deleteByPrimaryKey() {
        studentDao.deleteById(3L);
        // System.out.println(s);
    }
    @Test
    public void addStudent() {
        Student student = new Student();
        student.setId(7L);
        student.setName("俞飞鸿");
        student.setQq("456789");
        student.setType("类型");
        student.setEnrolmenttime("入学时间");
        student.setGraduated("毕业于");
        student.setNumber("数字");
        student.setDaily("日报");
        student.setAmbition("立志");
        student.setResponsible("负责的");
        student.setWfrom("来自于");
        student.setTelipone("电话");
        student.setEmail("邮箱");
        student.setPortrait("肖像");
        student.setCreateAt(10L);
        student.setUpdateAt(20L);
      int a =  studentDao.insert(student);
        System.out.println(a);
    }
    @Test
    public void update(){
        Student student = new Student();
        student.setId(2L);
        student.setType("哈哈哈吧");
        student.setName("虚竹");
        student.setQq("5497864");
        Boolean bl = studentDao.updateById(student);
        System.out.println(bl);
    }

    @Test
    public void selectById(){
        Student student = studentDao.selectById(5L);
        System.out.println(student);
    }

    @Test
    public void testStudent() {
        List<Student> student =  studentDao.selectAll();
        System.out.println(student);
    }
    @Test
    public void inSelective(){
        Student student = new Student();
        student.setType("这个测试");
        student.setQq("986");
        student.setName("很奇怪呀");
        int b = studentDao.insertSelective(student);
        System.out.println(b);
    }
    @Test
    public void upByIdSelective(){
        Student student = new Student();
        student.setName("再修改");
        student.setQq("试一试");
        student.setType("不催着");
        student.setDaily("不长脑子");
        student.setEnrolmenttime("不存在的");
        student.setId(4L);
        boolean ble = studentDao.updateByIdSelective(student);
        System.out.println(ble);

    }
    @Test
    public void selByName(){
        Student student = studentDao.selByName("韩要贺");
        System.out.println(student);

    }

    @Test
    public void count(){
        int c = studentDao.countAll();
        System.out.println(c);
    }
    @Test
    public void studentList(){
        List<Student> sl = studentService.studentList();
        System.out.println(sl);
    }
    @Test
    public void delRedis(){
        redisUtil.del( "studentList");
    }
}
