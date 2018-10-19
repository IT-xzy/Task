package com.baidu.task8.pojo;

import java.io.Serializable;

public class Student implements Serializable {
	private static final long serialVersionUID = 5565713469000586992L;
	private Integer id;
	private String name;
	private Integer qq;
	private String ocupation;
	private Long admission_time;
	private String school;
	private String daily_link;
	private String flag;
	private String brother;
	private String where_know;

	@Override
	public String toString() {
		return "Student{" +
				"id=" + id +
				", name='" + name + '\'' +
				", qq=" + qq +
				", ocupation='" + ocupation + '\'' +
				", admission_time=" + admission_time +
				", school='" + school + '\'' +
				", daily_link='" + daily_link + '\'' +
				", flag='" + flag + '\'' +
				", brother='" + brother + '\'' +
				", where_know='" + where_know + '\'' +
				'}';
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQq() {
		return qq;
	}

	public void setQq(Integer qq) {
		this.qq = qq;
	}

	public String getOcupation() {
		return ocupation;
	}

	public void setOcupation(String ocupation) {
		this.ocupation = ocupation;
	}

	public Long getAdmission_time() {
		return admission_time;
	}

	public void setAdmission_time(Long admission_time) {
		this.admission_time = admission_time;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getDaily_link() {
		return daily_link;
	}

	public void setDaily_link(String daily_link) {
		this.daily_link = daily_link;
	}

	public String getFlag() {
		return flag;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public String getBrother() {
		return brother;
	}

	public void setBrother(String brother) {
		this.brother = brother;
	}

	public String getwhere_know() {
		return where_know;
	}

	public void setwhere_know(String where_know) {
		this.where_know = where_know;
	}
}
