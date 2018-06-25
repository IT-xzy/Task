package com.service;

import com.dao.StudentDao;
import com.entity.Student;
import org.apache.ibatis.session.SqlSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    private ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
    private StudentDao sd = (StudentDao) context.getBean("studentDao");
    private Student student;

    //插入数据
    public boolean addStudent(Student student) throws Exception {
        student.setCreateAt(System.currentTimeMillis()); //插入创建时间
        student.setUpdateAt(System.currentTimeMillis()); //插入修改时间
        return sd.addStudent(student);
    }

    public Integer insertBatch(List list) throws Exception {
        return sd.insertBatch(list);

    }

    //通过id删除数据
    public boolean deleteById(Student student) throws Exception {
        return sd.deleteById(student);
    }

    //通过id更新数据
    public boolean updateByName(Student student) throws Exception {
        student.setUpdateAt(System.currentTimeMillis());
        return sd.updateByName(student);
    }

    //获取所有数据
    public List<Student> findAll() throws Exception {
        return sd.findAll();
    }

    //通过id和name还有学号进行查询
    public Student findByName(Student student) throws Exception {
        sd.findByName(student);
        return sd.findByName(student);
    }

    //通过名字或者学号模糊查询
    public List<Student> findByLike(Student student) throws Exception {
        sd.findByLike(student);
        return sd.findByLike(student);
    }

    //清除所有数据

    public void truncate() throws Exception{

    }
}
