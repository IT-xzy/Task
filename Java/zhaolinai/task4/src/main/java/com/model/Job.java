package com.model;

public class Job {
    private long id;
    private String img;
    private String name;
    private String introduce;
    private int doorsill;
    private int index;
    private String grow;
    private long needed;
    private String time1;
    private String time2;
    private String time3;
    private String salary1;
    private String salary2;
    private String salary3;
    private long numble;
    private String language;
    private String status;
    private String background;

    private long count;

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }



    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public int getDoorsill() {
        return doorsill;
    }

    public void setDoorsill(int doorsill) {
        this.doorsill = doorsill;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getGrow() {
        return grow;
    }

    public void setGrow(String grow) {
        this.grow = grow;
    }

    public long getNeeded() {
        return needed;
    }

    public void setNeeded(long needed) {
        this.needed = needed;
    }

    public String getTime1() {
        return time1;
    }

    public void setTime1(String time1) {
        this.time1 = time1;
    }

    public String getTime2() {
        return time2;
    }

    public void setTime2(String time2) {
        this.time2 = time2;
    }

    public String getTime3() {
        return time3;
    }

    public void setTime3(String time3) {
        this.time3 = time3;
    }

    public String getSalary1() {
        return salary1;
    }

    public void setSalary1(String salary1) {
        this.salary1 = salary1;
    }

    public String getSalary2() {
        return salary2;
    }

    public void setSalary2(String salary2) {
        this.salary2 = salary2;
    }

    public String getSalary3() {
        return salary3;
    }

    public void setSalary3(String salary3) {
        this.salary3 = salary3;
    }

    public long getNumble() {
        return numble;
    }

    public void setNumble(long numble) {
        this.numble = numble;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Job{" +
                "id=" + id +
                ", img='" + img + '\'' +
                ", name='" + name + '\'' +
                ", introduce='" + introduce + '\'' +
                ", doorsill=" + doorsill +
                ", index=" + index +
                ", grow='" + grow + '\'' +
                ", needed=" + needed +
                ", time1='" + time1 + '\'' +
                ", time2='" + time2 + '\'' +
                ", time3='" + time3 + '\'' +
                ", salary1='" + salary1 + '\'' +
                ", salary2='" + salary2 + '\'' +
                ", salary3='" + salary3 + '\'' +
                ", numble=" + numble +
                ", language='" + language + '\'' +
                ", status='" + status + '\'' +
                ", background='" + background + '\'' +

                ", count=" + count +
                '}';
    }
}
