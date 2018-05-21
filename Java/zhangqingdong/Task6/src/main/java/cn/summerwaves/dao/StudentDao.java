package cn.summerwaves.dao;

import cn.summerwaves.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    Student selectOneStudent(String number);
    void insertStudent(Student student);
}
