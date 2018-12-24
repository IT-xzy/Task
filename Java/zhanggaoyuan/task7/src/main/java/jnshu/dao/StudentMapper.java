package jnshu.dao;

import jnshu.model.Student;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author user
 */
@Repository
public interface StudentMapper {


    int deleteByPrimaryKey(Long id);

    int insert(Student record);

//    int insertSelective(Student record);

    Student selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Student record);

//    int updateByPrimaryKey(Student record);

    /**
     * 查询优秀学员的信息
     *
     * @return返回优秀学员信息
     */
    List<Student> selectStudent();

    /**
     * 查询学员信息
     *
     * @return学员信息
     */
    List<Student> selectInfo();

    /**
     * 根据姓名查询学员信息
     *
     * @param name 姓名
     * @return 学员记录
     */
    List<Student> selectByName(String name);

}