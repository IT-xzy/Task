package com.zyq.dao;

import com.zyq.domain.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {
//    Spring与Mybatis结合注解使用此接口（不需要映射配置文件）
    @Insert("insert into student values (#{id},#{name},#{qq},#{profession},#{university},#{number}," +
            "#{daily},#{senior},#{from},#{createTime},#{updateTime})")
    @Options(useGeneratedKeys = true,keyProperty = "id",keyColumn = "ID")
    Long insert2(Student student);

    @Delete("delete from student where id = #{id}")
    boolean deleteById2(Student student);

    @Update("update student set update_time = #{updateTime} where name = #{name}")
    boolean update2(Student student);

    @Results({@Result(column = "create_time",property = "createTime"),@Result(column = "update_time",property = "updateTime")})
    @Select("select * from student where id = #{value}")
    Student selectById2(Long id);

    @Results({@Result(column = "create_time",property = "createTime"),@Result(column = "update_time",property = "updateTime")})
    @Select("select * from student where NAME =#{0} and number = #{1}")
    List<Student> selectByNameAndNum2(String name, Integer number);
}
