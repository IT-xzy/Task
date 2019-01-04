package mapper;

import pojo.Student;

import java.util.List;

public interface StudentMapper {

     Student addStudent(Student student);
     int updateStudent(Student student);
     int deleteStudent(int id);
     Student selectStudent(int id);
     Student selectStudentName(String name);
     List<Student> findAll();

}
