package jnshu.service.Impl;

import jnshu.mapper.LeaveCommentsMapper;
import jnshu.model.LeaveComments;
import jnshu.service.LeaveCommentsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeaveCommentsServiceImpl implements LeaveCommentsService {
    @Autowired
    LeaveCommentsMapper leaveCommentsMapper;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return leaveCommentsMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(LeaveComments record) {
        return leaveCommentsMapper.insert(record);
    }

    @Override
    public int insertSelective(LeaveComments record) {
        return leaveCommentsMapper.insertSelective(record);
    }

    @Override
    public LeaveComments selectByPrimaryKey(Long id) {
        return leaveCommentsMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(LeaveComments record) {
        return leaveCommentsMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(LeaveComments record) {
        return leaveCommentsMapper.updateByPrimaryKey(record);
    }

    @Override
    public  List<LeaveComments> selectByDynamicCondition(@Param("status") Long status, @Param("worksName") String worksName){
        return leaveCommentsMapper.selectByDynamicCondition(status,worksName);
    }

}
