package com;

/**
 * @author: Arike
 * @program: springMybatis2
 * @description: spring, mybatis整合
 * @create: 2018/3/14 下午3:30
 */

public interface StudentMapper {
    
    //根据id查询用户信息
    public Student findUserById(int id) throws Exception;
    //根据用户名模糊查询
//    public List<User> findUserByName(String name) throws Exception;
    //添加用户信息
//    public void insertUser(User user) throws Exception;
    //删除用户信息
//    public void deleteUser(int id) throws Exception;
    //更新用户信息
//    public void updateUser(User user) throws Exception;
}
