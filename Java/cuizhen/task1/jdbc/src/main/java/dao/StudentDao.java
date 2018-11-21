package dao;


import pojo.Student;

import java.util.List;

public interface StudentDao {
    long add(Student s) throws Exception;
    boolean update(Student s) throws  Exception;
    boolean delete(long id) throws Exception;
    Student get(long id) throws Exception;
    List<Student> get(String name)throws Exception;
    List selectStudent()throws Exception;
}

