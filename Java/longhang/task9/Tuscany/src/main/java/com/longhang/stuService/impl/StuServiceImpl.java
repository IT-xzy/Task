package com.longhang.stuService.impl;


import com.longhang.model.Student;
import com.longhang.stuDao.StuDao;
import com.longhang.stuService.StuService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service

public class StuServiceImpl implements StuService {
   private static Logger logger=Logger.getLogger("StuServiceImpl.class");
    @Resource
    private StuDao stuDao;

    public Student getStuById(Long id) {
        logger.info("你好");
        return this.stuDao.select(id);
    }
   // @Reference
    public void getInsert(Student student) {
        this.stuDao.insert(student);
    }
   // @Reference
    public boolean getUpdate(Student student) {
        return this.stuDao.update(student);
    }
    public boolean getDelete(Long id) {
        return this.stuDao.delete(id);
    }
   // @Reference
    public List<Student> getGetAll() {
        return this.stuDao.getAll();
    }
    public List<Student> getGetAllExcellent() {
        return this.stuDao.getAllExcellent();
    }
    public Student getStu(Student student) {
        return this.stuDao.selects(student);
    }
    public int getGetCount(){return this.stuDao.getCount();}
    public int getGetCountG(){return stuDao.getCountG();}
    public int getGetMajor(String major) {
        return this.stuDao.getMajor(major);
    }
    public String[] getGetPicture() {
        return this.stuDao.getPicture();
    }





}