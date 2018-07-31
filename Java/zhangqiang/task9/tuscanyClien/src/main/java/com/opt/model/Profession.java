package com.opt.model;

import java.io.Serializable;

public class Profession implements Serializable {

    private int id;

    private String proName;

//    职业介绍
    private String proPresentation;

//    门槛
    private int difficulty;

//    难易度
    private int level;

//    周期
    private String cycle;

//    稀缺性 需求公司数量
    private String scarcity;

//    待遇
    private int emolument_min;
    private int emolument_max;

//    方向
    private String direction;

//    提示
    private String remind;

    private long create_at;

    private long update_at;

    private String proPhoto;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public String getProPresentation() {
        return proPresentation;
    }

    public void setProPresentation(String proPresentation) {
        this.proPresentation = proPresentation;
    }

    public int getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(int difficulty) {
        this.difficulty = difficulty;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public String getScarcity() {
        return scarcity;
    }

    public void setScarcity(String scarcity) {
        this.scarcity = scarcity;
    }

    public int getEmolument_min() {
        return emolument_min;
    }

    public void setEmolument_min(int emolument_min) {
        this.emolument_min = emolument_min;
    }

    public int getEmolument_max() {
        return emolument_max;
    }

    public void setEmolument_max(int emolument_max) {
        this.emolument_max = emolument_max;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public String getRemind() {
        return remind;
    }

    public void setRemind(String remind) {
        this.remind = remind;
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

    public String getProPhoto() {
        return proPhoto;
    }

    public void setProPhoto(String proPhoto) {
        this.proPhoto = proPhoto;
    }

    @Override
    public String toString() {
        return "Profession{" +
                "id=" + id +
                ", proName='" + proName + '\'' +
                ", proPresentation='" + proPresentation + '\'' +
                ", difficulty=" + difficulty +
                ", level=" + level +
                ", cycle='" + cycle + '\'' +
                ", scarcity='" + scarcity + '\'' +
                ", emolument_min=" + emolument_min +
                ", emolument_max=" + emolument_max +
                ", direction='" + direction + '\'' +
                ", remind='" + remind + '\'' +
                ", create_at=" + create_at +
                ", upeate_at=" + update_at +
                ", proPhoto='" + proPhoto + '\'' +
                '}';
    }


}
