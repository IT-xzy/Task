package com.ptteng;

import com.ptteng.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CheckStudent {

    @Autowired
    private StudentService studentService;


    //计算总条数
    public long count() {
        long allItem = studentService.count(); //数据总条数已知
        return allItem;
    }

    public long findAllPage() {
        long allPage;
        if (studentService.count() % 10 == 0) {
            allPage = studentService.count() / 10;
        } else {
            allPage = (studentService.count() / 10) + 1;
        }
        return allPage;
    }


    public List<Student> findPageStudent(long page) {
        long pageStart = (page - 1) * 10;
        List<Student> students = studentService.findPage(pageStart);
        return students;
    }

}


