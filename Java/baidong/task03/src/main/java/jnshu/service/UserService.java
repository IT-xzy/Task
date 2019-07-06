package jnshu.service;

import jnshu.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserService {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> selectByDynamicCondition(@Param("name") String name, @Param("role") Long role);


}
