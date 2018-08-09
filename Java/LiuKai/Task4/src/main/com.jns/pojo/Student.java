package pojo;

public class Student {
    private long id;
    private String stuName;
    private String course;
    private long createTime;
    private long updateTime;
    private String job;
    private String selfIntro;
    private String good;

    public Student(){}

    @Override
    public String toString() {
        return "学员[id]"+id+
                " 姓名"+stuName+
                " 课程"+course+

                "]";
    }

    public long getId() {
        return id;
    }

    public Student setId(long id) {
        this.id = id;
        return this;
    }

    public String getStuName() {
        return stuName;
    }

    public Student setStuName(String stuName) {
        this.stuName = stuName;
        return this;
    }

    public String getCourse() {
        return course;
    }

    public Student setCourse(String course) {
        this.course = course;
        return this;
    }

    public long getCreateTime() {
        return createTime;
    }

    public Student setCreateTime(long createTime) {
        this.createTime = createTime;
        return this;
    }

    public long getUpdateTime() {
        return updateTime;
    }

    public Student setUpdateTime(long updateTime) {
        this.updateTime = updateTime;
        return this;
    }

    public String getJob() {
        return job;
    }

    public Student setJob(String job) {
        this.job = job;
        return this;
    }

    public String getSelfIntro() {
        return selfIntro;
    }

    public Student setSelfIntro(String selfIntro) {
        this.selfIntro = selfIntro;
        return this;
    }

    public String getGood() {
        return good;
    }

    public Student setGood(String good) {
        this.good = good;
        return this;
    }
}
