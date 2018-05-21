package com.fml.service.impl;

import com.fml.cache.JedisCache;
import com.fml.mapper.StudentMapper;
import com.fml.pojo.Student;
import com.fml.service.StudentService;
import com.fml.utils.DateUtil;
import com.fml.utils.MD5Util;
import com.fml.utils.UUIDUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    StudentMapper studentMapper;
    @Resource
    JedisCache jedisCache;

    @Override
    public boolean add(Student student) {
        student.setCreateAt(System.currentTimeMillis());
        student.setUpdateAt(System.currentTimeMillis());
        student.setSalt(UUIDUtil.getUUID());
        //进行MD5加密,将加密后的密文作为密码
        student.setPassword(MD5Util.getMd5withSalt(student.getPassword(),student.getSalt()));
        return studentMapper.add(student);
    }

    @Override
    public boolean deleteById(long id) {
        return false;
    }

    @Override
    public boolean deleteAll() {
        return false;
    }

    @Override
    public boolean update(Student student) {
        return studentMapper.update(student);
    }

    @Override
    public Student getById(long id) {
        return studentMapper.getById(id);
    }

    @Override
    public Student getByUserName(String userName) {
        return studentMapper.getByUserName(userName);
    }

    @Override
    public Student getByPhone(String phone) {
        return studentMapper.getByPhone(phone);
    }

    @Override
    public Student getByEmail(String email) {
        return studentMapper.getByEmail(email);
    }


    /**
     * 判断是用户名/邮箱/手机登录，执行登录判断
     * @param entity
     * @return
     */
    @Override
    public boolean login(Student entity){
        /*定义邮箱和手机号的正则*/
        String email = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*$";
        String phone = "^[1][3578]\\d{9}$";

        /*登录时的用户名和密码*/
        String account = entity.getUserName();
        String password = entity.getPassword();

        if (account.matches(email)){        //邮箱
            Student student = getByEmail(account);
            if (student == null){
                LOGGER.info("邮箱登录：该用户不存在！");
                return false;
            }
            String pwd = student.getPassword();
            String salt = student.getSalt();

            //判断账户密码是否匹配
            if (MD5Util.getMd5withSalt(password,salt).equals(pwd)){
                LOGGER.info(DateUtil.format(new Date()) + "：邮箱登陆成功！");
                return true;
            }
        } else if (account.matches(phone)){    //手机
            Student student = getByPhone(account);
            if (student == null){
                LOGGER.info("手机登录：该用户不存在！");
                return false;
            }
            String pwd = student.getPassword();
            String salt = student.getSalt();
            //判断账户密码是否匹配
            if (MD5Util.getMd5withSalt(password,salt).equals(pwd)){
                LOGGER.info(DateUtil.format(new Date()) + "：手机号登陆成功！");
                return true;
            }
        } else {
            Student student = getByUserName(account);      //用户名
            if (student == null){
                LOGGER.info("用户名登录：该用户不存在！");
                return false;
            }
            String pwd = student.getPassword();
            String salt = student.getSalt();
            //判断账户密码是否匹配
            if (MD5Util.getMd5withSalt(password,salt).equals(pwd)){
                LOGGER.info(DateUtil.format(new Date()) + "：用户名登陆成功！");
                return true;
            }
        }

        return false;
    }


    @Override
    public List<Student> getByStatus() {
        if (jedisCache.get("superStudentList") != null){
            LOGGER.info("缓存读取优秀学生...");
            return (List<Student>)jedisCache.get("superStudentList");
        }else {
            LOGGER.info("数据库读取优秀学生...");
            List<Student> list = studentMapper.getByStatus();

            jedisCache.set("superStudentList",list);
            return list;
        }
    }

    @Override
    public int getTotalCount() {
        if (jedisCache.get("totalCount") != null){
            LOGGER.info("缓存读取学员总数...");
            return (int)jedisCache.get("totalCount");
        }else {
            LOGGER.info(" 数据库读取学员总数...");
            int result = studentMapper.getTotalCount();
            jedisCache.set("totalCount",result);
            return result;
        }
    }

    @Override
    public int getWorkCount() {
        if (jedisCache.get("workCount") != null){
            LOGGER.info("缓存读取已经就业学员总数...");
            return (int)jedisCache.get("workCount");
        }else {
            LOGGER.info(" 数据库读取已经就业学员总数...");
            int result = studentMapper.getWorkCount();
            jedisCache.set("workCount",result);
            return result;
        }
    }

    @Override
    public List<Integer> getStudentByLesson() {
        List<Integer> studentList = new ArrayList<>();

        if (jedisCache.getStudentByLesson("studentList") != null){
            LOGGER.info("缓存读取各个课程学员数量...");
            return jedisCache.getStudentByLesson("studentList");
        }else {
            for (int i = 1; i <= 12; i++){
                studentList.add(studentMapper.getStudentByLesson(i));
            }
            LOGGER.info("数据库读取各个课程学员数量...");
            jedisCache.setStudentByLesson("studentList",studentList);
            return studentList;
        }
    }
}
