package com.suger.dao;

import com.suger.pojo.Page;
import com.suger.pojo.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * created by suger on 2018/10/12
 * 持久层接口, 结合Mapper.xml,使用扫描包的方式
 * CRUD,主要加入查总记录数，配合分页查询，
 * 根据id查询，配合修改
 */
@Repository
public interface StudentDao {

    // 添加学生信息，返回ID
    Long addStudent(Student student);
    // 更新学生信息，返回受影响的行数，1---更新成功，0---更新失败
    int updateStudent(Student student);
    // 删除学生信息，返回受影响的行数，1---删除成功，0---删除失败
    int deleteStudent(Long id);
    // 2个查全表
    // 使用mybatis的动态语句,有参，使用:limit ; 无参的话，直接查全表
    // 前台已经做好分页显示
    // 分页·查询
    List<Student> findAll(Page page);
    // 直接查全表
    List<Student> findAll();
    // 查总记录数
    int total();
    //根据id查询，返回学生信息，若结果为null,代表id对应记录不存在
    Student getStudentById(Long id);
    // 根据姓名查询，使用模糊查询，返回对应的数组，其中元素为学生信息
    List<Student> getStudentByName(String name);
}
