package task6_redis.dao;

import task6_redis.pojo.User;

/**
 * 注册和登录业务dao层接口设计
 */
public interface UserDao {
     /**
      * 注册数据保存数据库方法，注意密码是在业务层经过md5加盐处理的
      * @param user 传入的参数，要经过controller验证（使用的validatio框架验证）
      * @return Integer 插入成功返回大于0的数值，失败返回小于0
      */
     Integer saveUser(User user);

     /**
      * 登录数据查询方法
      * @param adminCode 传入的参数是账号，根据账号查询对应的信息
      * @return User 返回值是User类型
      */
     User queryUser(String adminCode);

}
