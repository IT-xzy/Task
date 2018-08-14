package com.leo.pojo;

public class Student {
	private Long id;
	private String name;
	private Integer qq;
	private String profession;
	private String school;
	private Long create_time;
	private Long update_time;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
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
	
	public String getProfession() {
		return profession;
	}
	
	public void setProfession(String profession) {
		this.profession = profession;
	}
	
	public String getSchool() {
		return school;
	}
	
	public void setSchool(String school) {
		this.school = school;
	}
	
	public Long getCreate_time() {
		return create_time;
	}
	
	public void setCreate_time(Long create_time) {
		this.create_time = create_time;
	}
	
	public Long getUpdate_time() {
		return update_time;
	}
	
	public void setUpdate_time(Long update_time) {
		this.update_time = update_time;
	}
	
	@Override
	public String toString(){
		return "Student [id="+id+",name="+name+",qq="+qq+",profession="+profession+",school="+school+",create_time="+create_time+",update_tme="+update_time+"]";
	}
}
