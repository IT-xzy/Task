package com.ptteng.model;

import java.io.Serializable;

/**
 * @ClassName Note
 * @Description TODO
 * @Author 孙若飞
 * @Date 2019/3/10  10:16
 * @Version 1.0
 **/
public class Note implements Serializable{
    private static final long serialVersionUID = 2876171691255763255L;
    private int id;
    private long code;
    private long phone;
    private long createAt;

    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", phone='" + phone + '\'' +
                ", createAt=" + createAt +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(long createAt) {
        this.createAt = createAt;
    }
}
