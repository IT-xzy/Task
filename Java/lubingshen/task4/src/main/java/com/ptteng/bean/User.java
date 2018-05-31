/*create table if not exists`tb_user`(
`user_name` varchar(10) not null,
`user_key` varchar(15) not null,
`id` bigint auto_increment,
`create_at` bigint not null,
`update_at` bigint,
`login_at` bigint,
primary key(`id`),
unique `online`(`user_name`)
)engine = innodb default charset = utf8;*/
package com.ptteng.bean;

import com.ptteng.utils.annotation.StringVerify;

public class User {
    @StringVerify(minLength = 2,maxLength = 8,aliasName = "用户名")
    private String UserName;
    @StringVerify(minLength = 2,maxLength = 8,aliasName = "用户名")
    private String UserKey;
    private Long loginAt;
    private Long createAt;
    private Long updateAt;
    private Long id;

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
}
