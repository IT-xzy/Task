package test.springmvc.mapper;


import test.springmvc.pojo.Student;

import java.util.List;

public interface StudentMapper {
    int add(Student student);
    void delete(int id);
    Student getOne(int id);
    int update(Student student);
    List<Student> list();
//    public List<Student> list(Page page);
//    public int total();
}
