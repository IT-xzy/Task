package com.jin.dao;

import com.jin.pojo.Student;

import java.util.List;

/**
 * @ProjectName: task2
 * @Package: com.jin.dao
 * @ClassName: CustomerServiceDao
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/9 14:47
 * @UpdateUser:
 * @UpdateDate: 2018/5/9 14:47
 * @UpdateRemark:
 * @Version: 1.0
 */
public interface StudentServiceDao {
    List<Student> insertAndSelectAll(Student student);
    List<Student> query();
    List<Student> selectByNumberOrString(Object o);
    Boolean insertStudents(int i);
//    String update(List<Student> students);
    void updateKnowFromById(String address, int...id);
    Boolean deleteByNumber(Object...numbers);
    void updateStudent(Student student);
    Student getStudentById(int id);
    void deleteStudent(int id);
    void insertStudent(Student student);
    List<Student> selectStu(Student student);
    List<Student> selectByLimit(Student student);
}
