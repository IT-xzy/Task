package com.leo.utils;

import org.apache.taglibs.standard.lang.support.ExpressionEvaluatorManager;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
	此标签有两个作用，一是将传入的long类型时间转换为字符串类型时间；
	二是当不传入时间时，自动获取当前系统时间。
 */

public class DateTagSimple extends SimpleTagSupport{
	
	private Long value;
	
	/*
		要在标签中使用EL表达式，有如下步骤:
		1、将属性的对象类型type设为Object，rtexprvalue设为true (关于在tld设为Object类型问题，貌似关系不大，即使是long,int,甚至是默认的String都行)
		2、在set方法中执行如下evaluate方法并进行类型的转换
	 */
	public void setValue(Object value) throws JspException {
		this.value = Long.parseLong((String) ExpressionEvaluatorManager.evaluate("value",value.toString(),Object.class,(PageContext)getJspContext()));
	}
	
	@Override
	public void doTag() {
		// 实例化日期转换类并设置日期格式
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		if(value != null){
			Date date = new Date(value);
			String stringTime = simpleDateFormat.format(date);
			try {
				// 获取当前JspContext对象并将值传递给它然后输出
				getJspContext().getOut().println(stringTime);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else{
			Date date = new Date();
			String stringTime = simpleDateFormat.format(date);
			try {
				getJspContext().getOut().println(stringTime);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
