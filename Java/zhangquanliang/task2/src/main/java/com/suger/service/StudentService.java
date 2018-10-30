package com.suger.service;

import com.suger.pojo.Page;
import com.suger.pojo.Student;

import java.util.List;

/**
 * service接口，目前只是简单的调用dao接口
 * @author suger
 * @date 2018-10-02
 */
public interface StudentService {

    /**
     * 新增学生信息
     * @param student 学生信息
     * @return id 插入记录的唯一标识
     */
    Long addStudent(Student student);

    /**
     * 更新学生信息
     * @param student
     * @return  更新结果：true-----更新成功，false------更新失败
     */
    Boolean updateStudent(Student student);

    /**
     * 删除学生信息
     * @param id 学生id
     * @return  删除结果：true-----删除成功，false------更新失败
     */
    Boolean deleteStudent(Long id);

    /**
     * 分页查询
     * @param page 分页工具类
     * @return
     */
    List<Student> findAll(Page page);

    /**
     * 查询所有
     * @return
     */
    List<Student> findAll();

    /**
     * 查询记录总数
     * @return  记录总数
     */
    int total();

    /**
     * 根据id查询
     * @param id
     * @return 具体的学生信息
     */
    Student getStudentById(Long id);

    /**
     * 根据姓名模糊查询
     * @param name
     * @return 数组的形式的学生信息
     */
    List<Student> getStudentByName(String name);


}
