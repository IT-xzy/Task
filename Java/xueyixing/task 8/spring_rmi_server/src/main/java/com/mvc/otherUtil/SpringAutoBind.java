package com.mvc.otherUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class SpringAutoBind implements Converter<String, Long> {
	private static Logger logger = LoggerFactory.getLogger(SpringAutoBind.class);

	@Override
	public Long convert(String source) {
		logger.info("准备转换:" + source);
		if(!source.equals("")){
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			try {
				logger.debug("spring 注解绑定成功" + source);
				logger.info("String转为data后为:" + simpleDateFormat.parse(source));
				Long so = simpleDateFormat.parse(source).getTime()/1000;
				return so;
			}catch (ParseException e){
				e.printStackTrace();
				logger.error("当前时间格式转换失败");
			}
		}
		logger.error("当前时间为null");
		return null;
	}
}
