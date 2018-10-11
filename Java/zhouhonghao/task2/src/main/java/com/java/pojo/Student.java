package com.java.pojo;

public class Student {
private int id;
private String name;
private String  address;
private long phone;
private long create_up;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
@Override
public String toString() {
	return "student[id="+id+",name="+name+",address="+address+",phone="+phone+"]";
}
public long getCreate_up() {
	return create_up;
}
public void setCreate_up(long create_up) {
	this.create_up = create_up;
}
}
