package service;

import pojo.Student;

import java.util.List;

public interface StudentService {

    long insertStudent(Student student);

    void deleteAll();

    long countAll();

    long countJob();

    List<Student> findGood();

    int countCourse(String cour);

    boolean deleteById(long id);

    boolean updateStudent(Student student);

    Student findById(long id);

    List<Student> findLikeName(String name);

    List<Student> findAll();


}
