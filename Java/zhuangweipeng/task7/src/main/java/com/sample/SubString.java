package com.sample;

public class SubString {

        public static void main(String[] args) {
            String str ="http://aliyunuploadphoto.oss-cn-shenzhen.aliyuncs.com/1.jpg";
            //获得第一个点的位置
            //int index=str.indexOf("/");
            //System.out.println(index);
            ////根据第一个点的位置 获得第二个点的位置
            //index=str.indexOf("/", index+3);
            ////根据第二个点的位置，截取 字符串。得到结果 result
            //String result=str.substring(index);
            ////输出结果
            //System.out.println(result);
          String i=  str.substring(str.lastIndexOf("/")+1);
            System.out.println(i);
        } }
