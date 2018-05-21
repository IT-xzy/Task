package com.mapper;

import com.util.Page;
import com.model.Student;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface StudentMapper {
    //根据id查询
    Student findStudentById(@Param("id") int id)throws Exception;

    //根据id查链接
    String fingdLinkById(@Param("id") int id)throws Exception;

    //根据name查链接
    String fingdLinkByName(@Param("name") String name)throws Exception;

    //添加信息
    void insertStuden(Student student)throws Exception;

    //删除
    void deleteStudent(@Param("id") int id)throws Exception;

    //修改
    void updateStudent(Student student)throws Exception;

    //输出list
    List<Student> list();

    //方法重载,分页List
    List<Student> list(Page page);

    //获取总的记录数
    int total();

}
