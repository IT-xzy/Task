package com.task1;


import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    //增
    @Insert(value = "insert into student_info(create_at,update_at,name,qq,curricular,school_time,college,id_num,report_link,goal,refree)values(#{create_at},#{update_at},#{name},#{qq},#{curricular},#{school_time},#{college},#{id_num},#{report_link},#{goal},#{refree})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    long add(Student student) throws SQLException;

    //删
    @Delete(value = " DELETE FROM student_info WHERE id=#{id}")
    boolean delete(long id) throws SQLException;

    //改
    @Update(value = "update student_info set id=#{id},create_at=#{create_at},update_at=#{update_at},name=#{name},qq=#{qq},curricular=#{curricular},school_time=#{school_time},college=#{college},report_link=#{report_link},goal=#{goal},refree=#{refree} where id_num=#{id_num}")
    boolean update(Student student) throws SQLException;

    //查

    //根据名字查询
    @Select(value = "select * from  student_info WHERE name =#{name}")
    List<Student> showOneN(String name) throws SQLException;

    //根据学号查询
    @Select(value = "SELECT *from student_info WHERE id_num=#{id_num}")
    Student showOneI(String id_num) throws SQLException;

    //查询全部
    @Select(value = " SELECT *from student_info")
    List<Student> showAll() throws SQLException;
}
