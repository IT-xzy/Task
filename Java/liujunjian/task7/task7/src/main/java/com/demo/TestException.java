package com.demo;

import com.exception.MyException;

public class TestException {
    public void test(String aaa) throws Exception {
        if (aaa == null) {
            throw new MyException("用户名为空");
        }
        System.out.println(aaa);
    }

    public static void main(String[] args) {
        TestException testException = new TestException();
        try {
            testException.test(null);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
