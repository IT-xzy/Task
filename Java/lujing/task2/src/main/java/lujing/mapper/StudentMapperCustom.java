package lujing.mapper;

import java.util.List;

import lujing.pojo.Student;
import lujing.pojo.StudentCustom;
import lujing.pojo.StudentQueryVo;

public interface StudentMapperCustom {
    /**
     * 自定义查询条件
     */
    List<StudentCustom> findStudentList(StudentQueryVo studentQueryVo);
    
    List<Student> findUserByName(String name);
}