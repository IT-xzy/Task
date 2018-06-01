package com.DAO;

import com.Student.Student;
import org.apache.ibatis.annotations.*;

public interface StudentAnnotation {
    @Insert("INSERT INTO student (name,age,qq )VALUES (#{name},#{age},#{qq})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    public void insertStudent(Student student);


    @Update("UPDATE student SET name=#{name},age=#{age},qq=#{qq}  WHERE id=#{id}")
    public boolean updateStudent(Student student);

    @Delete("DELETE from student where id=#{id}")
    public boolean deleteStudent(int id);

    @Select("SELECT * FROM student WHERE id = #{id}")
    public Student findStudentById(int id);
}
