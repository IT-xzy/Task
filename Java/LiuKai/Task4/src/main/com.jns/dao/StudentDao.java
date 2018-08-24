package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Student;

import java.util.HashMap;
import java.util.List;

public interface StudentDao {
    long countAll();

    long insertStudent(Student student);

    void deleteAll();

    long countJob();

    List<Student> findGood();

    int countCourse(String cour);

    boolean deleteById(long id);

    boolean updateStudent(Student student);

    Student findById(long id);

    List<Student> findLikeName(String name);

    List<Student> findAll();

}
