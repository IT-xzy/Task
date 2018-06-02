package dao.mapper;

import model.Student;

import java.util.List;


public interface StudentMapper {

    Student selectById(int id);

    List<Student> findByStudent(Student student);

    int insertOne(Student student);

    int insertForList(List<Student> list);

    int deleteOne(int id);

    int deleteForList(List list);

    int updateOne(Student student);

    int updateForList(List<Student> list);

}
