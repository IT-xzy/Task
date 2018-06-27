package com.jnshu.dao;
import com.jnshu.model.Student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDao {
    int deleteById(Integer id);
    int insert(Student record);
    int insertSelective(Student record);
    Student selectById(Integer id);
    int updateByIdSelective(Student record);
    int updateById(Student record);
    List<Student> selectAll();
    int countAll();
    Student selectByName(String name);
    int upPortraitByPhone(@Param("portrait") String portrait, @Param("name") String name);
    int upPortraitByEmail(@Param("portrait") String portrait, @Param("email") String email);
    String selectPortraitByName(String name);
    String selectPortraitByPhone(String telphone);
}