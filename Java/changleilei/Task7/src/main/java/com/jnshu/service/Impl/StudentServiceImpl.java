package com.jnshu.service.Impl;
import com.jnshu.utils.RedisUtil;
import com.jnshu.dao.StudentDao;
import com.jnshu.model.Student;
import com.jnshu.service.StudentService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Resource
    private StudentDao studentDao;
    private Logger logger = Logger.getLogger(StudentServiceImpl.class);
    @Resource
    private RedisUtil redisUtil;

    @Override
    public List<Student> studentList() {
        List<Student> studentList = (List<Student>) redisUtil.get("studentList");
        if (studentList != null) {
            // 从缓存读取数据
            return studentList;
        } else {
            // List<Student> userList = 从数据库取
            studentList = studentDao.selectAll();
            redisUtil.set("studentList", studentList, 60 * 60L);
        }
        // 业务逻辑
        return studentList;
    }

    @Override
    public Student selectByName(String name) {
        Student student = null;
        // 定义一个如果是数据库不存在的数据的签名，查询数据前，先查询这条缓存不存在
        String namecheck = name + "nulls";
        Boolean bool = redisUtil.haskey(namecheck);
        // 如果缓存中存在该条空数据，就停止查询，直接向控制器返回空数据，让控制器处理视图
        if (bool == true) {
            return student;
        } else {
            // 如果缓存中不存在该条空数据，就从缓存中读取真实数据
            student = (Student) redisUtil.get(name);
            if (student == null) {
                // 如果缓存中存在该条真数据，那就这直接返回 如果缓存中不存在该条数据，就去数据库查询是否存在此条记录
                student = studentDao.selectByName(name);
                if (student != null) {
                    // 如果数据库中存在真实的记录，那就将真实数据写入缓存
                    redisUtil.set(name, student, 60l);
                } else {
                    // 如果数据库表示此记录不存在，那么便向缓存写入空数据缓存，该缓存会在短时间后消失
                    redisUtil.set(namecheck, student, 30l);
                }
            }
        }
        return student;
    }

    @Override
    public int insert(Student record) {
        int a = studentDao.insert(record);
        List<Student> studentList = null;
        studentList = studentDao.selectAll();
        redisUtil.set("studentList", studentList, 60 * 60L);
        return a;
    }

    @Override
    public int deleteById(Integer id) {
        redisUtil.del("studentList");
        return studentDao.deleteById(id);
    }

    @Override
    public Student selectById(Integer id) {
        return studentDao.selectById(id);
    }

    @Override
    public int upPortraitByPhone(String portrait, String name) {
        return studentDao.upPortraitByPhone(portrait, name);
    }
    @Override
    public int upPortraitByEmail(String portrait, String email) {
        return studentDao.upPortraitByPhone(portrait, email);
    }

    @Override
    public String selectPortraitByName(String name) {
        return studentDao.selectPortraitByName(name);
    }

    @Override
    public String selectPortraitByPhone(String telphone) {
        return studentDao.selectPortraitByPhone(telphone);
    }
}
