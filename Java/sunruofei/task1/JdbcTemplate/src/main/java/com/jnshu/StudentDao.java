package com.jnshu;

import java.util.List;

public interface StudentDao {
    int add(Student student);
    boolean delete(int id);
    boolean update(Student student);
    List<Student> findAll();
    Student findById(int id);


}
