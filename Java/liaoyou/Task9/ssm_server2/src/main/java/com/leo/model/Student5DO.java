package com.leo.model;

import java.io.Serializable;

public class Student5DO implements Serializable{
	
	private static final long serialVersionUID = -3029209614380807483L;
	private Long id;
	private String name;
	private String password_hash;
	private String salt;
	private Long create_at;
	private Long update_at;
	private String image;
	private String phone;
	private String email;
	
	public String getImage() {
		return image;
	}
	
	public void setImage(String image) {
		this.image = image;
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
	
	public String getPassword_hash() {
		return password_hash;
	}
	
	public void setPassword_hash(String password_hash) {
		this.password_hash = password_hash;
	}
	
	public String getSalt(){
		return salt;
	}
	
	public void setSalt(String salt){
		this.salt = salt;
	}
	
	public Long getCreate_at() {
		return create_at;
	}
	
	public void setCreate_at(Long create_at) {
		this.create_at = create_at;
	}
	
	public Long getUpdate_at() {
		return update_at;
	}
	
	public void setUpdate_at(Long update_at) {
		this.update_at = update_at;
	}
	
	@Override
	public String toString() {
		return "Student5DO{" +
				"id=" + id +
				", name='" + name + '\'' +
				", password_hash='" + password_hash + '\'' +
				", salt='" + salt + '\'' +
				", create_at=" + create_at +
				", update_at=" + update_at +
				", image='" + image + '\'' +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
