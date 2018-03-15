package com.dong.dao;

import com.dong.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

// where id = #{id}
public interface StudentDao {
   @Select("select * from student ")
   @Results(value = {
           @Result(property = "studentId",column = "student_id"),
           @Result(column="student_name",property="studentName"),
           @Result(column="student_password" ,property="studentPassword"),
           @Result(column="student_email" ,property="studentEmail")
   })
   List<Student> selectStudent();

   @Select("SELECT * FROM student WHERE student_id = #{studentId}")
   Student selectStudentByStudentId(Integer studentId);

   Student selectStudentByStudentName(String studentName);

   @Insert("INSERT into student(student_id,student_name,student_password,student_email) VALUES(#{studentId},#{studentName},#{studentPassword},#{studentEmail})")
   void insertStudent(Student student);
   @Delete("DELETE FROM student WHERE id = #{id}")
    void deleteStudentById(Integer id);
   @Update("UPDATE student SET student_id=#{studentId},student_name=#{studentName},student_password=#{studentPassword},student_email=#{studentEmail} WHERE id=#{id}")
   void updateStudent(Student student);



}
