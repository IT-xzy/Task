package pojo;

import java.util.List;

public class Career {
	/**
	 * int id 职位id
	 * String name 职位名称
	 * String detail 职位描述
	 * int threshold 职位门槛
	 * int diffcult 职位难易程度
	 * String growing 成长周期
	 * int need 职位空缺
	 * salary* 薪资阶段
	 * Years* 工作年限
	 * String picture 图片路径
	 */
	private int id;
	private String  name;
	private String detail;
	private int threshold;
	private int diffcult;
	private String growing;
	private int need;
	private String salary1;
	private String salary2;
	private String salary3;
	private String years1;
	private String years2;
	private String years3;
	private String picture;
	private String students_number;

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

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public int getThreshold() {
		return threshold;
	}

	public void setThreshold(int threshold) {
		this.threshold = threshold;
	}

	public int getDiffcult() {
		return diffcult;
	}

	public void setDiffcult(int diffcult) {
		this.diffcult = diffcult;
	}

	public String getGrowing() {
		return growing;
	}

	public void setGrowing(String growing) {
		this.growing = growing;
	}

	public int getNeed() {
		return need;
	}

	public void setNeed(int need) {
		this.need = need;
	}

	public String getSalary1() {
		return salary1;
	}

	public void setSalary1(String salary1) {
		this.salary1 = salary1;
	}

	public String getSalary2() {
		return salary2;
	}

	public void setSalary2(String salary2) {
		this.salary2 = salary2;
	}

	public String getSalary3() {
		return salary3;
	}

	public void setSalary3(String salary3) {
		this.salary3 = salary3;
	}

	public String getYears1() {
		return years1;
	}

	public void setYears1(String years1) {
		this.years1 = years1;
	}

	public String getYears2() {
		return years2;
	}

	public void setYears2(String years2) {
		this.years2 = years2;
	}

	public String getYears3() {
		return years3;
	}

	public void setYears3(String years3) {
		this.years3 = years3;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getStudents_number() {
		return students_number;
	}

	public void setStudents_number(String students_number) {
		this.students_number = students_number;
	}
}
