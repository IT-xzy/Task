/*
对应的mysql建表语句：
create table if not exists`students`(
`name` varchar(10) not null,
`QQ` varchar(15) not null,
`type` varchar(10) not null,
`admission_time` varchar(20) not null,
`school` varchar(10) not null,
`num` varchar(10) not null,
`daily` varchar(100) not null,
`declaration` varchar(50) not null,
`elder` varchar(30) not null,
`knew_from` varchar(10) not null,
`ID` bigint auto_increment,
`create_at` bigint not null,
`update_at` bigint,
primary key(`id`),
index (`name`),
unique `online`(`num`)
)engine = innodb default charset = utf8;
 */

package com.ppteng.pojo;


public class Student {

    public Student() {

    }

    public Student(String name, String qq, String type, String admissionTime, String school,
                   String num, String daily, String declaration, String elder, String knewFrom) {
        this.name = name;
        this.qq = qq;
        this.type = type;
        this.admissionTime = admissionTime;
        this.school = school;
        this.num = num;
        this.daily = daily;
        this.declaration = declaration;
        this.elder = elder;
        this.knewFrom = knewFrom;
    }

    private String name;
    private String qq;
    private String type;
    private String admissionTime;
    private String school;
    private String num;
    private String daily;
    private String declaration;
    private String elder;
    private String knewFrom;
    private long createAt;
    private long updateAt;
    private long id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQQ() {
        return qq;
    }

    public void setQQ(String qq) {
        this.qq = qq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdmissionTime() {
        return admissionTime;
    }

    public void setAdmissionTime(String admissionTime) {
        this.admissionTime = admissionTime;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getDaily() {
        return daily;
    }

    public void setDaily(String daily) {
        this.daily = daily;
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration;
    }

    public String getElder() {
        return elder;
    }

    public String getKnewFrom() {
        return knewFrom;
    }

    public void setKnewFrom(String knewFrom) {
        this.knewFrom = knewFrom;
    }

    public void setElder(String elder) {
        this.elder = elder;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return ("姓名：" + name + "\nQQ：" + qq + "\n修真类型：" + type + "\n预计入学时间：" + admissionTime
                + "\n毕业院校：" + school + "\n线上学号：" + num + "\n日报链接：" + daily
                + "\n立愿：" + declaration + "\n辅导师兄：" + elder + "\n从何处了解：" + knewFrom);
    }

}
