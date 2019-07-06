package jnshu.mapper;

import jnshu.model.LeaveComments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LeaveCommentsMapper {
    int deleteByPrimaryKey(Long id);

    int insert(LeaveComments record);

    int insertSelective(LeaveComments record);

    LeaveComments selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaveComments record);

    int updateByPrimaryKey(LeaveComments record);

    List<LeaveComments> selectByDynamicCondition(@Param("status") Long status, @Param("worksName") String worksName);

}