package com.task1.annotation.mapper;

import com.task1.annotation.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
public interface Mapper {


    @Select({"select * from student_info where id = #{id}"})
    User lookupId(@Param("id") Integer id);

    @Select({"select * from student_info where name = #{userName}"})
    User lookupName(@Param("userName") String userName);

    @Select({"select * from student_info where student_num = #{student_num}"})
    User lookupNum(@Param("student_num") String student_num);

    @Insert({"insert into student_info (name, qq, study_type, enrollment, graduate_school, student_num, daily_link, wish, check_bro) values(#{name},#{qq},#{study_type},#{enrollment},#{graduate_school},#{student_num},#{daily_link},#{wish},#{check_bro})"})
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    void insert(User user);

    @Update({"update student_info set qq=#{qq} where id=#{id}"})
    boolean update(@Param("id") Integer id, @Param("qq") String qq);

    @Delete({"delete from student_info where id =#{id}"})
    boolean delete(@Param("id")Integer id);

    @Select({"select count(*) from student_info"})
    int countAll();

    @Select({"select * from student_info order by id asc"})
    List<User> selectAll();
}
