package com.service;


import java.io.*;

public class UrlTest {

    public static void main(String[] args) throws IOException {
        File f = new File(UrlTest.class.getClassLoader().getResource("../../files/hehe.txt").getPath());
        //System.out.println(UrlTest.class.getClassLoader().getResource("").getPath());
        //File f = new File("../../../../files/hehe.txt");
         //创建基于文件的Reader
        FileReader fr = null;
        try {
            fr = new FileReader(f);
            // 创建字符数组，其长度就是文件的长度
            char[] all = new char[(int) f.length()];
            // 以字符流的形式读取文件所有内容
            fr.read(all);
            for (char b : all) {
                // 打印出来是A B
                System.out.println(b);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            fr.close();
        }
    }
    }
