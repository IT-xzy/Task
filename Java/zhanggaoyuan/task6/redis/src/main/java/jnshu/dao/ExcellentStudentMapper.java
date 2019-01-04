package jnshu.dao;

import jnshu.model.ExcellentStudent;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author user
 */
@Repository
public interface ExcellentStudentMapper {


    int deleteByPrimaryKey(Long id);

    int insert(ExcellentStudent record);

//    int insertSelective(ExcellentStudent record);

    ExcellentStudent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ExcellentStudent record);

//    int updateByPrimaryKey(ExcellentStudent record);

    /**
     * 查询优秀学员的信息
     * @return返回优秀学员信息
     */
    List<ExcellentStudent> selectStudent();

    /**
     * 查询学员信息
     * @return学员信息
     */
    List<ExcellentStudent> selectInfo();

    /**
     * 根据姓名查询学员信息
     * @param name 姓名
     * @return 学员记录
     */
   List<ExcellentStudent>  selectByName(String name);

}