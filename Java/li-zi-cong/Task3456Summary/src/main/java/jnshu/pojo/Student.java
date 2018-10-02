package jnshu.pojo;

public class Student implements java.io.Serializable{
    private static final long serialVersionUID = 1L;

    private Integer id;

    private String student_name;

    private String icon;

    private String introduce;

    private Byte excellent;

    private String job;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name == null ? null : student_name.trim();
    }

    public String getIcon() {
        return icon;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public Byte getExcellent() {
        return excellent;
    }

    public void setExcellent(Byte excellent) {
        this.excellent = excellent;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job == null ? null : job.trim();
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentName='" + student_name + '\'' +
                ", icon='" + icon + '\'' +
                ", introduce='" + introduce + '\'' +
                ", excellent=" + excellent +
                ", job='" + job + '\'' +
                '}';
    }
}