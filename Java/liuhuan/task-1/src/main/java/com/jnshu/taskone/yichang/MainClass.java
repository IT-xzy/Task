package com.jnshu.taskone.yichang;

public class MainClass
{
    public static void main (String args[])
    {
        try{
            ExceptionClass exception = new ExceptionClass();
            //设置0-100范围数字
            String s = exception.setNumber(112);
            System.out.println(s);
        }
        catch(MyException e)
        {
            System.out.println("异常信息为："+e.getMessage());
        }

        test test = new test();
        test.add(1,2);
    }
}
