package com.suger.service;
import com.suger.pojo.Page;
import com.suger.pojo.Student;

import java.util.List;

/**
 * @author suger
 * @date 2018/11/16 22:32
 * 学员的service
 */
public interface StudentService {


    /**
     * 新增用户信息
     * @param student 学生
     * @return id 插入记录的唯一标识
     */
    Long insertStudent(Student student);

    /**
     * 更新学生信息
     * @param student 学生
     * @return  更新结果：true-----更新成功，false------更新失败
     */
    Boolean updateStudent(Student student);

    /**
     * 删除学生信息
     * @param id  学生id
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
     * 根据姓名 模糊查询，如果条件为空，则实现查全表
     * @param name
     * @return
     */
    List<Student>  getStudentByName(String name);


    /**
     * 查询工作或者在学的学员列表  tag=1,在学，tag=0 工作
     * @param tag
     * @return
     */
    public  List<Student>  getStudentByType(Boolean tag);
}
