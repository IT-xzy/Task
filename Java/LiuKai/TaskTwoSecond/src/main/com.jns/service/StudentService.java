package service;

import pojo.PageBean;
import pojo.Student;

import java.util.List;

public interface StudentService {

    long insertStudent(Student student);

    boolean deleteById(long id);

    void deleteAll();

    boolean updateStudent(Student student);

    Student findById(long id);

    List<Student> findLikeName(String name);

    List<Student> findAll();

    List<Student> findByPage(int currentPage);

//    PageBean<Student> findByPage(int currPage);

    List<Student> getList(int start,int pageNum);

}
