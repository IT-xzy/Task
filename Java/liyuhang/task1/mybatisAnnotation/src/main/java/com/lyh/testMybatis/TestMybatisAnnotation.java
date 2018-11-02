package com.lyh.testMybatis;

import com.lyh.mapper.StudentMapper;
import com.lyh.pojo.Student;
import com.lyh.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.jupiter.api.Test;

import java.util.List;

public class TestMybatisAnnotation {
    //插入数据并返回自增长id
    @Test
    public void testInsert(){
//        实例化工具类里的方法，得到SqlSessionFactor
        SqlSessionFactory factory = MybatisUtils.getFactory();
        //创建SqlSession对象，对数据库进行操作，设置手动提交
        SqlSession session = factory.openSession(false);
//        mybatis根据mapper接口生成其实现类，反射
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setName("李和开机号白");
        student.setQq(17540990);
        student.setWish("简繁体个");
        student.setSchool("灰身粉骨毁容");
        student.setEnrolmentTime(5468541);
        student.setType("java");
        student.setKnowFrom("微信");
        student.setCreateAt(84);
        student.setUpdateAt(34564);
        mapper.addStudent(student);
        System.out.println("id为："+student.getId());
        session.commit();
        session.close();
    }
    //根据id删除数据
    @Test
    public void testDelete(){
        SqlSessionFactory factory = MybatisUtils.getFactory();
        SqlSession session = factory.openSession(false);
        StudentMapper mapper = session.getMapper(StudentMapper.class);
       int x =  mapper.deleteStudent(100004);
        session.commit();
       if (x != 0){
           System.out.println("true");
       }else {
           System.out.println("false");

           session.close();
       }
    }
    //根据id修改数据
    @Test
    public void testUpdate(){
        SqlSessionFactory factory = MybatisUtils.getFactory();
        SqlSession session = factory.openSession(true);
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setName("李和开机号白");
        student.setQq(17540990);
        student.setWish("简繁体个");
        student.setSchool("灰身粉骨毁容");
        student.setEnrolmentTime(5468541);
        student.setType("java");
        student.setKnowFrom("微信");
        student.setCreateAt(84);
        student.setUpdateAt(34564);
        student.setId(100004);
        int x = mapper.updateStudent(student);
        if (x != 0){
            System.out.println("true");
        }else {
            System.out.println("false");
            session.close();
        }
    }
    //根据学生学号查找报名帖
    @Test
    public void testSelectById(){
        SqlSessionFactory factory = MybatisUtils.getFactory();
        SqlSession session = factory.openSession(true);
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        Student student = mapper.selectById(100004);
        System.out.println(student);
        session.close();
    }
    //根据学生名字查找报名帖
    @Test
    public void testSelectByName(){
        SqlSessionFactory factory = MybatisUtils.getFactory();
        SqlSession session = factory.openSession(true);
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectByName("黎明");
        for (Student student :students){
            System.out.println(student);
        }
        session.close();
    }
    //查询全部数据
    @Test
    public void testSelectAll(){
        SqlSessionFactory factory = MybatisUtils.getFactory();
        SqlSession session = factory.openSession(true);
        StudentMapper mapper = session.getMapper(StudentMapper.class);
        List<Student> students = mapper.selectAll();
        for (Student student : students){
            System.out.println(student);
        }
    }
}
