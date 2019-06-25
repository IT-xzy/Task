package cn.wp.dao;

import cn.wp.model.Message;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MessageDao {
    int deleteByPrimaryKey(Long id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    List<Message> selectAll();

    List<Message> selectByDynamicCondition(@Param("username") String username, @Param("state") Long state);
}