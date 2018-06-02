package com.ssm.model;

import java.io.Serializable;

public class UserEmailReg implements Serializable {
    private static final long serialVersionUID = 132146284267383140L;
    private Long id;
    private String e_name;
    private String e_password;
    private String e_email;
    private Long create_at;
    private Long update_at;

    @Override
    public String toString() {
        return "UserEmailReg{" +
                "id=" + id +
                ", e_name='" + e_name + '\'' +
                ", e_password='" + e_password + '\'' +
                ", e_email='" + e_email + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getE_name() {
        return e_name;
    }

    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    public String getE_password() {
        return e_password;
    }

    public void setE_password(String e_password) {
        this.e_password = e_password;
    }

    public String getE_email() {
        return e_email;
    }

    public void setE_email(String e_email) {
        this.e_email = e_email;
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
}
