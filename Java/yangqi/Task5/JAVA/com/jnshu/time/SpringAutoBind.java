package com.jnshu.time;

import org.springframework.core.convert.converter.Converter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SpringAutoBind implements Converter<String,Long> {


    private static Logger logger = LoggerFactory.getLogger(SpringAutoBind.class);
    /* string 类型的日期格式转换为Long类型的日期格式 */
    @Override
    public Long convert(String source) {
        //定义数据格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            System.out.println("spring 注解绑定成功" + source);
            //将字符串类型转换为Data类型,
            // 然后使用getTime()获取Long类型的微秒数
            // 最后除以1000得到秒为单位的long类型数
            Long so = simpleDateFormat.parse(source).getTime() / 1000;
            // System.out.println(simpleDateFormat.parse(source));
            return so;
        } catch (ParseException e) {
            e.printStackTrace();
            System.out.println("查询条件为空时返回所有商品信息");
        }
        //如果绑定失败返回null
        // System.out.println("null 空");
        return null;
    }

}
