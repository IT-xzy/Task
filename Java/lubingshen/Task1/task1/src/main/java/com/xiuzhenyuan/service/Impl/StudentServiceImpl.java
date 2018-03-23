package com.xiuzhenyuan.service.Impl;

import com.xiuzhenyuan.dao.StudentDao;
import com.xiuzhenyuan.bean.Student;
import com.xiuzhenyuan.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    //因为main的特殊性，不能使用以下的方法获得bean
    //@Autowired
    //StudentDao studentDao;
    private static ApplicationContext ctx = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
    private static StudentDao studentDao = ctx.getBean(StudentDao.class);

    //插入一个学员信息并且打印日志
    public long addAStudent(Student student) throws Exception {
        try{
            student.setCreateAt(System.currentTimeMillis());
            studentDao.insertStudent(student);
            return student.getId();
        } catch (DuplicateKeyException e){
            //处理插入时重复学号引发的异常
            throw new DuplicateKeyException("插入失败！该学号已经存在！");
        }
    }

    //删除一个学员信息并且打印日志
    public boolean deleteAStudent(Long primeKey) throws Exception {
        return studentDao.deleteStudent(primeKey);
    }

    //通过主键来查询一个学员
    public Student findByPrimeKey(Long primekey) throws Exception {
        return studentDao.findById(primekey);
    }

    //通过姓名模糊查询
    public List<Student> findStudentsByName(String name) throws Exception {
        return studentDao.findByName(name);
    }

    //通过学号精确查找
    public Student findAStudentByNum(String online_num) throws Exception {
        return studentDao.findByNum(online_num);
    }

    //更新信息
    public boolean updateInformation(Student student) throws Exception {
        student.setUpdateAt(System.currentTimeMillis());
        return studentDao.updateStudent(student);
    }

    //清空表格
    public void deleteAll() throws Exception {
        studentDao.truncateTable();
    }
}
