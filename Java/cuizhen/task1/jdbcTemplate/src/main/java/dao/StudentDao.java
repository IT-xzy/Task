package dao;

import pojo.Student;

import java.util.List;
import java.util.Map;

public interface StudentDao {
     int add(Student s) throws Exception;
     boolean update(Student s) throws  Exception;
     boolean delete(long id) throws Exception;
     Student get(long id) throws Exception;
     List<Student> get(String name) throws Exception;
     List<Student>findAll()throws Exception;
}

