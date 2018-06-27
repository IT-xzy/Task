package com.restful.dao;

import com.restful.pojo.Student;

import java.util.List;

/**
 * @ProjectName: task2Restful
 * @Package: com.restful.dao
 * @ClassName: StudentServiceDao
 * @Description:
 * @Author: Jin
 * @CreateDate: 2018/5/17 14:32
 * @UpdateUser:
 * @UpdateDate: 2018/5/17 14:32
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
}
