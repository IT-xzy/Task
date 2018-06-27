package com.oto.pojo;

/**
 * @author: 刘军鹏
 * @program: task4
 * @description:
 * @create: 2018/6/9 上午9:28
 */

public class user {
    
    private Integer id;
    private String username;
    private String password;
    private Integer salt;
    
    public Integer getSalt() {
        return salt;
    }
    
    public void setSalt(Integer salt) {
        this.salt = salt;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
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
}
