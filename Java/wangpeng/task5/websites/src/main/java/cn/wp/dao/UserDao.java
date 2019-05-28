package cn.wp.dao;

import cn.wp.model.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 老王
 */
@Repository
public interface UserDao {

    int insert(User record);

    List<User> selectByName(String name);

    User selectByCondition(@Param("name") String name, @Param("password") String password);

    User selectById(Long id);
}
