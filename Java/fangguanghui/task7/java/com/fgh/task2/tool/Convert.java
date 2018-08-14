package com.fgh.task2.tool;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Convert implements Converter<String,Long> {
    Logger logger=LoggerFactory.getLogger(Convert.class);

    @Override
    public Long convert(String s) {
        logger.error("进入日期转换");
//        实现 将日期串转成日期类型(格式是yyyy-MM-dd HH:mm:ss)
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            //转成直接返回,
            // format方法：将日期类型（Date）数据格式化为字符串（String）
            // parse方法：将字符串类型（java.lang.String）解析为日期类型（java.util.Date）
            System.out.println("time：" + s);
            System.out.println("test:" + simpleDateFormat.parse(s));
            long slff=simpleDateFormat.parse(s).getTime()/1000;
            System.out.println("long:" + slff);
            return slff;
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //如果参数绑定失败返回null
        return null;

}
}
