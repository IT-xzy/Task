package com.jnshu.task1.annotation.pojo;
import java.util.Date;
public class StudentInfo {
    private Integer id;
    private String student_name;
    private Integer qq;
    private String learn_type;
    private Date join_time;
    private String school;
    private Integer student_id;
    private String link;
    private String motto;
    private String brother;
    private String know_from;

    public StudentInfo(Integer id, String student_name, Integer qq, String learn_type, Date join_time, String school, Integer student_id, String link, String motto, String brother, String know_from) {
        this.id = id;
        this.student_name = student_name;
        this.qq = qq;
        this.learn_type = learn_type;
        this.join_time = join_time;
        this.school = school;
        this.student_id = student_id;
        this.link = link;
        this.motto = motto;
        this.brother = brother;
        this.know_from = know_from;
    }

    public StudentInfo() {
        super();
    }

    @Override
    public String toString() {
        return "StudentInfo{" +
                "id=" + id +
                ", student_name='" + student_name + '\'' +
                ", qq=" + qq +
                ", learn_type='" + learn_type + '\'' +
                ", join_time=" + join_time +
                ", school='" + school + '\'' +
                ", student_id=" + student_id +
                ", link='" + link + '\'' +
                ", motto='" + motto + '\'' +
                ", brother='" + brother + '\'' +
                ", know_from='" + know_from + '\'' +
                '}';
    }
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
        this.student_name = student_name;
    }

    public Integer getQq() {
        return qq;
    }

    public void setQq(Integer qq) {
        this.qq = qq;
    }

    public String getLearn_type() {
        return learn_type;
    }

    public void setLearn_type(String learn_type) {
        this.learn_type = learn_type;
    }

    public Date getJoin_time() {
        return join_time;
    }

    public void setJoin_time(Date join_time) {
        this.join_time = join_time;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public String getBrother() {
        return brother;
    }

    public void setBrother(String brother) {
        this.brother = brother;
    }

    public String getKnow_from() {
        return know_from;
    }

    public void setKnow_from(String know_from) {
        this.know_from = know_from;
    }
}






