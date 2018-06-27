package com.fangyuyang.subsidiary.validateCode;

import org.junit.Test;

import javax.activation.MimetypesFileTypeMap;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class ValidateCodeTest {

    @Test
    public void getValidateCodeImage() throws IOException {
        ValidateCode validateCode = new ValidateCode();
        Image image = validateCode.getValidateCodeImage(4);
        String pic = validateCode.getValidateCode();
        System.out.println("新建图片： "+pic);
        File files = new File("E:/JAVA_TEST/task7_test2/src/main/webapp/pic/");    //创建File对象,指向F盘根目录
        String[] names = files.list();    //获取F盘根目录所有文件和路径,并以字符串数组返回
        for(String s:names) {    //遍历字符串数组
            if(s.equals(pic+".jpeg")) System.out.println(pic+".jpeg");
            System.out.println("图片 ： "+s);
            boolean a = s.endsWith(".jpeg");    //文件名前缀带有ja的返回true,没有则返回false
            boolean b = (new File(files.getAbsolutePath() + s)).isFile();    //判断本次循环的字符串所指向的内容是否是文件,是则返回true.否则返回false

           // boolean c = s.contains(pic);    //文件名是否包含"va",包含则返回true,否则false
            if (a && b) {    //此处条件根据需要进行修改
                System.out.println(s);    //打印出符合条件的文件
            }
        }

    }
}