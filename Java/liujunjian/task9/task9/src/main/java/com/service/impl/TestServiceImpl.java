package com.service.impl;

import com.service.TestService;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestServiceImpl implements TestService {
    @Override
    public double average(double a, double b) {
        return (a + b) / 2;
    }

    @Override
    public String read() {
        try {
            FileInputStream inputStream = new FileInputStream("my.text");
            byte[] byt = new byte[1024];
            int len = inputStream.read(byt);
            return new String(byt, 0, len);
        } catch (FileNotFoundException e) {
            System.out.println("没有找到文件");
            return null;
        } catch (IOException e) {
            System.out.println("读取文件内容失败");
            return null;
        }
    }
}
