package com.ev.entity;

import java.io.Serializable;

public class StudentGeneralInfo  implements Serializable {

    private int isLearning;
    private int isWorking;
    private int java;
    private int css;
    private int js;
    private int op;
    private int pm;
    private int python;
    private int qa;
    private int ios;
    private int android;
    private Long createAt;
    private Long updateAt;
    private Long id;

    public int getIsLearning() {
        return isLearning;
    }

    public void setIsLearning(int isLearning) {
        this.isLearning = isLearning;
    }

    public int getIsWorking() {
        return isWorking;
    }

    public void setIsWorking(int isWorking) {
        this.isWorking = isWorking;
    }

    public int getJava() {
        return java;
    }

    public void setJava(int java) {
        this.java = java;
    }

    public int getCss() {
        return css;
    }

    public void setCss(int css) {
        this.css = css;
    }

    public int getJs() {
        return js;
    }

    public void setJs(int js) {
        this.js = js;
    }

    public int getOp() {
        return op;
    }

    public void setOp(int op) {
        this.op = op;
    }

    public int getPm() {
        return pm;
    }

    public void setPm(int pm) {
        this.pm = pm;
    }

    public int getPython() {
        return python;
    }

    public void setPython(int python) {
        this.python = python;
    }

    public int getQa() {
        return qa;
    }

    public void setQa(int qa) {
        this.qa = qa;
    }

    public int getIos() {
        return ios;
    }

    public void setIos(int ios) {
        this.ios = ios;
    }

    public int getAndroid() {
        return android;
    }

    public void setAndroid(int android) {
        this.android = android;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public StudentGeneralInfo() {
    }

    public StudentGeneralInfo(int isLearning, int isWorking, int java, int css, int js, int op, int pm, int python, int qa, int ios, int android, Long createAt, Long updateAt) {
        this.isLearning = isLearning;
        this.isWorking = isWorking;
        this.java = java;
        this.css = css;
        this.js = js;
        this.op = op;
        this.pm = pm;
        this.python = python;
        this.qa = qa;
        this.ios = ios;
        this.android = android;
        this.createAt = createAt;
        this.updateAt = updateAt;
    }

    @Override
    public String toString() {
        return "StudentGeneralInfoDAO{" +
                "isLearning=" + isLearning +
                ", isWorking=" + isWorking +
                ", java=" + java +
                ", css=" + css +
                ", js=" + js +
                ", op=" + op +
                ", pm=" + pm +
                ", python=" + python +
                ", qa=" + qa +
                ", ios=" + ios +
                ", android=" + android +
                ", createAt=" + createAt +
                ", updateAt=" + updateAt +
                ", id=" + id +
                '}';
    }
}
