package com.jnshu.task1.annotation.mapper;
import com.jnshu.task1.annotation.pojo.StudentInfo;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Delete;
import java.util.List;
public interface IStudentInfoMapper {

    @Insert({"insert into student_info(student_name,qq,learn_type,join_time,school,student_id,link,motto,brother,know_from)values (#{student_name},#{qq},#{learn_type},#{join_time},#{school},#{student_id},#{link},#{motto},#{brother},#{know_from})"})
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    int insertSTU(StudentInfo studentInfo);

    @Delete({"delete from student_info where id=#{id}"})
    void deleteByID(@Param("id") Integer EE);//@Param绑定形参和sql语句中#{id}的关系，所以形参名字叫什么不影响

    @Select({"select * from student_info"})
    List<StudentInfo> listTable();

    @Update({"update student_info set student_name=#{student_name} where id=#{id}"})
    void updateByID(StudentInfo studentInfo);

    @Select({"select * from student_info where student_name like #{name}"})
    List<StudentInfo> findByLikeName(@Param("name") String name);

    @Select({"select * from student_info where id=#{id}"})
    StudentInfo findByStudentID(@Param("id")Integer id);

}


