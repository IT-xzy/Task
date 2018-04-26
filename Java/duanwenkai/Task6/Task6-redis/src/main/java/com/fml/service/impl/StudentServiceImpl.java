package com.fml.service.impl;

import com.fml.cache.JedisCache;
import com.fml.mapper.StudentMapper;
import com.fml.pojo.Student;
import com.fml.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
        return studentMapper.add(student);
    }

    @Override
    public boolean deleteById(int id) {
        return studentMapper.deleteById(id);
    }

    @Override
    public boolean deleteAll() {
        return studentMapper.deleteAll();
    }

    @Override
    public boolean update(Student student) {
        return studentMapper.update(student);
    }

    @Override
    public Student getById(int id) {
        return studentMapper.getById(id);
    }

    @Override
    public List<Student> getByStatus(int status) {

        if (jedisCache.get("superStudentList") != null){
            LOGGER.info("缓存读取优秀学生...");
            return (List<Student>)jedisCache.get("superStudentList");
        }else {
            LOGGER.info("数据库读取优秀学生...");
            List<Student> list = studentMapper.getByStatus(status);

            for (int i = 0; i < 4; i++){

            }
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
