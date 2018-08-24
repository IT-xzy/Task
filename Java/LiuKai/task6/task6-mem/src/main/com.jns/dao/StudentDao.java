package dao;

import org.apache.ibatis.annotations.Param;
import pojo.Student;
import java.util.HashMap;
import java.util.List;

public interface StudentDao {
    long countAll();

    long insertStudent(Student student);

    long regStudent(Student student);

    void deleteAll();

    long countJob();

    List<Student> findGood();

    int countCourse(String cour);

    boolean deleteById(long id);

    boolean updateStudent(Student student);

    boolean updateLogin(Student student);

    Student findById(long id);

    Student findByName(String stuName);

//   boolean findByName(String stuName);

//    List<Student> signByID(long id);

    List<Student> findLikeName(String name);

    List<Student> findAll();

    Student signIn(Student student);
}
