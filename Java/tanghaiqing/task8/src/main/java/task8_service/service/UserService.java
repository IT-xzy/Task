package task8_service.service;

import task8_service.pojo.User;

/**
 * 登录注册业务层的接口设计
 */
public interface UserService {
    /**
     * 注册业务逻辑是，调用dao层的方法存入用户输入的数据（数据经过controller验证）
     * @param user 传入的值是经过封装的User类型
     * @return 返回值是一条字符串的信息，表述的成功或者不成功
     */
    String register(User user);

    /**
     * 登录验证逻辑是，调用dao接口的方法，传入账号，如果查询出数据，然后进行密码判断，密码正确允许返回user数据
     * 密码错误，抛出异常。如果没有查询出数据，证明账号输入错误，抛出异常
     * @param adminCode 账号是用来查询  密码是在业务层进行判断的
     * @param password 密码是在业务层进行判断的
     * @return user 成功返回user
     */
    User loginCheck(String adminCode, String password);
}
