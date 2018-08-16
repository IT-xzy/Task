package com.ssmTest.dao;



import com.ssmTest.entity.User;

import java.util.HashMap;
import java.util.List;

public interface UserDao {
    int deleteById(Integer id);//删除一条数据
    int insertSelective (User record);//动态添加数据
    User selectById (Integer id);//查找一条数据
    User loginByUserNameAndPassword(User record);//根据姓名和密码查询数据(登录)
    int updateSelective(User record);//动态更新数据
    List<User> selectUserList();//查找所有数据
    int selectCount();//查找所有行数
    List<User> findByPage(HashMap<String,Object> map);//分页方法
}
