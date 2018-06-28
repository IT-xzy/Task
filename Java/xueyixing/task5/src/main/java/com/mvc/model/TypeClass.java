package com.mvc.model;

import java.io.Serializable;

public class TypeClass implements Serializable {

	private static final long serialVersionUID = -5193616315597452828L;

	private int ID;
	private String type;
	private String introduce;
	private String company;
	private String direction;

	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}

	@Override
	public String toString() {
		return "TypeClass{" +
				"ID=" + ID +
				", type='" + type + '\'' +
				", introduce='" + introduce + '\'' +
				", company='" + company + '\'' +
				", direction='" + direction + '\'' +
				'}';
	}
}
