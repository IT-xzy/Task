package com.ev.dao;

import com.ev.bean.Student;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface StudentMapper {

    List<Student> findByPage(HashMap<String,Object> map);

    List<Student> selectStudentList();

    int selectCount();

    boolean insertStudent(Student student);

    boolean deleteStudent(Long id);

    List<Student> findByName(String name);

    List<Student> findByNumber(String number);

    Student findById(Long id);

    boolean updateStudent(Student student);

    void reset();
}
