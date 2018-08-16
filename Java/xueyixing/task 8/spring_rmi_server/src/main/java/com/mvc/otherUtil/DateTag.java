package com.mvc.otherUtil;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTag extends TagSupport {

	private static final long serialVersionUID = 6464168398214506236L;

	private String value;

	@Override
	public int doStartTag() throws JspException {
		String vv ="" + value;
		try{
			long time = Long.valueOf(vv.trim());
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			java.util.Date jut = new Date(time*1000);
			String s = dateFormat.format(jut);
			pageContext.getOut().write(s);
		}catch (Exception e){
			e.printStackTrace();
		}
		return super.doStartTag();
	}
	public void setValue(String value) {
		this.value = value;
	}
}
