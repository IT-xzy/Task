package com.student.DAO;

import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentInterfaceMapper {
    public List<Student> selectAllStudent();
    public void insertOneStudent(Student student);
    public boolean deleteOneStudentForId(int id);
    public boolean updateOneStudentForId(Student student);

    //mybatis的注解方式
    @Insert("INSERT INTO student(name,create_at,update_at) VALUES(#{name},#{update_at},#{update_at})")
    public int insertStudent(Student student);
    @Options(useGeneratedKeys = true, keyProperty = "id",keyColumn = "id")
    public long insertInt(Student student);

    @Update("UPDATE student SET name=#{name}, create_at=#{create_at},update_at=#{update_at} WHERE id=#{id}")
    public boolean updateStudent(Student student);

    @Delete("DELETE from student where id=#{id}")
    public boolean deleteStudent(int id);

    @Select("select name,id,create_at,update_at from student where id=#{id}")
    public Student findStudentById(int id);

}