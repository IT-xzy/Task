package com.jnshu.service.impl;

import com.alibaba.fastjson.JSON;
import com.jnshu.dao.StudentMapper;
import com.jnshu.pojo.Student;
import com.jnshu.service.StudentService;
import com.jnshu.tool.redis.Redis;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author pipiretrak
 * @date 2019/3/30 - 5:51
 */
@Service
public class StudentServiceImp implements StudentService {
    private static Logger logger = Logger.getLogger(StudentServiceImp.class);

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    Redis redis;

    @Override
    public int insertSelective(Student record) {
        return insertSelective(record);
    }

    @Override
    public List<Student> getAll() {
        List rs = (List) redis.getObj("student","info");
        logger.info("缓存里的结果："+rs);
        if (rs==null){
            logger.info("从数据库取");
            List<Student> student = studentMapper.getAll();
            redis.addObj("student","info",student);
            logger.info("查询的学生："+student.size());
            return student;
        }
        return rs;
    }

    @Override
    public int insert(Student recond) {
        int rs =studentMapper.insert(recond);
        if (rs == 1){
            redis.delete("student");
            logger.info("缓存已清空");
        }
        return rs;
    }

    @Override
    public int deleteStudent(Long id) {
        int rs =studentMapper.deleteByPrimaryKey(id);
        if ( rs == 1) {
            redis.delete("studentId");
            redis.addObj("student","newStudentId",null);
            List<Student> rs1 = (List<Student>) redis.getObj("student","info");
            rs1.removeIf (student -> student.getId ().equals (id));
            redis.addObj("student","info",rs1);
        }
        return rs;
    }

    @Override
    public int updateByPrimaryKey(Student recond) {
        int rs =studentMapper.updateByPrimaryKey(recond);
        if (rs == 1){
            redis.delete("student");
            redis.delete("studentId");
            logger.info("更新前的缓存已清空");
        }
        return rs;
    }

    @Override
    public List<Student> selectByName(String name) {
        if(name == null|| name.matches (".*[0-9].*")){
            logger.info("防穿透！！");
            return null;
        }
        logger.info("名字："+name);
        List<Student> rs = (List<Student>) redis.getObj("studentId",name);
        logger.info("缓存是："+rs.size());
        if (rs != null){
            return rs;
        }
        logger.info(JSON.toJSONString(rs));
        logger.info("没有缓存");
        List<Student> rs1 =studentMapper.selectByName(name);
        if (rs1!=null || rs1.isEmpty()) {
            redis.addObj("studentId", name, rs1);
            logger.info("缓存存进去了");
        }
        else {
            logger.info("防穿透");
            redis.addObj("studentId",name,"1");
        }
        return rs1;
    }

    @Override
    public Student selectByPrimaryKey(Long id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
