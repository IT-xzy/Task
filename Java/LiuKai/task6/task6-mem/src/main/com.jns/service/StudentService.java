package service;

import pojo.Student;

import java.util.List;

public interface StudentService {

    long insertStudent(Student student);

    long regStudent(Student student);

    void deleteAll();

    long countAll();

    long countJob();

    List<Student> findGood();

    int countCourse(String cour);

    boolean deleteById(long id);

    boolean updateStudent(Student student);

    boolean updateLogin(Student student);

    Student findById(long id);

    Student findByName(String stuName);

//   boolean findByName(String stuName);

    List<Student> findLikeName(String name);

    List<Student> findAll();

    Student signIn(Student student);
}
