package com.longhang.stuService.impl;


import com.longhang.model.Curriculum;
import com.longhang.model.Student;
import com.longhang.stuDao.StuDao;
import com.longhang.stuService.StuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class StuServiceImpl implements StuService {
    @Resource
    private StuDao stuDao;
    public Student getStuById(Long id) {
        return this.stuDao.select(id);
    }
    public void getInsert(Student student) {
        this.stuDao.insert(student);
    }
    public boolean getUpdate(Student student) {
        return this.stuDao.update(student);
    }
    public boolean getDelete(Long id) {
        return this.stuDao.delete(id);
    }
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
    @Override
    public int getGetMajor(String major) {
        return this.stuDao.getMajor(major);
    }


    public void getInsertCu(Curriculum curriculum) {
        this.stuDao.insertCu(curriculum);
    }
    public boolean getUpdateCu(Curriculum curriculum) {
        return this.stuDao.updateCu(curriculum);
}
    public Curriculum getSelectCu(Long id) { return this.stuDao.selectCu(id); }
    public boolean getUpdateCuByName(String name ,int onnum){
        return this.stuDao.updateCuByName(name,onnum);
    }
    public boolean getDeleteCu(Long id) {
        return this.stuDao.deleteCu(id);
    }
    public List<Curriculum> getGetAllCu() {
        return stuDao.getAllCu();
    }

    @Override
    public ArrayList<String> getGetAllCuName() {
        return stuDao.getAllCuName();
    }


}