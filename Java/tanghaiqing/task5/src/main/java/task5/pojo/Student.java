package task5.pojo;

public class Student {
    private Integer stuId;
    private String name;
    private String gender;
    private Integer age;
    private Long schoolTime;
    private String job;
    private String graduate;
    private String takingWork;
    private Long createTime;
    private Long updateTime;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getSchoolTime() {
        return schoolTime;
    }

    public void setSchoolTime(Long schoolTime) {
        this.schoolTime = schoolTime;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getGraduate() {
        return graduate;
    }

    public void setGraduate(String graduate) {
        this.graduate = graduate;
    }

    public String getTakingWork() {
        return takingWork;
    }

    public void setTakingWork(String takingWork) {
        this.takingWork = takingWork;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                ", schoolTime=" + schoolTime +
                ", job='" + job + '\'' +
                ", graduate='" + graduate + '\'' +
                ", takingWork='" + takingWork + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
