package lujing.mapper;

import lujing.pojo.User;

/**
 * @author lujing
 * Create_at 2018/2/3 20:49
 */
public class UserMapperImpl implements UserMapper {
    @Override
    public int deleteByPrimaryKey(Integer id) {
        return 0;
    }
    
    @Override
    public int insert(User record) {
        return 0;
    }
    
    @Override
    public int insertSelective(User record) {
        return 0;
    }
    
    @Override
    public User selectByPrimaryKey(Integer id) {
        //
        return null;
    }
    
    @Override
    public int updateByPrimaryKeySelective(User record) {
        return 0;
    }
    
    @Override
    public int updateByPrimaryKey(User record) {
        return 0;
    }
    
    @Override
    public User findUserCustom(User user) {
        return null;
    }
    
    @Override
    public int UpdateByNameSelective(User record) {
        return 0;
    }
}
