package com.jnshu.model;

import java.io.Serializable;

public class User implements Serializable {

    private static final long serialVersionUID = 89756313569789218L;


    private Long id;
    private String name;
    private String career;
    private String email;
    private Long createtime;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Long createtime) {
        this.createtime = createtime;
    }


    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", career='" + career + '\'' +
                ", email='" + email + '\'' +
                ", createtime=" + createtime +
                '}';
    }


}
