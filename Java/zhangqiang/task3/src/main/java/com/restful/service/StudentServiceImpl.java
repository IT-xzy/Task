package com.restful.service;

import com.restful.dao.mapper.StudentMapper;
import com.restful.model.Page;
import com.restful.model.Student;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    Logger logger = Logger.getLogger(StudentServiceImpl.class.getName());

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student selectById(int id) {
        return studentMapper.selectById(id);
    }

    @Override
    public List<Student> findByStudent(Student student) {
        return studentMapper.findByStudent(student);
    }

    @Override
    public int selectConut(){
        return studentMapper.selectConut();
    }

    @Override
    public int insertOne(Student student) {
        studentMapper.insertOne(student);
        return student.getId();
    }

    @Override
    public Page<Student> findByPage(int count,int psize){
        HashMap<String,Object> hashMap = new HashMap<String,Object>();
        Page<Student> page = new Page<>();

//        每页记录数
        int pageSize = psize;

//        封装当前页
        page.setCurrPage(count);

//        封装每页记录数
        page.setPageSize(pageSize);

//        获取总记录数封装
        int totalC = studentMapper.selectConut();
        page.setTotalConut(totalC);

//        向上取整 获取总页数
        double totalP = totalC;
        Double dbc = Math.ceil(totalP/pageSize);
        page.setTotalPage(dbc.intValue());

//        设置页面limit start size
        logger.info(hashMap.put("start",(count-1)*pageSize));
        logger.info(hashMap.put("size",page.getPageSize()));


//        封装每页的数据显示
        List<Student> lists = studentMapper.findByPage(hashMap);
        page.setPages(lists);

        logger.info(page.toString());
        return page;
    };

    @Override
    public int insertForList(List<Student> list) {
        return studentMapper.insertForList(list);
    }

    @Override
    public int deleteOne(int id) {
        return studentMapper.deleteOne(id);
    }

    @Override
    public int deleteForList(List list) {
        return studentMapper.deleteForList(list);
    }

    @Override
    public int updateOne(Student student) {
        return studentMapper.updateOne(student);
    }

    @Override
    public int updateForList(List<Student> list) {
        return studentMapper.updateForList(list);
    }
}
