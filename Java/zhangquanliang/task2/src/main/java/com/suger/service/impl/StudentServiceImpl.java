package com.suger.service.impl;

import com.suger.dao.StudentDao;
import com.suger.pojo.Page;
import com.suger.pojo.Student;
import com.suger.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * service 接口的实现类
 *
 * @author suger
 * @date 2018-10-02
 */
@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    // 使用注解自动注入dao接口
    @Autowired
    StudentDao studentDao;

    @Override
    public Long addStudent(Student student) {

        studentDao.addStudent(student);
        Long id = student.getId();
        logger.info("插入Id：{}", id);
        logger.info("添加的学生信息:"+student);
        return id;
    }

    @Override
    public Boolean updateStudent(Student student) {
        boolean flag = false;
        // i 为更新操作受影响的行数
        int i = studentDao.updateStudent(student);
        logger.info("更新id:{}", student.getId());
        logger.info("更新的学生信息:"+student);

        if (i != 0) {
            flag = true;
        }
        return flag;
    }

    @Override
    public Boolean deleteStudent(Long id) {
        boolean flag = false;
        logger.info("删除id为：{}的学生", id);
        // 记录将要删除的信息
        logger.info("删除的学生信息:"+studentDao.getStudentById(id));
        int i = studentDao.deleteStudent(id);
        if (i != 0) {
            flag = true;
        }
        return flag;

    }

    @Override
    public List<Student> findAll(Page page) {
        logger.info("进入分页查询");
        return studentDao.findAll(page);
    }

    @Override
    public List<Student> findAll() {
        logger.info("正在进行查询所有操作！");
        return studentDao.findAll();
    }

    @Override
    public int total() {
        int num = studentDao.total();
        return num;
    }

    @Override
    public Student getStudentById(Long id) {
        Student student = studentDao.getStudentById(id);
        logger.info("根据id：{}------查询学生：{}", id, student);
        return student;
    }

    @Override
    public List<Student> getStudentByName(String name) {
        return studentDao.getStudentByName(name);
    }


}
