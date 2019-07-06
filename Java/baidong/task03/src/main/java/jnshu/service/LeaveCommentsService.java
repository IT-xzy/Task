package jnshu.service;


import jnshu.model.LeaveComments;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LeaveCommentsService {
    int deleteByPrimaryKey(Long id);

    int insert(LeaveComments record);

    int insertSelective(LeaveComments record);

    LeaveComments selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(LeaveComments record);

    int updateByPrimaryKey(LeaveComments record);

    List<LeaveComments> selectByDynamicCondition(@Param("status") Long status, @Param("works_name") String works_name);


}
