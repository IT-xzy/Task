package com.restful.dao;

import com.restful.pojo.Student;

import java.util.List;

/**
 * @ProjectName: task2Restful
 * @Package: com.restful.dao
 * @ClassName: IStudentDao
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/17 14:21
 * @UpdateUser:
 * @UpdateDate: 2018/5/17 14:21
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
    List<Student> getStudentByPage(int startRow, int pageSize);
}
