package service;

import model.Student;

import java.util.List;

/*
* mybatis注解操作数据库
* MybatisAnnotationAction
* Service接口
*
* */

public interface StudentAnnotationService {

    public Student selectById(int id);

    public int insertOne(Student student);

    public List<Student> findByStudent(Student student);

    public int insertList(List<Student> students);

}
