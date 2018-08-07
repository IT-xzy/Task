package com.encryption;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

public class Token {
    //全局常量：
    private static final String TOKEN_LIST_NAME = "tokenList";
    //全局常量：
    public static final String TOKEN_STRING_NAME = "token";

    //保证session中有name:"tokenList"的数据数组：数据可能是null的
    //私有的静态 数组返回值 获得TokenList （形参是session）
    private static ArrayList getTokenList(HttpSession session) {
        //从session获得名字为"tokenList"的对象，保存到Object对象中
        Object obj = session.getAttribute(TOKEN_LIST_NAME);
        //如果存在name为"tokenList"的数据
        if (obj != null) {
            //返回这个对象的数组
            return (ArrayList) obj;
        } else {
            //如果不存在，就创建一个数组对象tokenList
            ArrayList tokenList = new ArrayList();
            //将数组对象tokenList以name为"tokenList"保存到Session中
            session.setAttribute(TOKEN_LIST_NAME, tokenList);
            //并将这个数组对象tokenList作为方法的返回值
            return tokenList;
        }
    }

    //在Session中的数据数组中添加一个新的字符串（tokenstr）
    //私有 静态 无返回值 保存Token字符串（形参是：字符串（tokenstr）,Session）
    private static void saveTokenString(String tokenStr, HttpSession session) {
        //调用自己的获得有name:"tokenList"的数据数组，使用一个数值指向这个数据
        ArrayList tokenList = getTokenList(session);
        //在这个数据数组中添加作为形参的字符串（tokenstr）
        tokenList.add(tokenStr);
        //将这个新的数据数组保存到以"tokenList"的name保存到Session中
        //最后这一步是多此一举的代码，不需要重新设置值。因为改动的指向Session的数组值的数组变量名，就已经改动了
        //session.setAttribute(TOKEN_LIST_NAME, tokenList);
    }

    //根据当前时间戳获得一个字符串
    //私有的 静态的 返回值String 生成字符串 无参
    private static String generateTokenString(long id){
        //把调用Long类的构造方法（传入当前时间戳作为参数），
        // 并通过toString方法将long型数据转为String类型作为返回值
        return new Long(System.currentTimeMillis()).toString()+ new Long(id).toString();
    }

    //供外界调用的，根据当时时间创建一个字符串，并保存到Session的"tokenList"中
    //共有的 静态的 返回值：字符串 获得Token字符串 （参数是：Session）
    public static String getTokenString(HttpSession session,long id) {
        //调用根据当前时间戳获得一个字符串的方法 保存到String类型的tokenStr中
        String tokenStr = generateTokenString(id);
        //调用在Session中的数据数组中添加一个新的字符串的方法，将新的字符串保存到"tokenList"中
        saveTokenString(tokenStr, session);
        //返回值是时间戳字符串
        return tokenStr;
    }

    //共有 静态 返回值为布尔类型 判断TokenStringValid是否有效 （参数：字符串（tokenstr）,Session）
    public static boolean isTokenStringValid(String tokenStr, HttpSession session) {
        //数组布尔类型的变量 valid 默认为false
        boolean valid = false;
        //如果session中的数据不为空
        if(session != null){
            //数组一个数值变量指向——> Session中name为："tokenList"的数组
            ArrayList tokenList = getTokenList(session);
            //如果数组中包含 （参数：字符串（toKenStr）的话返回true）
            if (tokenList.contains(tokenStr)) {
                //如果存在，将valid设置为true
                valid = true;
                //并将这个字符串从数组中移除(相当于直接从Session中移除掉这个字符串)
                //如果需要实现登录后，只允许访问一下的效果可以添加
                //tokenList.remove(tokenStr);
            }
        }
        //返回这个结果
        return valid;
    }

    //自定义注销逻辑
    public static void cancellation(HttpSession session){
        //调用Token工具类的获得指定session的"tokenList"的字符串集合
        ArrayList tokenList=getTokenList(session);
        //tokenList指向指定session的"tokenList"的字符串集合，清空集合内所有元素
        tokenList.clear();
    }
}
