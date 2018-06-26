package com.jnshu.taskone.yichang;

public class test extends MyException {
    public String add(int x, int y){
        ExceptionClass exceptionClass = new ExceptionClass();
        try {
            return exceptionClass.setNumber(x+y);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return "dsa";
    }
}
