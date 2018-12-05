package com.listener;


import java.util.Vector;

public class UserList {

    /*Vector 类提供了实现可增长数组的功能，
    随着更多元素加入其中，数组变的更大。在删除一些元素之后，
    数组变小。它和AraayList相比，慢一些，但是是同步的，设计多线程时，使用vector会更好一些*/
//    <String>不加的话使用package打包会出现问题，但是不会影响运行。
    private static Vector<String> online = new Vector<String>();

    //添加登录人数
    public static void addUser(String userName) {
        online.addElement(userName);
    }

    //移除登录人数
    public static void removeUser(String userName) {
        online.removeElement(userName);
    }

    //获取登录人数数量
    public static int getUserCount() {
        return online.size();
    }


    public static Vector getVector() {
        return online;
    }


}
