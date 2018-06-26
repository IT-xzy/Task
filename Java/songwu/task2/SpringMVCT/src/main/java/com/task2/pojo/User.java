package com.task2.pojo;

import java.text.SimpleDateFormat;

public class User {
    private long id;
    private String name;
    private String qq;
    private String type;
    private long createAt;
    private long updateAt;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    @Override
    public String toString() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
        String create = simpleDateFormat.format(createAt);
        String update = simpleDateFormat.format(updateAt);
        return "User{" +
                "编号=" + id +
                ", 姓名='" + name + '\'' +
                ", qq='" + qq + '\'' +
                ", 修真类型='" + type + '\'' +
                ", 创建时间=" + create +
                ", 修改时间=" + update +"\n"+
                '}';
    }
}
