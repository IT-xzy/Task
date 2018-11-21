package mapper;

import pojo.Student;

import java.util.List;

public interface StudentMapper {
     int addStudent(Student student);
     int updateStudent(Student student);
     int deleteStudent(long id);
     Student selectStudent(int id);
     List<Student> selectStudentName(String name);

     List<Student> findAll();

}
