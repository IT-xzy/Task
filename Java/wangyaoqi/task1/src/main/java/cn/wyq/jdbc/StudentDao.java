package cn.wyq.jdbc;

import cn.wyq.pojo.Student;

import java.util.List;

public interface StudentDao {
    public void insert(Student s);
    public void update(Student s);
    public void delete(int id);
    public Student get(int id);
//    public Student query(String name);
    public List<Student> listname(String name);
}
