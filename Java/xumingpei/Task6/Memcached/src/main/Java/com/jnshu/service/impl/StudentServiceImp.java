package com.jnshu.service.impl;

import com.jnshu.dao.StudentMapper;
import com.jnshu.pojo.Student;
import com.jnshu.pojo.tool.memcached.MemcachedUtil;
import com.jnshu.service.StudentService;
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
    MemcachedUtil memcachedUtil;

    @Override
    public int insertSelective(Student record) {
        return insertSelective(record);
    }

    @Override
    public List<Student> getAll() {
        List<Student> rs = (List<Student>) memcachedUtil.get("student");
        logger.info("111111111111111111");
        if (rs!=null){
            logger.info("从缓存里取");
            return rs;
        }
        else{
            logger.info("从数据库取");
            List<Student> student = studentMapper.getAll();
            boolean state = memcachedUtil.set("student",18000,student);
            logger.info("存进缓存没："+state);
            return student;
        }
    }

    @Override
    public int insert(Student recond) {
        int rs =studentMapper.insert(recond);
        if (rs == 1){
            memcachedUtil.delete("info");
        }
        return rs;
    }

    @Override
    public boolean deleteStudent(Long id) {
        boolean rs =studentMapper.deleteByPrimaryKey(id);
        logger.info("更新了数据没："+rs);
        boolean cache =memcachedUtil.delete("" + id);
        logger.info("更新缓存与否" + cache);
        return rs;
    }

    @Override
    public int updateByPrimaryKey(Student recond) {
        int rs =studentMapper.updateByPrimaryKey(recond);
        if (rs == 1){
            memcachedUtil.delete("info");
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
        List<Student> rs = (List<Student>) memcachedUtil.get(name);
        logger.info("缓存是："+rs);
        if (rs == null){
        logger.info("没有缓存");
        List<Student> rs1 =studentMapper.selectByName(name);
        memcachedUtil.set(name,1200,rs1);
        logger.info("存进去的key："+name+"为："+rs1.toString());
        return rs1;
        }else {
            logger.info("本来就有缓存");
        }
        return rs;
    }

    @Override
    public Student selectByPrimaryKey(Long id) {
        return studentMapper.selectByPrimaryKey(id);
    }
}
