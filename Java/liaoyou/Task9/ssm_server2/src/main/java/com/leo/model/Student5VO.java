package com.leo.model;

import java.io.Serializable;

public class Student5VO implements Serializable{
	
	private static final long serialVersionUID = 1101684592088583745L;
	private Long id;
	private String name;
	private String password;
	private Long create_at;
	private Long update_at;
	private String phone;
	private String image;
	private String email;
	private String code;
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
	}
	
	public String getCode() {
		return code;
	}
	
	public void setCode(String code) {
		this.code = code;
	}
	
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
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Student5VO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", create_at=" + create_at +
				", update_at=" + update_at +
				", phone='" + phone + '\'' +
				", image='" + image + '\'' +
				", email='" + email + '\'' +
				", code='" + code + '\'' +
				'}';
	}
}
