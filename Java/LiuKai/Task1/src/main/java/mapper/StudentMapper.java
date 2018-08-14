package mapper;

import pojo.Student;

import java.util.List;

public interface StudentMapper {
/*
* 2018.06.20 省略所有的throws Exception 看会发生什么
*
*
* */
    //增加学生返回id
    long insertStudent(Student student);
//    boolean insertStudent(Student student) ;

    //删除学生 返回T/F
    boolean deleteStudent(long id);

    //修改记录 返回T/F
    boolean updateStudent(Student student);

    //根据id查找信息
    Student findById(long id);

    //根据姓名模糊查询
    List<Student> findLikeName(String name);

    //删除所有信息
    void deleteAll();



}
