package com.suger.service.impl;

import com.suger.dao.StudentDao;
import com.suger.pojo.Page;
import com.suger.pojo.Student;
import com.suger.util.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.suger.service.StudentService;

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
    @Autowired
    RedisUtils redisUtils;
    /**
     * 新增用户信息
     *
     * @param student 学生
     * @return id 插入记录的唯一标识
     */
    @Override
    public Long insertStudent(Student student) {
        Long id = studentDao.insertStudent(student);
        if(id != null){
            logger.info("新增学员成功，缓存失效，直接清空全部缓存");
            //redisUtils.delete("students");
            redisUtils.removePattern("students");
        }
        return id;
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
            logger.info("更新学员成功，缓存失效,清空全部数据");
            //redisUtils.delete("students");
            redisUtils.removePattern("students");
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
            logger.info("删除学员，缓存失效，清空全部数据");
            //redisUtils.delete("students");
            redisUtils.removePattern("students");
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
        List<Student> students;

        if(redisUtils.get("students"+page.getStart())==null){
            logger.info("缓存不存在数据，准备设置缓存");
            students = studentDao.findAll(page);
            redisUtils.set("students"+page.getStart(),students);
        } else {
            logger.info("缓存已经存在,准备读取缓存数据");
            students = (List<Student>) redisUtils.get("students"+page.getStart());
        }
        return students;
    }

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<Student> findAll() {
        logger.info("---------正在查询全部学生------------------");
        List<Student> students;
        if(redisUtils.get("students")==null){
            logger.info("缓存不存在数据，准备设置缓存");
            students = studentDao.findAll();
            redisUtils.set("students",students);
        }else {
            logger.info("缓存已经存在,准备读取缓存数据");
            students = (List<Student>) redisUtils.get("students");
        }
        return students;
    }

    /**
     * 查询记录总数
     *
     * @return 记录总数
     */
    @Override
    public int total() {
        int total = 0;
        if(redisUtils.get("studentsTotal")==null){
            logger.info("缓存不存在数据，准备设置缓存");
            total = studentDao.total();
            redisUtils.set("studentsTotal",total);
        } else{
            logger.info("缓存已经存在,准备读取缓存数据");
            total = (int) redisUtils.get("studentsTotal");
        }
        logger.info("学员总数："+total);
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
        List<Student> students;
        if(redisUtils.get("students"+tag)==null){
            students = studentDao.getStudentByType(tag);
            redisUtils.set("students"+tag,students);
        }else {
            logger.info("缓存已经存在,准备读取缓存数据");
            students = (List<Student>) redisUtils.get("students"+tag);
        }
        //students = studentDao.getStudentByType(tag);
        return students;
    }
}
