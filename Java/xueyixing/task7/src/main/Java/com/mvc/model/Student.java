package com.mvc.model;

import java.io.Serializable;

public class Student implements Serializable {

	private static final long serialVersionUID = -1291893651692616920L;
	private Integer ID;
	private String name;
	private String type;
	private Long enrolmentTime;
	private Integer studentID;
	private String wish;
	private String phone;
	private String email;
	private String photo;

	public Integer getID() {
		return ID;
	}
	public void setID(Integer ID) {
		this.ID = ID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Long getEnrolmentTime() {
		return enrolmentTime;
	}
	public void setEnrolmentTime(Long enrolmentTime) {
		this.enrolmentTime = enrolmentTime;
	}
	public Integer getStudentID() {
		return studentID;
	}
	public void setStudentID(Integer studentID) {
		this.studentID = studentID;
	}
	public String getWish() {
		return wish;
	}
	public void setWish(String wish) {
		this.wish = wish;
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
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "Student{" +
				"ID=" + ID +
				", name='" + name + '\'' +
				", type='" + type + '\'' +
				", enrolmentTime=" + enrolmentTime +
				", studentID=" + studentID +
				", wish='" + wish + '\'' +
				", phone='" + phone + '\'' +
				", email='" + email + '\'' +
				", photo='" + photo + '\'' +
				'}';
	}
}
