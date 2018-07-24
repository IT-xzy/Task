package com.leo.pojo;

public class Student {
	private Long id;
	private String name;
	private Integer qq;
	private String profession;
	private String school;
	private Long create_time;
	private Long update_time;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getQq() {
		return qq;
	}
	
	public void setQq(int qq) {
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
	
	public long getCreate_time() {
		return create_time;
	}
	
	public void setCreate_time(long create_time) {
		this.create_time = create_time;
	}
	
	public long getUpdate_time() {
		return update_time;
	}
	
	public void setUpdate_time(long update_time) {
		this.update_time = update_time;
	}
	
	@Override
	public String toString(){
		return "Student [id="+id+", name="+name+", qq="+qq+", profession="+profession+", school="+school+", create_time="+create_time+", update_time="+update_time+"]";
	}
}
