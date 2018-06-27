package com.jnshu.entity;

public class profession {

    private long id;
    private String name;
    //头像
    private String picture_tx;
    //职业
    private String pro_js;
    //公司
    private String proCompany;
    //在学
    private String pro_zx;
    //提示
    private String pro_ts;
    //详细介绍
    private String useryq;

    //创建人
    private String create_by;
    //更新人
    private String update_by;
    //创建时间
    private long create_at;
    //更新时间
    private long update_at;


    @Override
    public String toString(){
        return "profession{" +
                "id=" + id +
                ",picture_tx='" + picture_tx + '\'' +
                ",profession_zy='" + pro_js + '\'' +
                ",proCompany='" + proCompany + '\'' +
                ",pro_zx='" + pro_zx + '\'' +
                ",pro_ts='" + pro_ts +'\'' +
                ",useryq='" + useryq + '\'' +
                ",create_by='" + create_by + '\'' +
                ",update_by='" +update_by + '\'' +
                ",create_at='" + create_at + '\'' +
                ",update_at='" + update_at + '\'' +
                "}";
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

    public String getPicture_tx() {
        return picture_tx;
    }

    public void setPicture_tx(String picture_tx) {
        this.picture_tx = picture_tx;
    }

    public String getPro_js(){
        return pro_js;
    }

    public void setPro_js(String pro_js) {
        this.pro_js = pro_js;
    }

    public String getProCompany() {
        return proCompany;
    }

    public void setProCompany(String proCompany) {
        this.proCompany = proCompany;
    }

    public String getPro_zx() {
        return pro_zx;
    }

    public void setPro_zx(String pro_zx) {
        this.pro_zx = pro_zx;
    }

    public String getPro_ts() {
        return pro_ts;
    }

    public void setPro_ts(String pro_ts) {
        this.pro_ts = pro_ts;
    }

    public String getUseryq() {
        return useryq;
    }

    public void setUseryq(String useryq) {
        this.useryq = useryq;
    }

    public String getCreate_by() {
        return create_by;
    }

    public void setCreate_by(String create_by) {
        this.create_by = create_by;
    }

    public String getUpdate_by() {
        return update_by;
    }

    public void setUpdate_by(String update_by) {
        this.update_by = update_by;
    }

    public long getCreate_at() {
        return create_at;
    }

    public void setCreate_at(long create_at) {
        this.create_at = create_at;
    }

    public long getUpdate_at() {
        return update_at;
    }

    public void setUpdate_at(long update_at) {
        this.update_at = update_at;
    }
}
