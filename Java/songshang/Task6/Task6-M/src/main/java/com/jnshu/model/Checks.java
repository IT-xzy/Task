package com.jnshu.model;
import java.io.Serializable;

public class Checks implements Serializable {
    private static final long serialVersionUID = -3896605600471191953L;
    private Integer id;

    private String tel;

    private String ToCheck;

    private Long createAt;

    private Long updateAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getToCheck() {
        return ToCheck;
    }

    public void setToCheck(String toCheck) {
        this.ToCheck = toCheck == null ? null : toCheck.trim();
    }

    public Long getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Long createAt) {
        this.createAt = createAt;
    }

    public Long getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Long updateAt) {
        this.updateAt = updateAt;
    }
}