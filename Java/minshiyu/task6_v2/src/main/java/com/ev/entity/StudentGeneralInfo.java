package com.ev.entity;

public class StudentGeneralInfo {

    //在学总人数
    private int isLearning;
    //找到工作人数
    private int isWorking;
    //java人数
    private int java;
    //css人数
    private int css;
    //js人数
    private int js;
    //op人数
    private int op;
    //pm人数
    private int pm;
    //python人数
    private int python;
    //qa人数
    private int qa;
    //ios人数
    private int ios;
    //android人数
    private int android;
    //创建时间
    private Long createAt;
    //更新时间
    private Long updateAt;
    //数据库id
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
