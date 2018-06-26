package com.tiles.service;

import com.tiles.dao.mapper.StudentMapper;
import com.tiles.model.Page;
import com.tiles.model.Student;
import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {


    private static Logger logger = Logger.getLogger(StudentServiceImpl.class);

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public int findAllCount(){
        return studentMapper.findAllCount();
    }

    @Override
    public List<Student> findAll() {
        return studentMapper.findAll();
    }

    ;

    @Override
    public Student findByID(int id) {
        return studentMapper.findByID(id);
    }

    @Override
    public List<Student> findByStudent(Student student) {
        return studentMapper.findByStudent(student);
    }

    @Override
    public int insertOne(Student student){
        return studentMapper.insertOne(student);
    };

    @Override
    public Page<Student> findByPage(int nowpage, int pagesize) {

        HashMap<String,Object> hashMap = new HashMap();
        Page<Student> page = new Page<>();

//        每页记录数
        int pageSize = pagesize;

//        封装当前页
        page.setCurrPage(nowpage);

//        封装每页记录数
        page.setPageSize(pageSize);

//        获取总记录数封装
        int totalC = studentMapper.findAllCount();
        page.setTotalConut(totalC);

//        向上取整 获取总页数
        double totalP = totalC;
        Double dbc = Math.ceil(totalP/pageSize);
        page.setTotalPage(dbc.intValue());

//        设置页面limit start size
        logger.info(hashMap.put("start",(nowpage-1)*pageSize));
        logger.info(hashMap.put("size",page.getPageSize()));
        page.setPages( studentMapper.findByPage(hashMap));

        return page;
    }
}
