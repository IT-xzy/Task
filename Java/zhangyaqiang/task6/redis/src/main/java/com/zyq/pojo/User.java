package com.zyq.pojo;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 449220016769021650L;

    private Integer id;
    private String name;
    private String username;

    private String salt;
    private String password;
    private Long createAt;
    private Long updateAt;

    public User() {
    }

    public User(Integer id, String name, String username, String salt, String password, Long createAt, Long updateAt) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.salt = salt;
        this.password = password;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", salt='" + salt + '\'' +
                ", password='" + password + '\'' +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
}
