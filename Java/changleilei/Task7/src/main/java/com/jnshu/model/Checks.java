package com.jnshu.model;

public class Checks {
    private Integer id;

    private String tel;

    private String email;

    private String tocheck;

    private String md5;

    private String salt;

    private Integer states;

    private Long createat;

    private Long updateat;

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTocheck() {
        return tocheck;
    }

    public void setTocheck(String tocheck) {
        this.tocheck = tocheck == null ? null : tocheck.trim();
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5 == null ? null : md5.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Integer getStates() {
        return states;
    }

    public void setStates(Integer states) {
        this.states = states;
    }

    public Long getCreateat() {
        return createat;
    }

    public void setCreateat(Long createat) {
        this.createat = createat;
    }

    public Long getUpdateat() {
        return updateat;
    }

    public void setUpdateat(Long updateat) {
        this.updateat = updateat;
    }

    @Override
    public String toString() {
        return "Checks{" + "id=" + id + ", tel='" + tel + '\'' + ", email='" + email + '\'' + ", tocheck='" + tocheck + '\'' + ", md5='" + md5 + '\'' + ", salt='" + salt + '\'' + ", states=" + states + ", createat=" + createat + ", updateat=" + updateat + '}';
    }
}