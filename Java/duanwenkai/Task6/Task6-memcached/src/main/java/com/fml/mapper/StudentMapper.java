package com.fml.mapper;

import com.fml.pojo.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {

    boolean add(Student student);

    boolean deleteById(int id);

    boolean deleteAll();

    boolean update(Student student);

    Student getById(int id);

    List<Student> getByStatus(int status);

    int getTotalCount();

    int getWorkCount();

    int getStudentByLesson(int lesson_type);
}
