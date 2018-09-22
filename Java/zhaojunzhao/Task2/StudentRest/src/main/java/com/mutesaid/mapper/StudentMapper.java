package com.mutesaid.mapper;

import com.mutesaid.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    List<Student> getStudent();

    Student getById(Long id);

    void deleteStudent(Long id);

    void addStudent(Student stu);

    void updateStudent(@Param("id") Long id,
                       @Param("key") String key,
                       @Param("value") Object value,
                       @Param("updateTime") Long updateTime);
}
