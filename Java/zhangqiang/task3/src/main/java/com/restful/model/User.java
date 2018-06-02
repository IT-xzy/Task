package com.restful.model;

import java.io.Serializable;

public class User implements Serializable{

    private int id;
    private String name;
    private String pwd;
    private long qq;
    private String email;
    private String address;
    private long tell;
    private long createAt;
    private long updateAt;

    @Override
    public String toString() {
        return "\n用户信息：{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pwd='" + pwd + '\'' +
                ", qq=" + qq +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", tell=" + tell +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                "}\n";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public long getQq() {
        return qq;
    }

    public void setQq(long qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getTell() {
        return tell;
    }

    public void setTell(long tell) {
        this.tell = tell;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }

    public long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(long updateAt) {
        this.updateAt = updateAt;
    }
}
