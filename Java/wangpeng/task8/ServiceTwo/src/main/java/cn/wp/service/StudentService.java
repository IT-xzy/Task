package cn.wp.service;

import cn.wp.model.Student;

import java.util.List;

/**
 * @ClassName: StudentService
 * @Description:
 * @Author: 老王
 * @Date: 2019/5/18 12:15
 * @Version: 1.0
 */
public interface StudentService {
    int deleteByPrimaryKey(Long id);

    int insert(Student record);

    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

    int updateByPrimaryKey(Student record);

    List<Student> selectAll();

    List<Student> selectBySalary(Long figure);

    int selectCount();

    int selectCountBySalary(Long income);
}
