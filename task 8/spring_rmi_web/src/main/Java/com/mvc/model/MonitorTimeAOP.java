package com.mvc.model;

import java.util.Date;

public class MonitorTimeAOP {
	private String className;//类名
	private String methodName;//方法
	private Date logTime;//时间
	private Long comsumeTime;//计算时间

	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public String getMethodName() {
		return methodName;
	}
	public void setMethodName(String methodName) {
		this.methodName = methodName;
	}
	public Date getLogTime() {
		return logTime;
	}
	public void setLogTime(Date logTime) {
		this.logTime = logTime;
	}
	public Long getComsumeTime() {
		return comsumeTime;
	}
	public void setComsumeTime(Long comsumeTime) {
		this.comsumeTime = comsumeTime;
	}

	@Override
	public String toString(){
		return "MonitorTime{" +
				"className='" + className + '\'' +
				", methodName='" + methodName + '\'' +
				", logTime='" + logTime + '\'' +
				", comsumeTime=" + comsumeTime +
				'}';
	}
}
