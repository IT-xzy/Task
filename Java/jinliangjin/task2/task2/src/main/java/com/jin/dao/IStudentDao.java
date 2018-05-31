package com.jin.dao;

import com.jin.pojo.Student;

import java.util.List;

/**
 * @ProjectName: task2
 * @Package: com.jin.dao
 * @ClassName: IStudentDao
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/9 14:34
 * @UpdateUser:
 * @UpdateDate: 2018/5/9 14:34
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface IStudentDao {
    List<Student> getAll();
    void addStudent(Student student);
    void addStudentList(List<Student> students);
    Student getOneById(int id);
    List<Student> getOneByKey(String key);
    Student getOneByQq(Long qq);
    void updateOne(Student student);
//    void updateCustomers(List<Student> students);
    void deleteById(Integer...ids);
    void deleteByQq(Long...qq);
    List<Student> select(Student student);
    List<Student> selectBySomething(Student student);
    Integer selectTotalCount();
    List<String> queryLimit();
}
