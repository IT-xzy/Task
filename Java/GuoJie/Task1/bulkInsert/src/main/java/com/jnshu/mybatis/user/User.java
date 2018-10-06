package com.jnshu.mybatis.user;

import java.util.List;

/*
* 创建于2018-9-29
* mybatis整合,包括mmybatis,dao,mapper
* 动态sql,foreach,trim标签的使用
* 别名的使用
* */
public class User {
    private int id;
    private String  name;
    private String email;
    private List<Integer> ids;
    public User(){
    }

    public List<Integer> getIds() {
        return ids;
    }

    public void setIds(List<Integer> ids) {
        this.ids = ids;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override


    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
