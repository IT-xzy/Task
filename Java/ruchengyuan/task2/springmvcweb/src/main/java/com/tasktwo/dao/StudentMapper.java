package com.tasktwo.dao;

import com.tasktwo.model.Student;
import java.util.List;

/**
 * 和mybatis的增删查改
 * Created by Administrator on 25/7/2017.
 */
public interface StudentMapper {
    Student studySelect(String userId);
    int studyInsert(Student student);
    int studyUpdate(Student student);
    int studyDelete(String userId);
    List<Student> studentAll();
}
