package com.aaa.dao;
import com.aaa.dao.impl.UserDAOImpl;
//建立工厂类
public class DAOFactory {
//    通过工厂类提供的方法使的创建dao对象时，代码改动修改工厂类即可,减少代码的耦合
    public static UserDAO getUserDAOInstance() {
        return new UserDAOImpl();
    }
}
