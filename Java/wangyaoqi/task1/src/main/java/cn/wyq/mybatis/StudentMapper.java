package cn.wyq.mybatis;

import cn.wyq.pojo.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {
    @Insert("insert into student(name,sibling_id,sibling_name) values (#{name},#{siblingId},#{siblingName})")
    public int add(Student student);
    @Delete("delete from student where id=#{id}")
    public void delete(int id);
    @Select("select * from student where id=#{id}")
    public Student get(int id);
    @Update("update student set name=#{name} where id=#{id}")
    public int update(Student student);
    @Select("select * from student")
    public List<Student> listAll();
}
