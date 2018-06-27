package hzw.mapper;

import hzw.model.Student;

import java.util.List;

public interface StudentMapper {
    void addStu(Student student);

    void deleteStu(long stuId);

    void updateStu(Student student);

    Student getId(long stuId);

    List<Student> getAll();

    List<Student> getName(Student stu);

}
