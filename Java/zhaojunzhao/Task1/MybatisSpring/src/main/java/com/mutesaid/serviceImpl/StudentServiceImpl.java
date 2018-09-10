package com.mutesaid.serviceImpl;
import com.mutesaid.mapper.StudentMapper;
import com.mutesaid.pojo.Student;
import com.mutesaid.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    private Logger logger = LogManager.getLogger(StudentServiceImpl.class);

    @Override
    public List<Student> getStudent(String key, Object value) {
        return studentMapper.getStudent(key, value);
    }

    @Override
    public Long insert(Student stu) {
        long currentTime = System.currentTimeMillis();
        stu.setCreateAt(currentTime);
        stu.setUpdateAt(currentTime);
        studentMapper.insert(stu);
        return stu.getId();
    }

    @Override
    public Boolean delete(String onlineId) {
        try{
            studentMapper.delete(onlineId);
            return true;
        }catch (Exception e){
            logger.info("删除失败");
            logger.info("-----------------");
            logger.info(e);
            logger.info("-----------------");
            return false;
        }

    }

    @Override
    public Boolean update(String onlineId, String key, Object value, long currentTime) {
        try{
            studentMapper.update(onlineId, key, value, currentTime);
            return true;
        }catch (Exception e){
            logger.info("更新失败");
            logger.info("-----------------");
            logger.info(e);
            logger.info("-----------------");
            return false;
        }
    }
}
