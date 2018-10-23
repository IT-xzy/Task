package com.jnshuboot.service.imp;

import com.jnshuboot.dao.StudentMapper;
import com.jnshuboot.pojo.Student;
import com.jnshuboot.pojo.example.StudentExample;
import com.jnshuboot.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class StudentServiceImp implements StudentService {

    @Autowired(required = false)
    private StudentMapper studentMapper;
    @Autowired
    private StudentExample studentExample;

    @Override
    public int insertSelective(Student student) {
        //增加数据，如果不填写会有默认值；studyId不填写会有-10返回,进行插入；
        int i = -999;
        studentExample.clear();
        if (student.getStudyId() != null) {
            student.setCreateAt(System.currentTimeMillis());
            student.setUpdateAt(System.currentTimeMillis());
            i = studentMapper.insertSelective(student);
            log.info("数据库插入ID为{}的student数据成功", student.getId());
            return i;
        }
        return i;
    }

    @Override
    public Student insertSelective2(Student student) {
        //增加数据，如果不填写会有默认值；studyId不填写会有-10返回,进行插入；
        int i = -999;
        Student student1 = new Student();
        studentExample.clear();
        if (student.getStudyId() != null) {
            student.setCreateAt(System.currentTimeMillis());
            student.setUpdateAt(System.currentTimeMillis());
            i = studentMapper.insertSelective(student);
            studentExample.createCriteria().andIdEqualTo(student.getId());
            List<Student> list = studentMapper.selectByExample(studentExample);
            student1 = list.get(0);
            log.info("数据库插入ID为{}的student数据成功", student.getId());
            return student1;
        }
        return student1;
    }

    @Override
    public int deleteById(Integer id) {
        //根据studyId删除数据,空的studyId返回-10；
        int i = -999;
        studentExample.clear();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        if (id != null) {
            criteria.andIdEqualTo(id);
            i = studentMapper.deleteByExample(studentExample);
            log.info("数据库删除ID为{}的student数据成功", id);
            return i;
        }
        return i;
    }

    @Override
    public int updateById(Student student) {
        //更新数据，条件为studyId不为空；
        int i = -999;
        studentExample.clear();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        if (student.getId() != null) {
            criteria.andIdEqualTo(student.getId());
            student.setUpdateAt(System.currentTimeMillis());
            i = studentMapper.updateByExampleSelective(student, studentExample);
            log.info("数据库更新ID为{}的student数据成功", student.getId());
            return i;
        }
        return i;
    }


    @Override
    public Student updateById2(Student student) {
        //更新数据，条件为studyId不为空；
        int i = -999;
        Student student1 = new Student();
        studentExample.clear();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        if (student.getId() != null) {
            criteria.andIdEqualTo(student.getId());
            student.setUpdateAt(System.currentTimeMillis());
            i = studentMapper.updateByExampleSelective(student, studentExample);
            studentExample.createCriteria().andIdEqualTo(student.getId());
            List<Student> list = studentMapper.selectByExample(studentExample);
            student1 = list.get(0);
            log.info("数据库更新ID为{}的student数据成功", student.getId());
            return student1;
        }
        return student1;
    }

    @Override
    public Student selectById(Integer id) {
        Student student1 = new Student();
        //根据学生studyId查询学生数据，studyId不为空
        List<Student> studentList = new ArrayList<>();
        studentExample.clear();
        StudentExample.Criteria criteria = studentExample.createCriteria();
        try {
            criteria.andIdEqualTo(id);
            studentList = studentMapper.selectByExample(studentExample);
            //数据不存在时，会出现index异常；
            student1 = studentList.get(0);
            log.info("从数据库查询的id为:{}的student数据成功!", id);
            return student1;
        } catch (IndexOutOfBoundsException e) {
            //没有数据出现的index异常
            log.error("从数据库查询的id为{}的student数据不存在", id);
        }
        return student1;
    }

    @Override
    public List<Student> selectPage(Integer pageNum, Integer pageSize) {
        studentExample.clear();
        studentExample.setLimit(pageSize);
        //输入格式错误给一个默认值；
        if (pageNum <= 0) {
            pageNum = 1;
        }
        if (pageSize <= 0) {
            pageSize = 1;
        }
//        Integer pageEnd=pageNum*pageSize;
        Integer pageStart = pageNum * pageSize - pageSize;
        studentExample.setOffset(pageStart);
        studentExample.setLimit(pageSize);
        List<Student> list = studentMapper.selectByExample(studentExample);
        log.info("从数据库查询分页数据pageNum={},pageSize{}的student数据成功", pageNum, pageSize);
        return list;
    }

    @Override
    public int exist(Student student) {
        int i = -999;
        studentExample.clear();
        return i;
    }

    @Override
    public long countAll() {
        Long lon = -999L;
        studentExample.clear();
        lon = studentMapper.countByExample(studentExample);
        return lon;
    }
}
