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

package com.ptteng.bean;

public class Graduate {
    public Graduate() {
    }

    public Graduate(String name, String avatar, String message) {
        this.name = name;
        this.avatar = avatar;
        this.message = message;
    }

    private String name;
    private String avatar;
    private String message;
    private Long id;
    private Long createAt;
    private Long updateAt;
    private Long studentId;
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

    public String toString() {
        return "毕业生信息：\n姓名：" + name + "\n当前信息：" + message;
    }
}
