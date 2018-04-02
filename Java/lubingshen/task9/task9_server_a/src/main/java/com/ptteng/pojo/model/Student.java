/*对应的mysql建表语句：
create table if not exists`tb_student`(
`student_name` varchar(10) not null,
`avatar` varchar(200),
`online_number` varchar(30),
`id` bigint auto_increment,
`create_at` bigint not null,
`update_at` bigint,
primary key(`id`),
unique `un_number`(`online_number`),
index (`student_name`)
)engine = innodb default charset = utf8;*/

package com.ptteng.pojo.model;

import java.io.Serializable;

public class Student implements Serializable {

    public Student() {

    }

    private String studentName;
    private String avatar;
    private String onlineNumber;
    private Long createAt;
    private Long updateAt;
    private Long id;

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getOnlineNumber() {
        return onlineNumber;
    }

    public void setOnlineNumber(String onlineNumber) {
        this.onlineNumber = onlineNumber;
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentName='" + studentName + '\'' +
                ", avatar='" + avatar + '\'' +
                ", number='" + onlineNumber + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", id=" + id +
                '}';
    }
}

