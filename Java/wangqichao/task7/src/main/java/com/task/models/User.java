package com.task.models;

public class User {
    private int id;
    private long createdAt;
    private long updatedAt;
    private String username;
    private String password="";//此值不存进数据库
    private String salt;
    private String hashKey;
    private long loginTime=0;//此属性在注册时赋值为0，之后每次登陆重置

    public long getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(long loginTime) {
        this.loginTime = loginTime;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getHashKey() {
        return hashKey;
    }

    public void setHashKey(String hashKey) {
        this.hashKey = hashKey;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(long updatedAt) {
        this.updatedAt = updatedAt;
    }

//创建账号时使用,其中id是自增所以不需要，password因为不用保存所以也不用
    public User(long createdAt, String username, String salt, String hashKey) {
        this.createdAt = createdAt;
        this.username = username;
        this.salt = salt;
        this.hashKey = hashKey;
    }

    public User(long createdAt, String username, String password) {
        this.createdAt = createdAt;
        this.username = username;
        this.password = password;
    }

    public User() {
    }
//只修改登录时间时使用
    public User(String username,long loginTime) {
        this.username=username;
        this.loginTime = loginTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", hashKey='" + hashKey + '\'' +
                ", loginTime='" + loginTime + '\'' +

                '}';
    }
}
