package com.mojorjoe.web.dao;

import com.mojorjoe.web.pojo.PageBean;
import com.mojorjoe.web.pojo.Student;

import java.util.List;

public interface StudentDAO {

    /**
     * 数据持久层，对数据库的基本操作；CURD，分页查询
     * RunTimeException不进行处理向上抛出
     */

    /**
     * 学生信息插入
     * @param student
     */
      void saveStudent(Student student);

    /**
     * 删除
     * @param id
     * @return
     */
    boolean deleteStudent(long id);

    /**
     * 查询
     * @param id
     * @return
     */
    Student selectStudent(long id);

    /**
     * 模糊查询
     * @param name
     * @return
     */
    List<Student> selectByName(String name);

    /**
     * 更新
     * @param student
     * @return
     */
    boolean updateStudent(Student student);

    /**
     * 分页查询
     * @param pageBean
     * @return
     */
    List<Student> pageListStudent (PageBean pageBean);

    /**
     * 总数统计
     * @return
     */
    long totalStudent();


}
