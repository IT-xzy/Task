package com.jnshu.tools;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @program: smsdemo
 * @description: Spring 自定义数据转换
 * @author: Mr.xweiba
 * @create: 2018-05-30 18:00
 **/

public class SpringAutoBind implements Converter<String, Long> {
    //日志对象
    private static Logger logger = LoggerFactory.getLogger(SpringAutoBind.class);

    /* string 类型的日期格式转换为Long类型的日期格式 */
    @Override
    public Long convert(String source) {
        // logger.info("准备转换:" + source);
        if (!source.equals("")) {
            //定义数据格式
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            try {
                // logger.debug("spring 注解绑定成功" + source);
                //将字符串类型转换为Data类型,
                // 然后使用getTime()获取Long类型的微秒数
                // 最后除以1000得到秒为单位的long类型数
                // logger.info("String转为data后为:" + simpleDateFormat.parse(source));
                Long so = simpleDateFormat.parse(source).getTime();
                return so;
            } catch (ParseException e) {
                e.printStackTrace();
                logger.error("当前时间格式转换失败");
            }
        }
        logger.error("当前时间为null");
        // return new java.util.Date().getTime() / 1000;
        return null;
    }
}
