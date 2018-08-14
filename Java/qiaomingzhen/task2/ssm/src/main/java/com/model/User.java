package com.model;

/**
 * @Author qmz
 * @Description TODO
 * @Data 2018/7/4$ 10:32$
 **/
public class User {
    private Long id;
    private String name;
    private String type;
    private int qq;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQq() {
        return qq;
    }

    public void setQq(int qq) {
        this.qq = qq;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", qq=" + qq +
                '}';
    }
}
