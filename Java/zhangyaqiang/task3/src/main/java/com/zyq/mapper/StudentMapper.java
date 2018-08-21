package com.zyq.mapper;

import com.zyq.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {
    @Insert("insert into student values (#{id},#{name},#{qq},#{profession},#{university},#{number}," +
            "#{daily},#{senior},#{from},#{createTime},#{updateTime})")
    @Options(useGeneratedKeys = true,keyColumn = "ID")
    void insert(Student student);

    @Delete("delete from student where id = #{id}")
    Integer deleteById(Student student);

    @Select("Select count(1) from student")
    Integer selectTotalNum();

    @Results({@Result(column = "create_time",property = "createTime"),@Result(column = "update_time",property = "updateTime")})
    @Select("select * from student limit #{0},#{1}")
    List<Student> selectStudentsByPage(Integer startNum, Integer pageSize);

    @Results({@Result(column = "create_time",property = "createTime"),@Result(column = "update_time",property = "updateTime")})
    @Select("select * from student where id = #{value}")
    Student selectById(Long id);

    @Results({@Result(column = "create_time",property = "createTime"),@Result(column = "update_time",property = "updateTime")})
    @Update({"update student set name = #{name},qq = #{qq},profession = #{profession},university = #{university}," +
            "number = #{number},daily = #{daily},senior = #{senior},`from` = #{from},update_time = #{updateTime} where id = #{id}"})
    void updateById(Student student);

    @Results({@Result(column = "create_time",property = "createTime"),@Result(column = "update_time",property = "updateTime")})
    @Select("select * from student where name like CONCAT(CONCAT('%',#{0}),'%') and number like CONCAT(CONCAT('%',#{1}),'%') limit #{2},#{3}")
    List<Student> selectStudentsByNameAndNum(String name, Integer number,Integer startNum, Integer pageSize);

    @Select("select count(1) from student where name like CONCAT(CONCAT('%',#{0}),'%') and number like CONCAT(CONCAT('%',#{1}),'%')")
    Integer selectTotalNumByNameAndNum(String name,Integer number);

    @Results({@Result(column = "create_time",property = "createTime"),@Result(column = "update_time",property = "updateTime")})
    @Select("select * from student where number like CONCAT(CONCAT('%',#{0}),'%') limit #{1},#{2}")
    List<Student> selectStudentsByNum(Integer number,Integer startNum, Integer pageSize);

    @Select("select count(1) from student where number like CONCAT(CONCAT('%',#{0}),'%')")
    Integer selectTotalNumByNum(Integer number);

    @Results({@Result(column = "create_time",property = "createTime"),@Result(column = "update_time",property = "updateTime")})
    @Select("select * from student where name like CONCAT(CONCAT('%',#{0}),'%') limit #{1},#{2}")
    List<Student> selectStudentsByName(String name,Integer startNum, Integer pageSize);

    @Select("select count(1) from student where name like CONCAT(CONCAT('%',#{0}),'%')")
    Integer selectTotalNumByName(String name);


}
