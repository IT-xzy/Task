package com.jnshu.ssm.tools;


import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public  class Convert implements Converter<String,Long> {

    @Override
    public Long convert(String s) {
//        实现 将日期串转成日期类型(格式是yyyy-MM-dd HH:mm:ss)
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if (!s.isEmpty()){
        try {
            //转成直接返回,
            // format方法：将日期类型（Date）数据格式化为字符串（String）
            // parse方法：将字符串类型（java.lang.String）解析为日期类型（java.util.Date）
            System.out.println("time:" + s);
            try {
                System.out.println("test:" + simpleDateFormat.parse(s));
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Long slff = simpleDateFormat.parse(s).getTime();
            System.out.println("long:" + slff);
            return slff;
        } catch (ParseException e) {
            e.printStackTrace();
        }}

        return null;
    }

}