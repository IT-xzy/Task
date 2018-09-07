package yxpTask6.dao;


import org.apache.ibatis.annotations.MapKey;
import yxpTask6.pojo.Student;

import java.util.List;
import java.util.Map;
import java.util.Vector;

public interface StudentDao
{
    int insertStudent(Student student);

    void deleteStudent(Student student);

    int updateStudent(Student student);

    Student selectStudent(Student student);

    List<Student> selectAllStudent();

    @MapKey("studyId")
    Map<String,Object> selectAllStudentMap();

    List selectAllStudyId();

    Student selectByStudyId(String studyId);
}
