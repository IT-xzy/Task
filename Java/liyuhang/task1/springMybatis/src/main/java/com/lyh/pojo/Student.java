package com.lyh.pojo;

public class Student {
    private int id;
    private String name;
    private int qq;
    private String wish;
    private String school;
    private int enrolmentTime;
    private String type;
    private String knowFrom;
    private int createAt;
    private int updateAt;
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

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public int getEnrolmentTime() {
        return enrolmentTime;
    }

    public void setEnrolmentTime(int enrolmentTime) {
        this.enrolmentTime = enrolmentTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getKnowFrom() {
        return knowFrom;
    }

    public void setKnowFrom(String knowFrom) {
        this.knowFrom = knowFrom;
    }

    public int getCreateAt() {
        return createAt;
    }

    public void setCreateAt(int createAt) {
        this.createAt = createAt;
    }

    public int getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(int updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "students[id = "+id+",name = "+name+",qq = "+qq+",wish = "+wish+",school = "+school+",enrolmentTime = "+enrolmentTime+"," +
                "type = "+type+",knowFrom = "+knowFrom+",createAt = "+createAt+",updateAt = "+updateAt+"]";
    }
}
