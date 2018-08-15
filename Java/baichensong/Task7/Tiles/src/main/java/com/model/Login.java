package com.model;

import java.io.Serializable;

//注册 pojo
public class Login implements Serializable {
    private static final long serialVersionUID = 123L;
    private int id;
    private String username;
    private int studentID;
    private String userpass;
    private Long create_at;
    private Long update_at;
    private Long landtime;
    private String actiCode;
    private String email;
    private int state;


    public Long getLandtime() {
        return landtime;
    }

    public void setLandtime(Long landtime) {
        this.landtime = landtime;
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

    public String getUserpass() {
        return userpass;
    }

    public void setUserpass(String userpass) {
        this.userpass = userpass;
    }

    public Long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(Long create_at) {
        this.create_at = create_at;
    }

    public Long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(Long update_at) {
        this.update_at = update_at;
    }
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getActiCode() {
        return actiCode;
    }

    public void setActiCode(String actiCode) {
        this.actiCode = actiCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Login{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", studentID=" + studentID +
                ", userpass='" + userpass + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", landtime=" + landtime +
                ", actiCode='" + actiCode + '\'' +
                ", email='" + email + '\'' +
                ", state=" + state +
                '}';
    }
}
