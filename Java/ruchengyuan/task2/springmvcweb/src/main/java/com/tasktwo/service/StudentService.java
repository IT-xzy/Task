package com.tasktwo.service;

import com.tasktwo.model.Student;

import java.util.List;

/**
 * 对student进行CRUD的服务层接口
 * Created by Administrator on 25/7/2017.
 */
public interface StudentService {
     Student getUserId(String userId);
     int studyInsert(Student student);
     int studyUpdate(Student student);
     int studyDelete(String userId);
     List<Student> studentAll();
}
