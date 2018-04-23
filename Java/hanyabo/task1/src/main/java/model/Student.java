package model;

import java.util.Date;

public class Student {
	private Long id;
	private Long create_at;
	private Long update_at;
	private String name;
	private String qq;
	private String profession;
	private Date join_date;
	private String school;
	private String online_id;
	private String daily_url;
	private String declaration;
	private String introducer;
	private String referee;
	private String counselor;
	private String description;
	private String city;
	private String review;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getProfession() {
		return profession;
	}

	public void setProfession(String profession) {
		this.profession = profession;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getOnline_id() {
		return online_id;
	}

	public void setOnline_id(String online_id) {
		this.online_id = online_id;
	}

	public String getDaily_url() {
		return daily_url;
	}

	public void setDaily_url(String daily_url) {
		this.daily_url = daily_url;
	}

	public String getDeclaration() {
		return declaration;
	}

	public void setDeclaration(String declaration) {
		this.declaration = declaration;
	}

	public String getIntroducer() {
		return introducer;
	}

	public void setIntroducer(String introducer) {
		this.introducer = introducer;
	}

	public String getReferee() {
		return referee;
	}

	public void setReferee(String referee) {
		this.referee = referee;
	}

	public String getCounselor() {
		return counselor;
	}

	public void setCounselor(String counselor) {
		this.counselor = counselor;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public Long getId() {
		return id;
	}

	public Long getCreate_at() {
		return create_at;
	}

	public Long getUpdate_at() {
		return update_at;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setCreate_at(Long create_at) {
		this.create_at = create_at;
	}

	public void setUpdate_at(Long update_at) {
		this.update_at = update_at;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", create_at=" + create_at + ", update_at=" + update_at + ", name=" + name
				+ ", qq=" + qq + ", profession=" + profession + ", join_date=" + join_date + ", school=" + school
				+ ", online_id=" + online_id + ", daily_url=" + daily_url + ", declaration=" + declaration
				+ ", introducer=" + introducer + ", referee=" + referee + ", counselor=" + counselor + ", description="
				+ description + ", city=" + city + ", review=" + review + "]";
	}

}
