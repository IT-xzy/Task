package com.model;

import org.springframework.stereotype.Component;

/**
 * @Author qmz
 * @Description TODO
 * @Data 2018/6/23$ 15:23$
 **/
@Component
public class User {
    private long id;
    private String name;
    private int qq;
    private String type;
    private long time;
    private String school;
    private int stuId;
    private String link;
    private String sign;
    private String source;
    private String senior;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getStuId() {
        return stuId;
    }

    public void setStuId(int stuId) {
        this.stuId = stuId;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSenior() {
        return senior;
    }

    public void setSenior(String senior) {
        this.senior = senior;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qq=" + qq +
                ", type='" + type + '\'' +
                ", time=" + time +
                ", school='" + school + '\'' +
                ", stuId=" + stuId +
                ", link='" + link + '\'' +
                ", sign='" + sign + '\'' +
                ", source='" + source + '\'' +
                ", senior='" + senior + '\'' +
                '}';
    }
}
