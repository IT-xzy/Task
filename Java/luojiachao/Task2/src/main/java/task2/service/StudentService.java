package task2.service;


import task2.pojo.Student;
import task2.util.Page;

import java.util.List;

public interface StudentService{

    int add(Student student) throws Exception;

    boolean delete(int id);
    //根据id查询
    Student findById(int id);
    //根据姓名模糊查询
    List<Student> findByName(String stu_name) throws Exception;

    boolean update(Student student) throws Exception;

    void reset() throws Exception;

    List<Student> list();

//    int total();
//
//    List<User> list(Page page);
}