package task.dao;

import task.pojo.Student;

import java.util.List;

public interface StudentDao
{
    int insertStudent(Student student);

    int deleteStudent(String studyId);

    int updateStudent(Student student);

    Student selectStudent(String studyId);

    List<Student> selectAllStudent();
}
