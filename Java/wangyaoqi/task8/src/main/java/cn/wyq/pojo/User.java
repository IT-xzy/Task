package cn.wyq.pojo;

import java.io.Serializable;

public class User implements Serializable {
    private static final long serialVersionUID = 1883838732853579826L;

    public int userId;
    public String userName;
    public String password;
    public String salt;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    @Override
    public String toString() {
        return "User{"+
                "id="+userId+
                ",userName='"+userName+'\''+
                ",password='"+password+'\''+
                ",salt='"+salt+'\''+
                "}";
    }
}
