package jnshu.dao;

import jnshu.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    boolean insert(User User);
    boolean deleteByPrimaryKey(Long id);
    boolean updateByPrimaryKey(User User);
    User selectByPrimaryKey(Long id);
    List<Long>  selectAllIds();
    List<User> selectByIdList(List<Long> ids);
    List<User> selectAll();
}
