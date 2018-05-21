package com.mojorjoe.web.service;

import com.mojorjoe.web.pojo.PageBean;
import com.mojorjoe.web.pojo.Student;


import java.util.List;


public interface StudentService {

    /**
     * 业务逻辑层
     * 分页查询，totalPage注入，list<student>注入
     * 对于数据库的主键重复异常重抛
     */

    /**
     *增加
     * @param student
     * @return
     * @throws Exception
     */
    long saveStudent(Student student)throws Exception;

    /**
     * 删除
     * @param id
     * @return
     * @throws Exception
     */
    boolean deleteStudent(long id)throws Exception;

    /**
     * 查询
     * @param id
     * @return
     * @throws Exception
     */
    Student selectStudent(long id)throws Exception;

    /**
     * 模糊查询
     * @param name
     * @return
     * @throws Exception
     */
    List<Student> selectByName(String name)throws Exception;

    /**
     * 更新
     * @param student
     * @return
     * @throws Exception
     */
    boolean updateStudent(Student student)throws Exception;

    /**
     * 分页查询
     * @param pageNum
     * @return
     * @throws Exception
     */
   PageBean pageListStudent (long pageNum,int pageSize)throws Exception;

}
