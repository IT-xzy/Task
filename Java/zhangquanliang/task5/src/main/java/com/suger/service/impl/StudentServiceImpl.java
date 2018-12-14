package com.suger.service.impl;

import com.suger.dao.StudentDao;
import com.suger.dao.UserDao;
import com.suger.pojo.Page;
import com.suger.pojo.Student;
import com.suger.pojo.User;
import com.suger.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author suger
 * @date 2018/11/29 21:21
 */
@Service
public class StudentServiceImpl implements StudentService {

    private static final Logger logger = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    StudentDao studentDao;
    /**
     * 新增用户信息
     *
     * @param student 学生
     * @return id 插入记录的唯一标识
     */
    @Override
    public Long insertStudent(Student student) {
        return studentDao.insertStudent(student);
    }

    /**
     * 更新学生信息
     *
     * @param student 学生
     * @return 更新结果：true-----更新成功，false------更新失败
     */
    @Override
    public Boolean updateStudent(Student student) {

        boolean flag = false;
        int i = studentDao.updateStudent(student);
        logger.info("更新id:{}",student.getId());
        logger.info("更新的信息:"+student);

        if (i != 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * 删除学生信息
     *
     * @param id 学生id
     * @return 删除结果：true-----删除成功，false------更新失败
     */
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

    /**
     * 分页查询
     *
     * @param page 分页工具类
     * @return
     */
    @Override
    public List<Student> findAll(Page page) {
        logger.info("进入分页查询：当前页开始记录："+page.getStart());
        return studentDao.findAll(page);
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Student> findAll() {
        logger.info("---------正在查询全部学生------------------");
        return studentDao.findAll();
    }

    /**
     * 查询记录总数
     *
     * @return 记录总数
     */
    @Override
    public int total() {
        return studentDao.total();
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return 具体的学生信息
     */
    @Override
    public Student getStudentById(Long id) {
        Student student = studentDao.getStudentById(id);
        logger.info("根据id：{}------查询用户：{}", id, student);
        return student;
    }

    /**
     * 根据姓名 模糊查询，如果条件为空，则实现查全表
     *
     * @param name
     * @return
     */
    @Override
    public List<Student> getStudentByName(String name) {
        if(name==null){
            logger.info("输入姓名为空，正在进行分页查询");
        }
        logger.info("根据姓名模糊查询");
        return studentDao.getStudentByName(name);
    }

    /**
     * 查询工作或者在学的学员列表  tag=1,在学，tag=0 工作
     *
     * @param tag
     * @return
     */
    @Override
    public List<Student> getStudentByType(Boolean tag) {
        return studentDao.getStudentByType(tag);
    }
}
