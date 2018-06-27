package com.longhang.stuService.impl;


import com.longhang.model.Curriculum;
import com.longhang.model.Student;
import com.longhang.stuDao.StuDao;
import com.longhang.stuService.StuService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class StuServiceImpl implements StuService {
    @Resource
    private StuDao stuDao;
    @Cacheable("getStuById") //标注该方法查询的结果进入缓存，再次访问时直接读取缓存中的数据
    public Student getStuById(Long id) {
        System.out.println("你好");
        return this.stuDao.select(id);
    }
    @CacheEvict(value = {"getStuById","getGetAll"},allEntries = true)//清空缓存，allEntries变量表示所有对象的缓存都清除
    public void getInsert(Student student) {
        this.stuDao.insert(student);
    }
    @CacheEvict(value = {"getStuById","getGetAll"},allEntries = true)
    public boolean getUpdate(Student student) {
        return this.stuDao.update(student);
    }
    @CacheEvict(value = {"getStuById","getGetAll"},allEntries = true)
    public boolean getDelete(Long id) {
        return this.stuDao.delete(id);
    }
    @Cacheable("getGetAll")
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