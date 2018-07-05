package dao;

import org.springframework.stereotype.Repository;
import model.Student;
@Repository
public interface StudentMapper {
    void insertStudent(Student student);//插入学员
    void deleteById(Integer id);//id删除
    Integer getLearningStudentCount();//查询累计在学学生数
    Integer getGraduatedStudentCount();//查询已经工作学生数
    Student getExcellentStudent(Integer studentNum);//查询优秀学生
    Integer getCareerTypeCount(String career);//查询职业人数
    void updateStudent(Student student);//修改学员
}
