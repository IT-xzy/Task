package POJO;

import java.io.Serializable;

/**
 * @author: 曹樾
 * @program: task5-module
 * @description: 用户（登录使用）
 * @create: 2018/5/8 下午3:23
 */

public class User implements Serializable{
    private Integer ID;
    private String username;
    private String password;
    private String salt;
    private String desPassword;
    
    public User(Integer ID, String username, String password, String salt, String desPassword) {
        this.ID = ID;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.desPassword = desPassword;
    }
    
    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", salt='" + salt + '\'' +
                ", desPassword='" + desPassword + '\'' +
                '}';
    }
    
    public User() {
        super();
    }
    public Integer getID() {
        return ID;
    }
    
    public void setID(Integer ID) {
        this.ID = ID;
    }
    
    public String getUsername() {
        return username;
    }
    
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
    
    public String getSalt() {
        return salt;
    }
    
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }
    
    public String getDesPassword() {
        return desPassword;
    }
    
    public void setDesPassword(String desPassword) {
        this.desPassword = desPassword == null ? null : desPassword.trim();
    }
    
}
