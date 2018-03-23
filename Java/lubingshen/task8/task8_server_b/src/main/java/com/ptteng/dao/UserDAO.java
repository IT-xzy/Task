package com.ptteng.dao;

import com.ptteng.pojo.model.User;

public interface UserDAO {
    //查询记录总条数
    Integer selectCount();
    //根据id查询用户信息,该权限已经被关闭
    //User findById(Long id) throws Exception;
    //根据电话号码查询
    User findByCellphone(String cellphone) throws Exception;
    //根据邮箱地址查询
    User findByMail(String mail) throws Exception;
    //根据姓名模糊查询
    User findByName(String name) throws Exception;
    //添加用户信息
    boolean insertUser(User user) throws Exception;
    //更新用户信息
    boolean modifyLoginTime(User user) throws Exception;
    //更新用户信息
    boolean addStudentId(User user) throws Exception;


    //通过用户名称获取关联的学员信息
    /* 这里写一下为什么要分表的一些思考心得
    * 首先，分表的作用作用主要有四点（个人思考，可能有误）：
    * 1.减少数据库中表的宽度，提高查询效率
    * 2.当项目做大的时候，不同模块需要分开，好几台机器在跑，需要解耦（RMI）
    * 3.对开发/运营者的一个权限控制，因为底层的dao可以设置为只读的，比如我这里设置只能通过用户的名称才能修改学员信息
    * 4.（未实现）对数据库的管理者甚至都可以做一个权限控制，可以在Spring中配置多个数据源，从而将表存放在不同的数据库（甚至是不同机器）中
    * 关于第四点，可以参考：https://www.cnblogs.com/yougewe/p/7062998.html */
    User findStudentByName(String userName) throws Exception;
}
