package mapper;

import model.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AnnotionStudentMapper {
    @Insert("insert into student (id,name,qq,wish,create_at) values(#{id} , #{name} , #{qq} , #{wish},#{create_at})")
    void insert(Student student);
    @Delete("delete from student where id=#{id}")
    void delete(Long id);
    @Update(" update student set wish=#{wish} where Id=#{id}")
    void update(Student student) ;
    @Select("select * from student where id=#{id}")
    Student select(Long id);
    @Select("select * from student")
    List<Student> getAll() ;
}
