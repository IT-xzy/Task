/*对应的mysql建表语句：
create table if not exists`tb_graduates`(
`name` varchar(20) not null,
`avatar` varchar(20) not null,
`message` varchar(200) not null,
`ID` bigint auto_increment,
`create_at` bigint not null,
`update_at` bigint,
primary key(`id`)
)engine = innodb default charset = utf8;*/

package com.ptteng.pojo.model;

import com.ptteng.utils.annotation.StringVerify;

import java.io.Serializable;

public class Graduate implements Serializable {
    public Graduate() {
    }

    public Graduate(String name, String avatar, String message) {
        this.name = name;
        this.avatar = avatar;
        this.message = message;
    }

    @StringVerify(maxLength = 15,aliasName = "毕业生姓名",isNotIllegal = true)
    private String name;
    @StringVerify(maxLength = 15,aliasName = "头像")
    private String avatar;
    @StringVerify(maxLength = 180,aliasName = "信息")
    private String message;
    private Long id;
    private Long createAt;
    private Long updateAt;
    private Long studentId;
    //如果希望不被序列化，可以加上transient修饰
    private Student student;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getStudentId() {
        return studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Graduate{" +
                "name='" + name + '\'' +
                ", avatar='" + avatar + '\'' +
                ", message='" + message + '\'' +
                ", id=" + id +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", studentId=" + studentId +
                ", student=" + student +
                '}';
    }

}
