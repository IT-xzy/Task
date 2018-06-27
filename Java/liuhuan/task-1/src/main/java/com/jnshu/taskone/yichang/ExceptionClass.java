package com.jnshu.taskone.yichang;

public class ExceptionClass
{
    public String setNumber(int number) throws MyException
    {
        if(number >= 0 && number <=100)
        {
            return "正常";
        }
        else
        {
            throw new MyException("输入错误");
        }
    }

}