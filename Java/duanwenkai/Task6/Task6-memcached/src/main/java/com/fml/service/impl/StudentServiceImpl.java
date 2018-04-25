package com.fml.service.impl;

import com.alibaba.fastjson.JSON;
import com.fml.cache.StudentCache;
import com.fml.mapper.StudentMapper;
import com.fml.pojo.Student;
import com.fml.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Autowired
    StudentMapper studentMapper;

    @Autowired
    StudentCache studentCache;

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

        if (studentCache.get("superStudentList") != null){
            LOGGER.info("缓存读取优秀学生...");
            Object obj = studentCache.get("superStudentList");
            return JSON.parseArray(obj.toString(),Student.class);
        }else {
            LOGGER.info("数据库读取优秀学生...");
            List<Student> list = studentMapper.getByStatus(status);
            /*Memcached不能直接存储集合，可以先转化为json字符串*/
            String json = JSON.toJSONString(list);
            studentCache.set("superStudentList",json);
            return list;
        }
    }

    @Override
    public int getTotalCount() {
        if (studentCache.get("totalCount") != null){
            LOGGER.info("缓存读取学员总数...");
            return (int)studentCache.get("totalCount");
        }else {
            LOGGER.info(" 数据库读取学员总数...");
            int result = studentMapper.getTotalCount();
            studentCache.set("totalCount",result);
            return result;
        }
    }

    @Override
    public int getWorkCount() {
        if (studentCache.get("workCount") != null){
            LOGGER.info("缓存读取已经就业学员总数...");
            return (int)studentCache.get("workCount");
        }else {
            LOGGER.info(" 数据库读取已经就业学员总数...");
            int result = studentMapper.getWorkCount();
            studentCache.set("workCount",result);
            return result;
        }
    }



    @Override
    public List<Integer> getStudentByLesson() {
        List<Integer> studentList = new ArrayList<>();

        if (studentCache.get("studentList") != null){
            return (List<Integer>)studentCache.get("studentList");
        }else {
            for (int i = 1; i <= 12; i++){
                studentList.add(studentMapper.getStudentByLesson(i));
            }
            studentCache.set("studentList",studentList);
            return studentList;
        }
    }
}
