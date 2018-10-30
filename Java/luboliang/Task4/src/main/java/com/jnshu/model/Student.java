package com.jnshu.model;

public class Student {
    private long id;
    private String name;
    private String profession;
    private String position;
    private String overview;
    private long salary;
    private long state;
    private String icon;
    private long create_at;
    private long update_at;
    private long entrance_time;

    public long getEntrance_time() {
        return entrance_time;
    }

    public void setEntrance_time(long entrance_time) {
        this.entrance_time = entrance_time;
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

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public long getState() {
        return state;
    }

    public void setState(long state) {
        this.state = state;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
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

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", profession='" + profession + '\'' +
                ", position='" + position + '\'' +
                ", overview='" + overview + '\'' +
                ", salary=" + salary +
                ", state=" + state +
                ", icon='" + icon + '\'' +
                ", create_at=" + create_at +
                ", update_at=" + update_at +
                ", entrance_time=" + entrance_time +
                '}';
    }
}
