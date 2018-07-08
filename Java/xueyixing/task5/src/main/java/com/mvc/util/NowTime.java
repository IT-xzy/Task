package com.mvc.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class NowTime {
	public static String nowTime() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		return df.format(new Date());
	}

	public static void main(String[] args){
		SpringAutoBind sp = new SpringAutoBind();
		System.out.println(sp.convert(NowTime.nowTime()));
	}
}
