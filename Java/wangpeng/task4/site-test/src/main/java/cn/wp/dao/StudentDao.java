package cn.wp.dao;

import cn.wp.model.Student;

import java.util.List;

public interface StudentDao {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectAll();

    List<Student> selectBySalary();

    int selectCount();

    int selectCountBySalary();
}