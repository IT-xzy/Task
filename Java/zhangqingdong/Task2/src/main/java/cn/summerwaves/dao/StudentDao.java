package cn.summerwaves.dao;

import cn.summerwaves.model.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by summerwaves on 2017/9/11.
 */
@Repository
public interface StudentDao {

    void insertStudent(Student student);

    @Select("SELECT * FROM student")
    List<Student> getAllStudent();

    @Select("SELECT * FROM student WHERE ID = #{id}")
    Student getStudentById(int id);

//    @Delete("DELETE FROM student WHERE ID = #{id} ")
//    void deleteStudent(int id);

    void updateStudent(Student student);

    Boolean delete(int id);



}
