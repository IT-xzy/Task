package com.mvc.model;

public class Team {
	private Student student;
	private User user;
	private TypeClass typeClass;

	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public TypeClass getTypeClass() {
		return typeClass;
	}
	public void setTypeClass(TypeClass typeClass) {
		this.typeClass = typeClass;
	}

	@Override
	public String toString() {
		return "Team{" +
				"student=" + student +
				", user=" + user +
				", typeClass=" + typeClass +
				'}';
	}
}
