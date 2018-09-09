package com.ptteng;

public class User {
    private long id;
    private String name;
    private long QQ;
    private String wish;
    private long createAt;
    private long updateAt;

    public User() {
    }

    public User(long id, String name, long QQ, String wish, long createAt, long updateAt) {
        this.id = id;
        this.name = name;
        this.QQ = QQ;
        this.wish = wish;
        this.createAt = createAt;
        this.updateAt = updateAt;
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

    public long getQQ() {
        return QQ;
    }

    public void setQQ(long QQ) {
        this.QQ = QQ;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
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

    public String toString() {
        return "id=" + id + ",name=" + name + ",QQ=" + QQ + ",wish=" + wish + ",createAt=" + createAt + ",updateAt=" + updateAt;
    }

}
