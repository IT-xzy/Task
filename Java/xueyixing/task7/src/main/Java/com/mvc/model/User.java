package com.mvc.model;

import java.io.Serializable;

public class User implements Serializable {

	private static final long serialVersionUID = 8011876285150703237L;
	private String userName;
	private String password;
	private String phone;
	private String photo;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}
}
