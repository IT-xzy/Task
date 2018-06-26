//package com.memcached;
//
//import java.util.Date;
//
//public class Test {
//    public static void main(String[] args) {
//        User user = new User();
//        user.setUserName("lucy");
//        user.setPassword("abc123");
//        MemcacheManager.getInstance().add("user", user, new Date(1000 * 60));  // 向Memcached中添加一个序列化的对象
//        user = (User) (MemcacheManager.get("user"));
//        System.out.println("用户名：" + user.getUserName() + "，密码：" + user.getPassword());
//    }
//
//}