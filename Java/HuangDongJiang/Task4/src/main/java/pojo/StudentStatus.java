package pojo;

public class StudentStatus {
	/**
	 * id 学员的id
	 * name 学员姓名
	 * condition 学员的状态 有"在学"和"工作"两种状态
	 * excellent 是否是优秀学员 有"是"和"否"两种状态
	 * picture 学员照片
	 * career 学员职业
	 * career_description 职业描述
	 */
	private int id;
	private String name;
	private String student_condition;
	private int grade;
	private String picture;
	private String career;
	private String career_description;

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

	public String getStudent_condition() {
		return student_condition;
	}

	public void setStudent_condition(String student_condition) {
		this.student_condition = student_condition;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getCareer() {
		return career;
	}

	public void setCareer(String career) {
		this.career = career;
	}

	public String getCareer_description() {
		return career_description;
	}

	public void setCareer_description(String career_description) {
		this.career_description = career_description;
	}

	@Override
	public String toString() {
		return "StudentStatus{" +
				"id=" + id +
				", name='" + name + '\'' +
				", student_condition='" + student_condition + '\'' +
				", grade=" + grade +
				", picture='" + picture + '\'' +
				", career='" + career + '\'' +
				", career_description='" + career_description + '\'' +
				'}';
	}
}
