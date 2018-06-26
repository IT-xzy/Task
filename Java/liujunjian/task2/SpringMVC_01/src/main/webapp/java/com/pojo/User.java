package com.pojo;

import java.text.SimpleDateFormat;

public class User {
    private Integer id;
    private String name;
    private String number;
    private Long create_at;
    private Long update_at;

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

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
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

    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return "学生:id=" + id + ", name=" + name + ", number=" + number
                + ", create_at:" + df.format(create_at) + ", update_at:" + df.format(update_at);
    }
}
