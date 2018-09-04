package com.leo.model;

public class Student5VO {
	
	private Long id;
	private String name;
	private String password;
	private Long create_at;
	private Long update_at;
	
	public Long getId(){
		return id;
	}
	
	public void setId(Long id){
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Long getCreate_at() {
		return create_at;
	}
	
	public void setCreate_at(Long create_at){
		this.create_at = create_at;
	}
	
	public Long getUpdate_at() {
		return update_at;
	}
	
	public void setUpdate_at(Long update_at){
		this.update_at = update_at;
	}
}
