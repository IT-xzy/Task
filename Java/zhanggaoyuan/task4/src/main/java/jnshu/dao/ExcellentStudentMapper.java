package jnshu.dao;

import jnshu.model.ExcellentStudent;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExcellentStudentMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ExcellentStudent record);

    int insertSelective(ExcellentStudent record);

    ExcellentStudent selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ExcellentStudent record);

    int updateByPrimaryKey(ExcellentStudent record);

//    查询优秀学员信息
    List<ExcellentStudent> selectStudent();
}