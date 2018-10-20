package com.jnshu.mapper;

import com.jnshu.entity.Student;



import java.util.List;

public interface StudentMapper {
    //查询所有
      List<Student> findAll();

    //根据id查询一条记录
     Student findOneById(Long id);

    //根据主键删除
    boolean deleteById(long id);

    //查询记录数
    long findTotal();

   //插入
    boolean insert(Student student);

  //根据主键更新非空字段
    boolean updateSelective(Student student);
}
