package com.zyq.service.Impl;

import com.zyq.mapper.StudentMapper;
import com.zyq.pojo.Page;
import com.zyq.pojo.Student;
import com.zyq.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("StudentServiceImpl")
public class StudentServiceImpl implements StudentService {
    @Autowired
    StudentMapper studentMapper;

    @Override
    public Student insert(Student student) {
        student.setCreateTime(System.currentTimeMillis());
        student.setUpdateTime(System.currentTimeMillis());
        studentMapper.insert(student);
        return student;
    }

    @Override
    public Page<Student> selectAllByPage(Integer currPage, Integer pageSize) {
        Integer totalNum = studentMapper.selectTotalNum();
        Integer startNum = (currPage - 1) * pageSize;
        List<Student> list = studentMapper.selectStudentsByPage(startNum, pageSize);
        Page<Student> page = new Page<>(currPage, pageSize, totalNum, list);
        if (currPage > page.getTotalPage()) {
            return selectAllByPage(currPage - 1, pageSize);
        } else {
            return page;
        }
    }

    @Override
    public Page<Student> selectAllByPage(Integer currPage) {
        Integer totalNum = studentMapper.selectTotalNum();
        Page<Student> page = new Page<>();
        Integer startNum = (currPage - 1) * page.getPageSize();
        List<Student> list = studentMapper.selectStudentsByPage(startNum, page.getPageSize());
        page.setCurrPage(currPage);
        page.setList(list);
        page.setTotalNum(totalNum);
        if (currPage > page.getTotalPage()) {
            return selectAllByPage(page.getTotalPage());
        } else {
            return page;
        }
    }

    @Override
    public Student selectById(Long id) {
        return studentMapper.selectById(id);
    }


    @Override
    public void updateById(Student student) {
        student.setUpdateTime(System.currentTimeMillis());
        studentMapper.updateById(student);
    }

    @Override
    public void deleteById(Long id) {
        Student student = new Student();
        student.setId(id);
        studentMapper.deleteById(student);
    }

    @Override
    public Page<Student> selectByNameAndNum(String name, Integer number, Integer currPage) {
        Integer totalNum = studentMapper.selectTotalNumByNameAndNum(name, number);
        Page<Student> page = new Page<>();
        Integer startNum = (currPage - 1) * page.getPageSize();
        List<Student> list = studentMapper.selectStudentsByNameAndNum(name, number, startNum, page.getPageSize());
        page.setCurrPage(currPage);
        page.setList(list);
        page.setTotalNum(totalNum);
        if (page.getTotalPage() == 0 || currPage <= page.getTotalPage()) {
            return page;
        } else {
            return selectByNameAndNum(name, number, currPage - 1);
        }
    }

    @Override
    public Page<Student> selectByNum(Integer number, Integer currPage) {
        Integer totalNum = studentMapper.selectTotalNumByNum(number);
        Page<Student> page = new Page<>();
        Integer startNum = (currPage - 1) * page.getPageSize();
        List<Student> list = studentMapper.selectStudentsByNum(number, startNum, page.getPageSize());
        page.setCurrPage(currPage);
        page.setList(list);
        page.setTotalNum(totalNum);
        if (page.getTotalPage() == 0 || currPage <= page.getTotalPage()) {
            return page;
        } else {
            return selectByNum(number, currPage - 1);
        }
    }

    @Override
    public Page<Student> selectByName(String name, Integer currPage) {
        Integer totalNum = studentMapper.selectTotalNumByName(name);
        Page<Student> page = new Page<>();
        Integer startNum = (currPage - 1) * page.getPageSize();
        List<Student> list = studentMapper.selectStudentsByName(name, startNum, page.getPageSize());
        page.setCurrPage(currPage);
        page.setList(list);
        page.setTotalNum(totalNum);
        if (page.getTotalPage() == 0 || currPage <= page.getTotalPage()) {
            return page;
        } else {
            return selectByName(name, currPage - 1);
        }
    }
}
