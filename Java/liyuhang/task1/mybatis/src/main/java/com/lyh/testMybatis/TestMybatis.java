package com.lyh.testMybatis;

import com.lyh.mapper.StudentMapper;

import com.lyh.pojo.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.Reader;
import java.util.List;

public class TestMybatis {
    private static SqlSessionFactory sqlSessionFactory;
    private static Reader reader;

    static {
        try {
            //加载mybatisXML文件
            reader = Resources.getResourceAsReader("configuration.xml");
            //获取一个新的数据流
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public static SqlSessionFactory getSession() {
//        return sqlSessionFactory;
//    }
    //根据学生学号查询报名帖
@Test
    public void getStudentById() {
        //创建Session对象，对数据库进行操作
        SqlSession session = sqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            Student student = studentMapper.selectById(100007);
            if (student != null) {
                System.out.println(student.getId() + ":" + student.getName() + ":" + student.getQq() + ":" + student.getWish() + ":" + student.getSchool() + ":" + student.getEnrolmentTime() + ":" + student.getType() + ":" + student.getKnowFrom() + ":" + student.getCreateAt() + ":" + student.getUpdateAt());
            }
        } finally {
            session.close();
        }
    }
    //根据学员名字查询报名帖
   @Test
   public void getStudentList(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            List<Student> students = studentMapper.selectByName("刘德华");
            //增强for循环
            for (Student student : students){
                System.out.println(student.getId() + ":" + student.getName() + ":" + student.getQq() + ":" + student.getWish() + ":" + student.getSchool() + ":" + student.getEnrolmentTime() + ":" + student.getType() + ":" + student.getKnowFrom() + ":" + student.getCreateAt() + ":" + student.getUpdateAt());
            }
        }finally {
            session.close();
        }
   }
    /**
     * 增加后要commit
     */
    //插入数据
    @Test
    public void addStudent(){
        Student student = new Student();
        student.setName("刘德华");
        student.setQq(29803268);
        student.setWish("养活自己");
        student.setSchool("工业职业技术学院");
        student.setEnrolmentTime(2018);
        student.setType("java");
        student.setKnowFrom("知乎");
        student.setCreateAt(2018);
        student.setUpdateAt(20181022);
        SqlSession session = sqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            studentMapper.addStudent(student);
            session.commit();
            System.out.println("新增用户ID：" + student.getId());
        }finally {
            session.close();
        }
    }

    /**
     * 修改后要commit
     */
    //根据id修改数据
    @Test
    public void updateStudent(){
        SqlSession session = sqlSessionFactory.openSession();
        try {
            StudentMapper studentMapper = session.getMapper(StudentMapper.class);
            Student student = studentMapper.selectById(100006);
            if (student != null) {
                student.setName("金坷垃");
                student.setQq(293268);
                student.setWish("养活");
                student.setSchool("职业技术学院");
                student.setEnrolmentTime(218);
                student.setType("java");
                student.setKnowFrom("知乎");
                student.setCreateAt(20185);
                student.setUpdateAt(2018102);
                int x = studentMapper.updateStudent(student);
                if (x != 0){
                    System.out.println("true");
                }else {
                    System.out.println("false");
                }
                session.commit();
            }
        }finally {
            session.close();
        }
    }
    /**
     * 删除后要commit.
     */
    //根据id删除数据
    @Test
    public void deleteStudent(){
      SqlSession session = sqlSessionFactory.openSession();
      try {
          StudentMapper studentMapper = session.getMapper(StudentMapper.class);
          int x = studentMapper.deleteStudent(100006);
          if (x != 0){
              System.out.println("true");
          }else {
              System.out.println("false");
          }
          session.commit();
      }finally {
          session.close();
      }
    }
}
