package pojo;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = -72406582300139462L;
    private Integer id;//not null
    private String name;//not null
    private Integer studentNum;//学号not null
    private String entranceDate;//入学时间not null
    private String graduatedDate;//毕业时间
    private String isWork;//是否工作not null
    private String career;//工作职业
    private String duty;//工作职责
    private String isExcellent;//是否是优秀学员
    private Long createdDate;//创建时间not null
    private Long updatedDate;//更新时间

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", studentNum=" + studentNum +
                ", entranceDate=" + entranceDate +
                ", graduatedDate=" + graduatedDate +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                ", career='" + career + '\'' +
                ", duty='" + duty + '\'' +
                ", isExcellent='" + isExcellent + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(Integer studentNum) {
        this.studentNum = studentNum;
    }

    public String getEntranceDate() {
        return entranceDate;
    }

    public void setEntranceDate(String entranceDate) {
        this.entranceDate = entranceDate;
    }

    public String getGraduatedDate() {
        return graduatedDate;
    }

    public void setGraduatedDate(String graduatedDate) {
        this.graduatedDate = graduatedDate;
    }

    public Long getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Long createdDate) {
        this.createdDate = createdDate;
    }

    public Long getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Long updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getIsWork() {
        return isWork;
    }

    public void setIsWork(String isWork) {
        this.isWork = isWork;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getDuty() {
        return duty;
    }

    public void setDuty(String duty) {
        this.duty = duty;
    }

    public String getIsExcellent() {
        return isExcellent;
    }

    public void setIsExcellent(String isExcellent) {
        this.isExcellent = isExcellent;
    }
}
