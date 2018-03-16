package com.Task.one.dao;

import com.Task.one.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentDao {
    //------------------------------下面是mybatis基于注解的用法-------------------------------------------------------------
    @Insert("insert into students(Name,Sex,QQ,Graduate,Number,AutoGraph,CreateTime) " +
          "values(#{Name},#{Sex},#{QQ},#{Graduate},#{Number},#{AutoGraph},#{CreateTime});")
    void insertStudentByAnnotation(Student student);

    @Select("select * from students where Name=#{Name}")
    @Results({
          @Result(column = "Id", property = "Id"),
          @Result(column = "Name", property = "Name"),
          @Result(column = "Sex", property = "Sex"),
          @Result(column = "QQ", property = "QQ"),
          @Result(column = "Graduate", property = "Graduate"),
          @Result(column = "Number", property = "Number"),
          @Result(column = "AutoGraph", property = "AutoGraph"),
          @Result(column = "CreateTime", property = "CreateTime"),
          @Result(column = "UpdateTime", property = "UpdateTime"),
    })
    Student selectByNameByAnnotation(String userName);
    
    //通过姓名更新用户的密码
    @Update("UPDATE students SET Number = #{Number} WHERE Name = #{Name}")
    void updateStudentByNameByAnnotation(Student student);
    
    //通过姓名删除用户
    @Delete("DELETE FROM students WHERE Name = #{Name}")
    void deleteStudentByNameByAnnotation(String studentName);
    
    @Delete("DELETE FROM students WHERE Id >=#{Id}")
    void deleteStudentByIdByAnnotation(int id);

    @Select("select count(*) AS count  from students;")
    int countAllByAnnotation();

    @Select("select count(*) AS count  from students where name=#{Name};")
    int countAllByNameByAnnotation(String Name);

    @Select("select * from students where Name=#{Name}")
    @Results({
          @Result(column = "Id", property = "Id"),
          @Result(column = "Name", property = "Name"),
          @Result(column = "Sex", property = "Sex"),
          @Result(column = "QQ", property = "QQ"),
          @Result(column = "Graduate", property = "Graduate"),
          @Result(column = "Number", property = "Number"),
          @Result(column = "AutoGraph", property = "AutoGraph"),
          @Result(column = "CreateTime", property = "CreateTime"),
          @Result(column = "UpdateTime", property = "UpdateTime"),
    })
    List<Student> selectManyByNameByAnnotation(String userName);
}
