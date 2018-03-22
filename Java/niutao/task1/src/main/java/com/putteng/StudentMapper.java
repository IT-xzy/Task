package com.putteng;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

public interface StudentMapper {
    //根据id查询
    //@Select("select * from student where id = #{id}")
    Student findStudentById(int id) throws Exception;

    //根据id查链接
    //@Select("select * from student where id = #{id}")
    String fingdLinkById(int id) throws Exception;

    //根据name查链接
    //@Select("select * from student where id = #{id}")
    String fingdLinkByName(String name) throws Exception;

    //添加信息
    //@Insert("insert into student(name,qq,classId,graduateSchool,olineNumber,link,wish,brotherId)\n" +
    //"        values(#{name},#{qq},#{classId},#{graduateSchool},#{olineNumber},#{link},#{wish},#{brotherId})")
    void insertStuden(Student student) throws Exception;

    //删除
    //@Delete("delete from student where id = #{id}")
    void deleteStudent(int id) throws Exception;

    //修改
    /*
    @Update("update student set\n" +
            "            name=#{name},\n" +
            "            qq=#{qq},\n" +
            "            graduateSchool=#{graduateSchool},\n" +
            "            olineNumber=#{olineNumber},\n" +
            "            link=#{link},\n" +
            "            wish=#{wish},\n" +
            "            brotherId=#{brotherId}\n" +
            "        where id = #{id}")
            */
    void updateStudent(Student student) throws Exception;
}
