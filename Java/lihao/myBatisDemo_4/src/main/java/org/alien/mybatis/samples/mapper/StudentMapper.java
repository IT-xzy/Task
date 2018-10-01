package org.alien.mybatis.samples.mapper;

import org.alien.mybatis.samples.model.Student;
import org.apache.ibatis.annotations.*;


/**
 * @author lihoo
 * @Title: StudentMapper
 * @ProjectName myBatisDemo_4
 * @Description: TODO
 * @date 2018/7/1214:39
 */


public interface StudentMapper {

    @Insert("INSERT INTO student (id, username, qq_num, study_type, study_time, school, study_id, daily_link, promise, teach_bro, know_us_from, create_at, update_at) VALUES (#{id},#{username},#{qq_num},#{study_type},#{study_time},#{school},#{study_id},#{daily_link},#{promise},#{teach_bro},#{know_us_from},#{create_at},#{update_at})")
    @SelectKey(statement = "SELECT max(id) + 1 FROM student", keyProperty = "id", resultType = int.class, before = true)
    int addStudent(Student student);



    @Delete("DELETE FROM student WHERE id = #{id}")
    int deleteStudent(int id);


    @Update("UPDATE student SET username = #{username}, school = #{school}, promise = #{promise}, know_us_from = #{know_us_from} WHERE id = #{id}")
    int updateStudent(Student student);

    @Select("SELECT * FROM student WHERE id = #{id}")
    Student getStudentById(int id);


    @Select("SELECT * FROM student WHERE username = #{username}")
    Student getStudentByName(String username);


}
