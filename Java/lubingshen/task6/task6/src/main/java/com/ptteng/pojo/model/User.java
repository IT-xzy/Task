/*create table if not exists`tb_user`(
`user_name` varchar(10) not null,
`user_key` varchar(50) not null,
`id` bigint auto_increment,
`create_at` bigint not null,
`update_at` bigint,
`login_at` bigint,
primary key(`id`),
unique `online`(`user_name`)
)engine = innodb default charset = utf8;*/
package com.ptteng.pojo.model;

import com.ptteng.utils.annotation.StringVerify;

import java.io.Serializable;

public class User implements Serializable {
    @StringVerify(minLength = 3,maxLength = 8,aliasName = "用户名",isNotIllegal = true)
    private String UserName;
    //密码长度是加密前的长度
    @StringVerify(minLength = 3,maxLength = 8,aliasName = "密码",isNotIllegal = false)
    private String UserKey;
    private Long loginAt;
    private Long createAt;
    private Long updateAt;
    private Long id;



    public User(String userName, String userKey) {
        UserName = userName;
        UserKey = userKey;
    }

    public User() {
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        this.UserName = userName;
    }

    public String getUserKey() {
        return UserKey;
    }

    public void setUserKey(String userKey) {
        this.UserKey = userKey;
    }

    public Long getLoginAt() {
        return loginAt;
    }

    public void setLoginAt(Long loginAt) {
        this.loginAt = loginAt;
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
        return "User{" +
                "UserName='" + UserName + '\'' +
                ", UserKey='" + UserKey + '\'' +
                ", loginAt=" + loginAt +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", id=" + id +
                '}';
    }
}
