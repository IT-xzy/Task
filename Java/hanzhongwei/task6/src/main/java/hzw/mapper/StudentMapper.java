package hzw.mapper;

import hzw.model.Student;

import java.util.List;

public interface StudentMapper {
    Student findIdStudent(Integer id);

    Student getID(Long id);

    Integer insertStudent(Student student);

    Integer deleteStudent(Integer id);

    Integer updateStudent(Student student);

    List<Student> findListStudent();

    List<Student> findNameStudent(String name);
}
