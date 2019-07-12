package com.dao;

import com.pojo.Student;

import java.util.List;

/**
 * @author JDBC的Dao接口
 */

public interface StudentDao {
    /**
     * @param stu
     * @return
     * 增加的接口
     */
    public Student addStudent(Student stu)throws Exception;

    /**
     * 删除的接口
     * @param id
     * @return
     *
     */
    public boolean deleteStudent(Long id)throws Exception;

    /**
     * 更新
     * @param stu
     * @return
     */
    public boolean updateStudent(Student stu)throws Exception;

    /**
     * 查询全表
     * @return
     */
    public List<Student> getAllStudents()throws Exception;

    /**
     * 通过ID查询
     * @param id
     * @return
     */
    public Student getStudentById(Long id)throws Exception;

    /**
     * 通过Name查询
     * @param name
     * @return
     */
    public Student getStudentByNameAndNumber(String name,int number)throws Exception;

    /**
     * 通过Number查询
     * @param number
     * @return
     */
    public Student getStudentByNumber(int number)throws Exception;

    /**
     * 模糊查询
     * @param name
     * @return
     */
    public List<Student> getStudentsByCondition(String name)throws Exception;

    /**
     * 百万插入
     * @param stu
     */
    public void million(Student stu)throws Exception;
}
