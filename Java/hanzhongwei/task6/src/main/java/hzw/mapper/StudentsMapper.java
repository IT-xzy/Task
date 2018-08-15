package hzw.mapper;

import hzw.model.Students;

import java.util.List;

public interface StudentsMapper {
    void addStudents(Students students);

    void deleteStudents(Long stuId);

    void updateStudents(Students students);

    Students findIdStudents(Long stuId);

    List<Students> findListStudents();

    List<Students> findNameStudents(String stuName);

    // 统计学员数
    Integer countStudent();

    // 统计工作数
    Integer countWork();
}
