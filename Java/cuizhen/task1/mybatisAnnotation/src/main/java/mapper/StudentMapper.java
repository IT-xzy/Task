package mapper;

import org.apache.ibatis.annotations.*;
import pojo.Student;

import java.util.List;

public interface StudentMapper {
    @Insert("insert into student1 (name,qq,type ,time ,graduate_institutions,daily_link,volunteer, create_at,update_at) values (#{name},#{qq},#{type} ,#{time} ,#{graduateInstitutions},#{dailyLink},#{volunteer},#{createAt},#{updateAt})")
    @Options(useGeneratedKeys = true ,keyProperty = "id" ,keyColumn = "id")
    void insertStudent(Student student);

    @Update("update student1 set name = #{name},qq = #{qq},type = #{type} ,time = #{time} ,graduate_institutions = #{graduateInstitutions},daily_link = #{dailyLink},volunteer = #{volunteer},create_at = #{createAt},update_at = #{updateAt} where id=#{id}")
    int updateStudent(Student student);

    @Delete("delete from student1 where id=#{id}")
    int deleteStudent(int id);

    @Select("select *from  student1 where id=#{id}")
    Student selectStudent(int id);

    @Select("select *from  student1 where name=#{name}")
    List<Student> selectStudentName(String name);

    @Select("select *from  student1")
    List<Student> findAllStudent();

}
