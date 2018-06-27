package com.jnshu.model;
public class Position {
    private Integer id;
    private String position;
    private String introduction;
    private String threshold;
    private String difficulty;
    private String growth;
    private String scarcity;
    private String experienceone;
    private String payone;
    private String experiencetwo;
    private String paytwo;
    private String experiencethree;
    private String paythree;
    private String partner;
    private String prompt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position == null ? null : position.trim();
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction == null ? null : introduction.trim();
    }

    public String getThreshold() {
        return threshold;
    }

    public void setThreshold(String threshold) {
        this.threshold = threshold == null ? null : threshold.trim();
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty == null ? null : difficulty.trim();
    }

    public String getGrowth() {
        return growth;
    }

    public void setGrowth(String growth) {
        this.growth = growth == null ? null : growth.trim();
    }

    public String getScarcity() {
        return scarcity;
    }

    public void setScarcity(String scarcity) {
        this.scarcity = scarcity == null ? null : scarcity.trim();
    }

    public String getExperienceone() {
        return experienceone;
    }

    public void setExperienceone(String experienceone) {
        this.experienceone = experienceone == null ? null : experienceone.trim();
    }

    public String getPayone() {
        return payone;
    }

    public void setPayone(String payone) {
        this.payone = payone == null ? null : payone.trim();
    }

    public String getExperiencetwo() {
        return experiencetwo;
    }

    public void setExperiencetwo(String experiencetwo) {
        this.experiencetwo = experiencetwo == null ? null : experiencetwo.trim();
    }

    public String getPaytwo() {
        return paytwo;
    }

    public void setPaytwo(String paytwo) {
        this.paytwo = paytwo == null ? null : paytwo.trim();
    }

    public String getExperiencethree() {
        return experiencethree;
    }

    public void setExperiencethree(String experiencethree) {
        this.experiencethree = experiencethree == null ? null : experiencethree.trim();
    }

    public String getPaythree() {
        return paythree;
    }

    public void setPaythree(String paythree) {
        this.paythree = paythree == null ? null : paythree.trim();
    }

    public String getPartner() {
        return partner;
    }

    public void setPartner(String partner) {
        this.partner = partner == null ? null : partner.trim();
    }

    public String getPrompt() {
        return prompt;
    }

    public void setPrompt(String prompt) {
        this.prompt = prompt == null ? null : prompt.trim();
    }
}