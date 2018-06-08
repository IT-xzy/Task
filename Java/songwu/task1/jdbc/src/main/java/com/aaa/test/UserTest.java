package com.aaa.test;

import com.aaa.dao.DAOFactory;
import com.aaa.dao.UserDAO;
import com.aaa.model.User;

import java.util.ListIterator;

public class UserTest {
    public static void main(String[] agrs) {
//        通过调用工厂类方法来创建dao类对象
        UserDAO userDao = DAOFactory.getUserDAOInstance();


//        创建新的实体类对象
        long t1=System.currentTimeMillis();
        for(int i=0;i<2;i++){
       User use = new User();
//        调用实体类setter,为变量赋值

        use.setName("呵呵");
        use.setPassword("qfg ");
        use.setBirth("2018.5.17");
            userDao.insert(use);
//            userDao.delete(i);
        }
        long t2=System.currentTimeMillis();
        System.out.print(t2-t1);
//
////        调用dao类方法并传入参数,插入数据
//        userDao.insert(use);
//        userDao.update(use);
//        userDao.queryAll();
//        userDao.queryById(2);
//        System.out.println(use);
//
//        userDao.delete(7);


//           由于返回值时集合类型,通过迭代器,来遍历集合
//        ListIterator list = userDao.queryAll().listIterator();
//        while (list.hasNext()) {
//            System.out.println(list.next());
//        }


    }


}
