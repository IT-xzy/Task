package com.jnshu.entity;

public class student {

    private long id;
    private String name;
    private String picture_tx;
    private String  state_ms;


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
        return "student{" +
                "id=" + id +
                ",name='" + name + '\'' +
                ",picture_tx='" + picture_tx + '\'' +
                ",state_ms='" + state_ms + '\'' +
                ",create_by='" + create_by + '\'' +
                ",update_by='" + update_by + '\'' +
                ",create_at='" + create_at +
                ",update_at='" + update_at +
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

    public String  getState_ms() {
        return state_ms;
    }

    public void setState_ms(String  state_ms) {
        this.state_ms = state_ms;
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
