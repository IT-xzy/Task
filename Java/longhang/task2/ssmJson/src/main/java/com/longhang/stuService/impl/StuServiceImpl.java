package com.longhang.stuService.impl;

import com.longhang.stuDao.StudentDao;
import com.longhang.stuModel.Student;
import com.longhang.stuService.StuService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class StuServiceImpl implements StuService {
    @Resource
    private StudentDao studentDao;
    public Student getStuById(Long id) {
        return this.studentDao.select(id);
    }
    public void getInsert(Student student) {
        this.studentDao.insert(student);
    }
    public boolean getUpdate(Student student) {
        return this.studentDao.update(student);
    }
    public boolean getDelete(Long id) {
        return this.studentDao.delete(id);
    }
    public List<Student> getGetAll() {
        return this.studentDao.getAll();
    }
    public Student getStu(Student student) {
        return this.studentDao.selects(student);
    }
}